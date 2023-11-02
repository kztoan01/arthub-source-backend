package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Controller.ControllerOfCourse;
import com.example.ArtHub.DTO.CreateLearningObjectiveDTO;
import com.example.ArtHub.DTO.ResponeLearningObjectiveDTO;
import com.example.ArtHub.Entity.LearningObjective;
import com.example.ArtHub.Repository.LearningObjectiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOfLearningObjective implements InterfaceOfLearningObjectiveService {
    private static final Logger logger = LoggerFactory.getLogger(ControllerOfCourse.class);
    @Autowired
    LearningObjectiveRepository learningObjectiveRepository;
    @Override
    public LearningObjective createLearningObjective(CreateLearningObjectiveDTO dto,int ID) throws AppServiceExeption {
        LearningObjective learningObjective = new LearningObjective();
        learningObjective.setCourseId(ID);
        learningObjective.setOne(dto.getOne());
        learningObjective.setTwo(dto.getTwo());
        learningObjective.setThree(dto.getThree());
        learningObjective.setFour(dto.getFour());
        logger.info("Inserted learning object:"+learningObjective.getOne());
        return learningObjectiveRepository.save(learningObjective);
    }

    @Override
    public List<LearningObjective> getLearningObjectiveList() {
              List<LearningObjective> learningObjectives = learningObjectiveRepository.findAll();
        return learningObjectives ;
    }

    public int DeleteLearningObjectivesByCourseID(int courseId)
    {
        return learningObjectiveRepository.deleteLearningObjectivesByCourseID(courseId);
    }

    @Override
    public LearningObjective getLearningObjectiveByCourseId(int ID) {
        LearningObjective learningObjective = learningObjectiveRepository.findBycourseId(ID);
        return learningObjective;
    }


}
