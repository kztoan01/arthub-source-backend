package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Controller.ControllerOfCourse;
import com.example.ArtHub.DTO.CreateLearningObjectiveDTO;
import com.example.ArtHub.DTO.ResponeLearningObjectiveDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.LearningObjective;
import com.example.ArtHub.Repository.LearningObjectiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfLearningObjective implements ILearningObjectiveService {
    private static final Logger logger = LoggerFactory.getLogger(ControllerOfCourse.class);
    @Autowired
    LearningObjectiveRepository learningObjectiveRepository;
    @Override
    public LearningObjective createLearningObjective(CreateLearningObjectiveDTO dto, Course course) throws AppServiceExeption {
        LearningObjective learningObjective = new LearningObjective();
        learningObjective.setCourse(course);
        learningObjective.setOne(dto.getOne());
        learningObjective.setTwo(dto.getTwo());
        learningObjective.setThree(dto.getThree());
        learningObjective.setFour(dto.getFour());
        logger.info("Inserted learning object:"+learningObjective.getOne());
        return learningObjectiveRepository.save(learningObjective);
    }


    public ResponeLearningObjectiveDTO fromLearningObjectiveToResponeLearningObjectiveDTO(LearningObjective lo)
    {
        ResponeLearningObjectiveDTO responeLearningObjectiveDTO = new ResponeLearningObjectiveDTO();
        if(lo != null)
        {
            responeLearningObjectiveDTO.setId(lo.getId());
            responeLearningObjectiveDTO.setOne(lo.getOne());
            responeLearningObjectiveDTO.setTwo(lo.getTwo());
            responeLearningObjectiveDTO.setThree(lo.getThree());
            responeLearningObjectiveDTO.setFour(lo.getFour());
            responeLearningObjectiveDTO.setCourseId(lo.getCourse().getId());
        }
        return  responeLearningObjectiveDTO;
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
