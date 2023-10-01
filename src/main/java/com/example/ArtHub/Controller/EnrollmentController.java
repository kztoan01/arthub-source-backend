package com.example.ArtHub.Controller;

import com.example.ArtHub.Entity.Learner;
import com.example.ArtHub.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @PostMapping("/enroll")
    public Learner enrollCourse(@RequestParam Integer accountId, @RequestParam Integer courseId) {

        Learner enrollment = new Learner();
        enrollment.setAccountId(accountId);
        enrollment.setCourseId(courseId);
        enrollmentRepository.save(enrollment);
        return enrollment;
    }
    @GetMapping("/{enrollmentId}")
    public Learner getLearner(@PathVariable Integer enrollmentId) {
        return enrollmentRepository.findById(enrollmentId).orElse(null);
    }
}
