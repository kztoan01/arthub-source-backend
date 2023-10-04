//package com.example.ArtHub.Service;
//
//import com.example.ArtHub.Entity.Account;
//import com.example.ArtHub.Entity.Course;
//import com.example.ArtHub.Entity.Orders;
//import com.example.ArtHub.Entity.OrdersDetails;
//import com.example.ArtHub.Repository.AccountRepository;
//import com.example.ArtHub.Repository.CourseRepository;
//import com.example.ArtHub.Repository.OrderDetailRepository;
//import com.example.ArtHub.Repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.example.ArtHub.ResourceNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ServiceOfCart {
//    @Autowired
//    private CourseRepository courseRepository;
//    @Autowired
//    private OrderRepository orderRepository;
//    @Autowired
//    private OrderDetailRepository orderDetailRepository;
//    @Autowired
//    private AccountRepository accountRepository;
//
//    public void addToCart(int courseId,int accountId){
//        Course course = courseRepository.findById(courseId);
////        Account account = accountRepository.findById(accountId);
//        Orders order = orderRepository.findByAccount(account);
//        if (order == null) {
//            order = new Orders();
//            order.setAccount(account);
//            order = orderRepository.save(order);
//        }
//        OrdersDetails orderDetail = new OrdersDetails();
//        orderDetail.setCourse(course);
//
//        orderDetail.setFinalPrice(course.getPrice());
//        orderDetail.setOrders(order);
//
//        orderDetailRepository.save(orderDetail);
//    }
//    }
//
