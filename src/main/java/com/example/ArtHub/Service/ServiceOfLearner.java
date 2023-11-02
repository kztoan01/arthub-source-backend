package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearnerDTO;
import com.example.ArtHub.Entity.Learner;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfLearner implements InterfaceOfLearnerService{
    @Autowired
    LearnerRepository learnerRepository;


    @Autowired
    CourseRepository courseRepository;

    @Override
    public Learner createLearner(CreateLearnerDTO dto) throws AppServiceExeption {
        Learner learner = new Learner();
        learner.setAccountId(dto.getAccountId());
        learner.setCourseId(dto.getCourseId());
        learner.setOwnerCourse(courseRepository.findById(dto.getCourseId()).get().getAccountId());
        learner.setPrice(dto.getPrice());
        return learnerRepository.save(learner);

    }
}