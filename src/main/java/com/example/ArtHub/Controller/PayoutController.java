package com.example.ArtHub.Controller;

import com.example.ArtHub.CourseNotFoundException;
import com.example.ArtHub.DTO.PayoutDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.DTO.ResponseAccountDTO;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Payout;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.Repository.PayoutRepository;
import com.example.ArtHub.Service.ServiceOfPayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/payout")
public class PayoutController {
    @Autowired
    PayoutRepository payoutRepository;

    @Autowired
    ServiceOfPayout serviceOfPayout;
    @Autowired
    AccountRepository accountRepository;
    @GetMapping("/getAll")
    public ResponseEntity<List<Payout>> getAllPayouts(@RequestParam(required = false) String name) {
        try {
            List<Payout> payouts = new ArrayList<Payout>();

            if (name == null)
                payoutRepository.findAll().forEach(payouts::add);

            if (payouts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(payouts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getPayoutInformation/{id}")
    public PayoutDTO getAllPayoutsByID(@PathVariable("id") int id) {

            return serviceOfPayout.getPayoutInformationByInstructorID(id);

    }


    @GetMapping("/getPayoutInformations")
    public List<PayoutDTO> getAllPayouts() {

        return serviceOfPayout.getListPayouts();

    }
    @PostMapping("/create")
    public ResponseEntity<Optional<Account>> createPayout(@RequestBody Payout payout) {
        try {

            Optional<Payout> payoutMethod = payoutRepository.findByAccountId(payout.getAccountId());
            if (!payoutMethod.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN); //payout exsist
            } else {
                int updatePre = accountRepository.updatePremium(payout.getAccountId(),"1");
                Payout _payout = payoutRepository.save(new Payout(
                        payout.getAccountId(),
                        payout.getPlatform(),
                        payout.getRecipientName(),
                        payout.getRecipientUsername(),
                        payout.getRecipientEmail(),
                        payout.getRecipientPhone(),
                        payout.getRecipient()
                ));
                Optional<Account> accountData = accountRepository.findById(payout.getAccountId());
                return new ResponseEntity<>(accountData, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Payout> updatePayout(@RequestBody Payout payout) {
        Optional<Payout> payoutMethod = payoutRepository.findByAccountId(payout.getAccountId());
        if (payoutMethod.isPresent()) {
            Payout _payout = payoutMethod.get();
            _payout.setAccountId(payout.getAccountId());
            _payout.setPlatform(payout.getPlatform());
            _payout.setRecipientEmail(payout.getRecipientEmail());
            _payout.setRecipientName(payout.getRecipientName());
            _payout.setRecipientUsername(payout.getRecipientUsername());
            _payout.setRecipient(payout.getRecipient());
            _payout.setRecipientPhone(payout.getRecipientPhone());
            return new ResponseEntity<>(payoutRepository.save(_payout), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePayout(@PathVariable("id") int id) {
        try {
            payoutRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    public  PayoutDTO fromCourseToResponeCourseDTO(Course course) { //This function use to convert courseEntity to ResponeCourseDTO
//        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
//        courseDTO.setName(course.getName());
//        courseDTO.setDescription(course.getDescription());
//        courseDTO.setPrice(course.getPrice());
//        courseDTO.setCoupon(course.getCoupon());
//        courseDTO.setId(course.getId());
//        courseDTO.setLanguage(course.getLanguage());
//        courseDTO.setLevel(course.getLevel());
//        courseDTO.setAccountId(course.getAccountId());
//        courseDTO.setStatus(course.getStatus());
//        courseDTO.setPassed(course.getPassed());
//        courseDTO.setIntroduction(course.getIntroduction());
//        courseDTO.setImage(course.getImage());
//        courseDTO.setDate(course.getDate());
//        courseDTO.setSections(sectionService.getSectionList(course.getId()).stream().map(section -> sectionService.fromSectionIntoResponeSectionDTO(section)).toList());
//        courseDTO.setImages(serviceOfImage.getImageByCourseID(course.getId()));
//        courseDTO.setBio(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getBio());
//        courseDTO.setInstructorName(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getFirstname()+" "+serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getLastname());
//        courseDTO.setInstructorImage(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getImage());
//        courseDTO.setInstructorAddress(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getAddress());
//        courseDTO.setInstructorEmail(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getEmail());
//        courseDTO.setInstructorFacebook(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getFacebook());
//        courseDTO.setInstructorPhone(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getPhone());
//        courseDTO.setInstructorTwitter(serviceOfAccount.getAccountByCourseID(course.getAccountId()).get().getTwitter());
//        courseDTO.setCategories(serviceOfCategoryCourse.getCategoriesByCourseID(course.getId()).stream().map(categoryCourse -> serviceOfCategory.fromCategoryToCategotyResponeNameDTO(categoryCourse)).toList());
//        courseDTO.setLearningObjective(serviceOfLearningObjective.getLearningObjectiveByCourseId(course.getId()));
//        courseDTO.setCount(courseRateRepository.countCourseRateByCourseId(course.getId()));
//        courseDTO.setAvg(courseRateRepository.avgCourseRateByCourseId(course.getId()));
//        return courseDTO;
//    }
//    @GetMapping("/getPayout")
//    public ResponseEntity<List<PayoutDTO>> AllPayout(@RequestParam String email, @RequestParam String password) {
//            List<PayoutDTO> allPayout = payoutRepository.displayAllPayout();
//            return new ResponseEntity<>(allPayout,HttpStatus.NOT_FOUND);
//    }
}
