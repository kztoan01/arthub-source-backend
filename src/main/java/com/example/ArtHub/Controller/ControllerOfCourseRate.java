package com.example.ArtHub.Controller;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Course;

import com.example.ArtHub.Entity.CourseRate;
import com.example.ArtHub.Entity.Learner;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.Repository.CourseRateRepository;
import com.example.ArtHub.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ControllerOfCourseRate {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CourseRateRepository courseRateRepository;
    @PostMapping("/CourseRate")
    public ResponseEntity<String> RateOfCourse(@RequestParam Integer courseId,@RequestParam Integer accountId,@RequestParam Integer rate,@RequestParam String comment){
        try{

            Optional<Course> courseOptional=courseRepository.findById(courseId);
            if(!courseOptional.isPresent()){
                return ResponseEntity.badRequest().body("Course is not exist");
            }
            Optional<Account> accountOptional=accountRepository.findById(accountId);
            if(!accountOptional.isPresent()){
                return ResponseEntity.badRequest().body("Account is not exist");
            }
           CourseRate courseRate=new CourseRate();
            courseRate.setTimeRate(new Date());
            courseRate.setRate(rate);
            courseRate.setComment(comment);
            courseRate.setAccountId(accountId);
            courseRate.setCourseId(courseId);
            courseRateRepository.save(courseRate);
            return ResponseEntity.ok("Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when rate course");
        }
    }

    @PostMapping("/getCourseRate")
    public ResponseEntity<List<CourseRate>> getCourseRate(@RequestParam Integer courseId) {
        try {
            List<CourseRate> courseRates = courseRateRepository.getCourseRateByCourseId(courseId);
            return ResponseEntity.ok(courseRates);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/updateCourseRate")
    public ResponseEntity<String> updateCourseRate(@RequestParam Integer courseId,@RequestParam Integer accountId,@RequestParam Integer rate,@RequestParam String comment){
        Optional<CourseRate> courseRateOptional=courseRateRepository.getCourseRateByAccountIdAndCourseId(accountId,courseId);
        try {
            if (courseRateOptional.isPresent()) {
                CourseRate courseRate = courseRateOptional.get();
                courseRate.setTimeRate(new Date());
                courseRate.setRate(rate);
                courseRate.setComment(comment);
                courseRate.setAccountId(accountId);
                courseRate.setCourseId(courseId);
                courseRateRepository.save(courseRate);

            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when update rating course");
        }
        return ResponseEntity.ok("Successfully");
    }
}
