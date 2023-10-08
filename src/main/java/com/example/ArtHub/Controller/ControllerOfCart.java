package com.example.ArtHub.Controller;

import com.example.ArtHub.DTO.CartResponse;
import com.example.ArtHub.Entity.*;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Repository.OrderDetailRepository;
import com.example.ArtHub.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ControllerOfCart {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestParam Integer accountId, @RequestParam Integer courseId) {
        try {


            Optional<Course> courseOptional = courseRepository.findById(courseId);
            if (!courseOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Course is not exist");
            }
            Optional<Account> accountOptional = accountRepository.findById(accountId);
            if (!accountOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Account is not exist");
            }
            List<Orders> orders = orderRepository.findByAccountId(accountId);
            List<Integer> listOrderIdByAccountId = new ArrayList<>();
            for (Orders orders1 : orders) {
                listOrderIdByAccountId.add(orders1.getId());
            }
            Set<Integer> set = new HashSet<>(listOrderIdByAccountId);
            if (orders.isEmpty()) {
                // Nếu người dùng chưa có đơn hàng, tạo một đơn hàng mới
                Orders order1 = new Orders();
                order1.setDate(new Date());
                order1.setAccount(accountOptional.get());
                order1 = orderRepository.save(order1);

                OrdersDetails orderDetail = new OrdersDetails();
                orderDetail.setOrderId(order1.getId());
                orderDetail.setCourseId(courseOptional.get().getId());
                orderDetail.setOrders(order1);
                orderDetail.setCourse(courseOptional.get());

                Float coursePrice = courseOptional.get().getPrice();
                if (courseOptional.get().getCoupon() == null) {
                    courseOptional.get().setCoupon(0F);
                }
                Float finalPrice = coursePrice * (100 - courseOptional.get().getCoupon()) / 100;
                orderDetail.setFinalPrice(finalPrice);
                orderDetailRepository.save(orderDetail);

            } else {
                List<OrdersDetails> ordersDetails = orderDetailRepository.findByCourseId(courseId);
                if (ordersDetails.isEmpty()) {
                    Orders order1 = new Orders();
                    order1.setDate(new Date());
                    order1.setAccount(accountOptional.get());
                    order1 = orderRepository.save(order1);
                    OrdersDetails orderDetail = new OrdersDetails();
                    orderDetail.setOrderId(order1.getId());
                    orderDetail.setCourseId(courseOptional.get().getId());
                    orderDetail.setOrders(order1);
                    orderDetail.setCourse(courseOptional.get());

                    Float coursePrice = courseOptional.get().getPrice();
                    if (courseOptional.get().getCoupon() == null) {
                        courseOptional.get().setCoupon(0F);
                    }
                    Float finalPrice = coursePrice * (100 - courseOptional.get().getCoupon()) / 100;
                    orderDetail.setFinalPrice(finalPrice);
                    orderDetailRepository.save(orderDetail);

                } else {
                    for (OrdersDetails ordersDetails1 : ordersDetails) {
                        if (set.contains(ordersDetails1.getOrderId())) {
                            return ResponseEntity.badRequest().body("Course already in cart");
                        }
                    }
                    Orders order1 = new Orders();
                    order1.setDate(new Date());
                    order1.setAccount(accountOptional.get());
                    order1 = orderRepository.save(order1);
                    OrdersDetails orderDetail = new OrdersDetails();
                    orderDetail.setOrderId(order1.getId());
                    orderDetail.setCourseId(courseOptional.get().getId());
                    orderDetail.setOrders(order1);
                    orderDetail.setCourse(courseOptional.get());

                    Float coursePrice = courseOptional.get().getPrice();
                    if (courseOptional.get().getCoupon() == null) {
                        courseOptional.get().setCoupon(0F);
                    }
                    Float finalPrice = coursePrice * (100 - courseOptional.get().getCoupon()) / 100;
                    orderDetail.setFinalPrice(finalPrice);
                    orderDetailRepository.save(orderDetail);
                }


            }
            return ResponseEntity.ok("Product added to cart");


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when added course");
        }
    }


    @GetMapping("/getCartFromAccountId/{accountId}")
    public ResponseEntity<CartResponse> viewCart(@PathVariable Integer accountId) {
        try {
            Optional<Account> accountOptional = accountRepository.findById(accountId);
            if (!accountOptional.isPresent()) {
                return ResponseEntity.notFound().build();
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
            return ResponseEntity.ok(cartResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<String> deleteCourse(@RequestParam Integer accountId, @RequestParam Integer courseId) {
        List<Orders> orders = orderRepository.findByAccountId(accountId);
        List<Integer> listOrderIdByAccountId = new ArrayList<>();
        for (Orders orders1 : orders) {
            listOrderIdByAccountId.add(orders1.getId());
        }
        Set<Integer> set = new HashSet<>(listOrderIdByAccountId);
        List<OrdersDetails> ordersDetails = orderDetailRepository.findByCourseId(courseId);
        if (!ordersDetails.isEmpty()) {
            for (OrdersDetails ordersDetails1 : ordersDetails) {
                if (set.contains(ordersDetails1.getOrderId())) {
                    orderDetailRepository.delete(ordersDetails1);

                }else{
                    return ResponseEntity.badRequest().body("Course not found in cart");
                }
            }
        }else{
            return ResponseEntity.badRequest().body("Course not found in cart");
        }
        return ResponseEntity.badRequest().body("Course deleted from cart");
    }
}
