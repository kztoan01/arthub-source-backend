package com.example.ArtHub.Controller;

import com.example.ArtHub.Service.ServiceOfCart;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class ControllerOfCart {
    @Autowired
    private ServiceOfCart cartService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestParam int courseId, @RequestParam int accountId){
        cartService.addToCart(courseId,accountId);
        return ResponseEntity.ok("Successfully");
    }
}
