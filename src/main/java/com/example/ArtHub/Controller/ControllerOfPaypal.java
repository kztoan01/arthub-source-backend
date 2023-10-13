package com.example.ArtHub.Controller;

import com.example.ArtHub.DTO.CartResponse;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Orders;
import com.example.ArtHub.Entity.OrdersDetails;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Repository.OrderDetailRepository;
import com.example.ArtHub.Repository.OrderRepository;
import com.example.ArtHub.Service.ServiceOfPaypal;
import com.example.ArtHub.config.PaypalPaymentIntent;
import com.example.ArtHub.config.PaypalPaymentMethod;
import com.example.ArtHub.utils.PayPalUtils;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ControllerOfPaypal {
    public static final String URL_PAYPAL_SUCCESS = "pay/success";
    public static final String URL_PAYPAL_CANCEL = "pay/cancel";
    @Autowired
    private ServiceOfPaypal serviceOfPaypal;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @PostMapping("/pay/{accountId}")
    public ResponseEntity<?> PaymentPaypal(@PathVariable Integer accountId, HttpServletRequest request){
        String cancelUrl = PayPalUtils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
        String successUrl = PayPalUtils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
        try{
            Optional<Account> accountOptional = accountRepository.findById(accountId);
            if (!accountOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Account is not exist");
            }
            List<Orders> orders = orderRepository.findByAccount(accountOptional.get());
            List<OrdersDetails> carItems = new ArrayList<>();
            Float totalAmount = 0F;
            for (Orders order : orders) {
                List<OrdersDetails> ordersDetails = orderDetailRepository.findByOrders(order);
                carItems.addAll(ordersDetails);
                for (OrdersDetails ordersDetails1 : ordersDetails) {
                    totalAmount += ordersDetails1.getFinalPrice();
                }


            }
            CartResponse cartResponse = new CartResponse(carItems, totalAmount);
            ResponseEntity.ok(cartResponse);
            Payment payment = serviceOfPaypal.createPayment(
                    cartResponse.getTotalAmount(),
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl
            );
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    // Trả về URL phê duyệt để bạn có thể chuyển hướng React đến đây
                    return ResponseEntity.ok(links.getHref());
                }
            }

        }catch (PayPalRESTException e){
            String errorMessage = "Payment was not approved.";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.badRequest().body("Payment was not approved.");
    }
    @GetMapping(URL_PAYPAL_CANCEL)
    public ResponseEntity<?> cancelPay() {
        // Xử lý các thao tác liên quan đến hủy bỏ
        String errorMessage = "Payment was canceled.";
        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public ResponseEntity<?> successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            // Thực hiện xử lý cho trạng thái thành công
            Payment payment = serviceOfPaypal.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return new ResponseEntity<>("Payment was successful.", HttpStatus.OK);
            }
        } catch (PayPalRESTException e) {
            String errorMessage = "Payment was not approved.";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Payment was not approved.", HttpStatus.BAD_REQUEST);
    }
}
