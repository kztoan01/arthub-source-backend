package com.example.ArtHub.Controller;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Learner;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/course")
public class ControllerOfEnrolment {
    @Autowired
    private LearnerRepository learnerRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/enrol")
    public ResponseEntity<String> enrolCourse(@RequestParam(value = "courseId", required = false) Integer courseId,@RequestParam(value = "accountId", required = false)  Integer accountId,@RequestParam  Integer status,@RequestParam  Integer senderId,@RequestParam  String message){
        try{

            Optional<Course> courseOptional=courseRepository.findById(courseId);
            if(!courseOptional.isPresent()){
                return ResponseEntity.badRequest().body("Course is not exist");
            }
            Optional<Account> accountOptional=accountRepository.findById(accountId);
            Float price=courseOptional.get().getPrice();
            Optional<Learner> existingEnrolment=learnerRepository.findByAccountIdAndCourseId(accountId,courseId);
            if(existingEnrolment.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body("Course is already Enrolled");
            }
            Integer id=courseOptional.get().getAccountId();
            Learner learner=new Learner();
            learner.setCourse(courseOptional.get());
            learner.setAccount(accountOptional.get());
            learner.setPrice(price);
            learner.setOwnerCourse(id);
            learner.setStatus(status);
            learner.setSenderId(senderId);
            learner.setMessage(message);

            learnerRepository.save(learner);
            return ResponseEntity.ok("Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when enrol course");
        }
    }
    @GetMapping("/account-enrolments/{accountId}")
    public ResponseEntity<List<Learner>> getUserEnrolments(@PathVariable Integer accountId) {
        try {
            List<Learner> userEnrolments = learnerRepository.findByAccountId(accountId);
            return ResponseEntity.ok(userEnrolments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
