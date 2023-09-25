package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearnerDTO;
import com.example.ArtHub.Entity.Learner;

public interface InterfaceOfLearnerService {
    Learner createLearner(CreateLearnerDTO dto) throws AppServiceExeption;
}
