
        package com.example.ArtHub.Controller;

        import com.example.ArtHub.AppServiceExeption;
        import com.example.ArtHub.DTO.CreateLearnerDTO;
        import com.example.ArtHub.DTO.ResponseLearnerDTO;
        import com.example.ArtHub.Entity.Learner;
        import com.example.ArtHub.InterfaceOfControllers.InterfaceOfLearnerController;
        import com.example.ArtHub.Repository.CourseRepository;
        import com.example.ArtHub.Repository.LearnerRepository;
        import com.example.ArtHub.Service.ServiceOfCourse;
        import com.example.ArtHub.Service.ServiceOfLearner;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfLearner implements InterfaceOfLearnerController {
    @Autowired
    LearnerRepository learnerRepository;

    @Autowired
    ServiceOfLearner learnerService;

    @Autowired
    CourseRepository courseRepository;

    public ResponseLearnerDTO fromLearnerToResponseLearnerDTO (Learner learner) {
        ResponseLearnerDTO learnerDTO = new ResponseLearnerDTO();
        learnerDTO.setId(learner.getId());
        learnerDTO.setAccountId(learner.getAccountId());
        learnerDTO.setCourseId(learner.getCourseId());
        learnerDTO.setOwnerCourse(courseRepository.findById(learner.getCourseId()).get().getAccountId());
        learnerDTO.setDate(learner.getDate());
        learnerDTO.setPrice(learner.getPrice());

        return learnerDTO;


    }

    public ResponseLearnerDTO createLearner(CreateLearnerDTO dto) throws AppServiceExeption, IOException {
        Learner learner = learnerService.createLearner(dto);

        return fromLearnerToResponseLearnerDTO(learner);

    }

    @Override
    public int countLearner(int owner) throws AppServiceExeption, IOException {


        return learnerRepository.countDistinctAccountIdByOwner(owner);
    }

    @Override
    public double getProfitByOwner(int owner) throws AppServiceExeption, IOException {
        return learnerRepository.sumOfProfit(owner);
    }


}