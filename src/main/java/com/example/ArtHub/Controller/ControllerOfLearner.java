
        package com.example.ArtHub.Controller;

        import com.example.ArtHub.AppServiceExeption;
        import com.example.ArtHub.DTO.CreateLearnerDTO;
        import com.example.ArtHub.DTO.ResponseLearnerDTO;
        import com.example.ArtHub.Entity.Account;
        import com.example.ArtHub.Entity.Learner;
        import com.example.ArtHub.InterfaceOfControllers.InterfaceOfLearnerController;
        import com.example.ArtHub.Repository.AccountRepository;
        import com.example.ArtHub.Repository.CourseRepository;
        import com.example.ArtHub.Repository.LearnerRepository;
        import com.example.ArtHub.Service.ServiceOfCourse;
        import com.example.ArtHub.Service.ServiceOfLearner;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import javax.swing.text.html.Option;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

        @CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfLearner implements InterfaceOfLearnerController {
    @Autowired
    LearnerRepository learnerRepository;

    @Autowired
    ServiceOfLearner learnerService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<List<Learner>> showStudentPurchase(Integer accountId) {
        try {
            Optional<Account> accountOptional = accountRepository.findById(accountId);
            if(!accountOptional.isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }

            List<Learner> learnerList = learnerRepository.showStudentPurchaseByAccountId(accountId);
            return ResponseEntity.ok(learnerList);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    public ResponseLearnerDTO fromLearnerToResponseLearnerDTO (Learner learner) {
        ResponseLearnerDTO learnerDTO = new ResponseLearnerDTO();
        learnerDTO.setId(learner.getId());
        learnerDTO.setAccountId(learner.getAccountId());
        learnerDTO.setCourseId(learner.getCourseId());
        learnerDTO.setOwnerCourse(courseRepository.findById(learner.getCourseId()).get().getAccountId());
        learnerDTO.setDate(learner.getDate());
        learnerDTO.setPrice(learner.getPrice());
        learnerDTO.setStatus(learner.getStatus());
        learnerDTO.setSenderId(learner.getSenderId());
        learnerDTO.setMessage(learner.getMessage());
        return learnerDTO;


    }

    public List<ResponseLearnerDTO> fromLearnerListToResponseLearnerDTOList(List<Learner> LearnerList) {
        List<ResponseLearnerDTO> ResponseLearnerDTOList = new ArrayList<>();
        for (Learner learner: LearnerList) {
            ResponseLearnerDTOList.add(fromLearnerToResponseLearnerDTO(learner));
        }
        return ResponseLearnerDTOList;
    }

    public List<ResponseLearnerDTO> getLearnerList() {
        List<Learner> learnerListFromDB = learnerRepository.findAll();
        List<ResponseLearnerDTO> responseLearnerDTOList = fromLearnerListToResponseLearnerDTOList(learnerListFromDB);
        return responseLearnerDTOList;
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