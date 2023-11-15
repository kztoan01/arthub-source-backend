package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearnerDTO;
import com.example.ArtHub.Entity.Learner;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfLearner implements ILearnerService {
    @Autowired
    LearnerRepository learnerRepository;

    @Autowired
    AccountRepository accountRepository;


    @Autowired
    CourseRepository courseRepository;

    @Override
    public Learner createLearner(CreateLearnerDTO dto) throws AppServiceExeption {
        Learner learner = new Learner();
        learner.setAccount(accountRepository.findById(dto.getAccountId()).orElseThrow());
        learner.setCourse(courseRepository.findById(dto.getCourseId()).orElseThrow());
        learner.setOwnerCourse(courseRepository.findById(dto.getCourseId()).get().getAccount().getId());
        learner.setPrice(dto.getPrice());
        return learnerRepository.save(learner);

    }

    @Override
    public Double getProfitByOwnerID(int id) {
        return learnerRepository.sumOfProfit(id);
    }


    @Override
    public Learner findLearnerByIDAndCourse(int id,int courseID) {
        return learnerRepository.findById(id,courseID);
    }


}