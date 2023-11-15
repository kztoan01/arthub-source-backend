package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearnerDTO;
import com.example.ArtHub.Entity.Learner;

public interface ILearnerService {
    Learner createLearner(CreateLearnerDTO dto) throws AppServiceExeption;

    Double getProfitByOwnerID(int id);

    Learner findLearnerByIDAndCourse(int id,int courseID);
}
