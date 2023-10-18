package com.example.ArtHub.Controller;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.CourseRate;
import com.example.ArtHub.Repository.CourseRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/rate")
public class ControllerOfCourseRate {
    @Autowired
    CourseRateRepository courseRateRepository;
    @PostMapping("/addRate")
    public ResponseEntity<CourseRate> createRate(@RequestBody CourseRate courseRate) {
        try {
                CourseRate _courseRate = courseRateRepository.save( new CourseRate(
                        courseRate.getRate(),
                        courseRate.getComment(),
                        courseRate.getCourseId(),
                        courseRate.getAccountId()

                ));
                return new ResponseEntity<>(_courseRate,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/editRate")
//    public ResponseEntity<CourseRate> editRate(@RequestBody CourseRate courseRate) {
//        try {
//            CourseRate courseRate1 = courseRateRepository.deleteById(courseRate.getId());
//            CourseRate _courseRate = courseRateRepository.save( new CourseRate(
//                    courseRate.getRate(),
//                    courseRate.getComment(),
//                    courseRate.getCourseId(),
//                    courseRate.getAccountId()
//
//            ));
//            return new ResponseEntity<>(_courseRate,HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @PostMapping("/getCourseRate")
    public ResponseEntity<List<CourseRate>> getCourseRateById(@RequestParam int courseId) {
        List<CourseRate> courseRates = courseRateRepository.displayRateFromCourse(courseId);
            return new ResponseEntity<>(courseRates, HttpStatus.OK);
    }
}
