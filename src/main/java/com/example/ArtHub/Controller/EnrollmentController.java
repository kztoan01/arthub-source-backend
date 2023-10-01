package com.example.ArtHub.Controller;

import com.example.ArtHub.Entity.Enrollment;
import com.example.ArtHub.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @PostMapping("/enroll")
    public Enrollment enrollCourse(@RequestParam Integer accountId, @RequestParam Integer courseId) {

        Enrollment enrollment = new Enrollment();
        enrollment.setAccountId(accountId);
        enrollment.setCourseId(courseId);
        enrollmentRepository.save(enrollment);
        return enrollment;
    }
    @GetMapping("/{enrollmentId}")
    public Enrollment getEnrollment(@PathVariable Integer enrollmentId) {
        return enrollmentRepository.findById(enrollmentId).orElse(null);
    }
}
