package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearningObjectiveDTO;
import com.example.ArtHub.DTO.ResponeLearningObjectiveDTO;
import com.example.ArtHub.Entity.LearningObjective;
import com.example.ArtHub.Repository.LearningObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOfLearningObjective implements InterfaceOfLearningObjectiveService {

    @Autowired
    LearningObjectiveRepository learningObjectiveRepository;
    @Override
    public LearningObjective createLearningObjective(CreateLearningObjectiveDTO dto,int ID) throws AppServiceExeption {
        LearningObjective learningObjective = new LearningObjective();
        learningObjective.setCourse(ID);
        learningObjective.setOne(dto.getOne());
        learningObjective.setTwo(dto.getTwo());
        learningObjective.setThree(dto.getThree());
        learningObjective.setFour(dto.getFour());
        learningObjective.setFive(dto.getFive());
        learningObjective.setSix(dto.getSix());
        return learningObjectiveRepository.save(learningObjective);
    }

    @Override
    public List<LearningObjective> getLearningObjectiveList() {
              List<LearningObjective> learningObjectives = learningObjectiveRepository.findAll();
        return learningObjectives ;
    }

    @Override
    public LearningObjective getLearningObjectiveByCourseId(int ID) {
        LearningObjective learningObjective = learningObjectiveRepository.findByCourse(ID);
        return learningObjective;
    }


}
