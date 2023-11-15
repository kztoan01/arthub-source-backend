package com.example.ArtHub.Service;
import com.example.ArtHub.CourseNotFoundException;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseProfitDTO;
import com.example.ArtHub.DTO.ResponeStudentInfor;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Repository.*;
import com.example.ArtHub.utils.ModelMapperObject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceOfCourse implements ICourseService {

    @Autowired
    CourseRateRepository courseRateRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    LearnerRepository learnerRepository;

    @Autowired
    private ModelMapperObject modelMapper;


    @Autowired
    ServiceOfCategory serviceOfCategory;

    @Autowired
    ServiceOfSection sectionService;


    @Autowired
    ServiceOfLearner serviceOfLearner;

    @Autowired
    ServiceOfAccount serviceOfAccount;

    @Autowired
    ServiceOfCategoryCourse serviceOfCategoryCourse;

    @Autowired
    ServiceOfLearningObjective serviceOfLearningObjective;



    @Autowired
    ServiceOfImage serviceOfImage;

    @Autowired
    CategoryRepository categoryRepository;

    public ServiceOfCourse(CourseRepository courseRepository, AccountRepository accountRepository) {
        this.courseRepository = courseRepository;
        this.accountRepository = accountRepository;
    }

    public ServiceOfCourse() {
    }

    @Override
    public Course createCourse(CreateCourseDTO dto) {
        Course course = new Course();
        course.setCoupon(dto.getCoupon());
        course.setDescription(dto.getDescription());
        course.setIntroduction(dto.getIntroduction());
        course.setLanguage(dto.getLanguage());
        course.setLevel(dto.getLevel());
        course.setPrice(dto.getPrice());
        course.setAccount(accountRepository.findById(dto.getAccountId()).orElseThrow());
        course.setName(dto.getName());
        course.setPassed(dto.isPassed());
        return courseRepository.save(course);
    }





    @Override
    public String getNameByID(int id)
    {
        return courseRepository.findById(id).get().getName();
    }

    @Override
    public int DeleteCourseByID(int courseId)
    {
        return courseRepository.deleteViolatedCourse(courseId);
    }


    @Override
    public List<ResponeCourseDTO> findCoursesByInstructorId(int id) throws CourseNotFoundException {
        return courseRepository.findCoursesByInstructorId(id).stream().map(course -> fromCourseToResponeCourseDTO2(course)).toList();
    }


    @Override
    public ResponeStudentInfor fromAccountToResponeStudentDTO(Account account,int courseID)
    {
        ResponeStudentInfor student = new ResponeStudentInfor();
        student.setId(account.getId());
        student.setEmail(account.getEmail());
        student.setFacebook(account.getFacebook());
        student.setFirstname(account.getFirstname());
        student.setTwitter(account.getTwitter());
        student.setLastname(account.getLastname());
        student.setDate(serviceOfLearner.findLearnerByIDAndCourse(account.getId(),courseID).getDate());
        return  student;
    }

    @Override
    public Double getSumPriceCourseByAccountID(int id) {
        return null;
    }


    @Override
    public int updateCourseStatus(int courseId, int status)
    {
        return courseRepository.updateCourseStatus(courseId, status);
    }


    @Override
    public int updateMainImage(int id, String imageName)
    {
        return courseRepository.updateMainImage(id,imageName);
    }

    @Override
    public ResponeCourseDTO fromCourseToResponeCourseDTO2(Course course) {
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setName(course.getName());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setInstructorName(course.getAccount().getFirstname()+" "+course.getAccount().getLastname());
        courseDTO.setImage(course.getImage());
        courseDTO.setStudents(learnerRepository.findLeanerOfCourse(course.getId()).stream().map(account -> fromAccountToResponeStudentDTO(account,course.getId())).toList());
        return courseDTO;
    }


    @Override
    public  ResponeCourseDTO fromCourseToResponeCourseDTO(Course course) {
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setIntroduction(course.getIntroduction());
        courseDTO.setLevel(course.getLevel());
        courseDTO.setLanguage(course.getLanguage());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCoupon(course.getCoupon());
        courseDTO.setPassed(course.getPassed());
        courseDTO.setStatus(course.getStatus());
        courseDTO.setImage(course.getImage());
        courseDTO.setDate(course.getDate());
        courseDTO.setBio(course.getAccount().getBio());
        courseDTO.setAccountId(course.getAccount().getId());
        courseDTO.setInstructorName(course.getAccount().getFirstname()+" "+course.getAccount().getLastname());
        courseDTO.setInstructorImage(course.getAccount().getImage());
        courseDTO.setInstructorAddress(course.getAccount().getAddress());
        courseDTO.setInstructorEmail(course.getAccount().getEmail());
        courseDTO.setInstructorFacebook(course.getAccount().getFacebook());
        courseDTO.setInstructorPhone(course.getAccount().getPhone());
        courseDTO.setInstructorTwitter(course.getAccount().getTwitter());
        courseDTO.setCategories(course.getCategoryCourse().stream().map(categoryCourse -> serviceOfCategory.fromCategoryToCategotyResponeNameDTO(categoryCourse)).toList());
        courseDTO.setLearningObjective(serviceOfLearningObjective.fromLearningObjectiveToResponeLearningObjectiveDTO(course.getLearningObjective() != null ? course.getLearningObjective() : null));
        courseDTO.setSections(course.getSections().stream().map(section -> sectionService.fromSectionIntoResponeSectionDTO(section,course.getId())).toList());
        courseDTO.setCount(courseRateRepository.countCourseRateByCourseId(course.getId()));
        courseDTO.setImages(serviceOfImage.fromImagetoResponeImageDTO(course.getImages() != null ? course.getImages() : null));
        courseDTO.setAvg(courseRateRepository.avgCourseRateByCourseId(course.getId()));
        return courseDTO;
    }


    public ResponeCourseProfitDTO fromCourseToCourseProfitDTO(Course course)
    {
        ResponeCourseProfitDTO responeCourseProfitDTO = new ResponeCourseProfitDTO();
        responeCourseProfitDTO.setSumProfit(learnerRepository.getCourseProfitsByCourseID(course.getId()) != null ?  learnerRepository.getCourseProfitsByCourseID(course.getId()) : 0);
        responeCourseProfitDTO.setLastMonthProfit(learnerRepository.getCourseLastMonthProfitsByCourseID(course.getId()) != null ? learnerRepository.getCourseLastMonthProfitsByCourseID(course.getId()) : 0 );
        responeCourseProfitDTO.setName(course.getName());
        responeCourseProfitDTO.setImage(course.getImage());
        responeCourseProfitDTO.setCourseId(course.getId());
        return  responeCourseProfitDTO;
    }



    @Override
    public  List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList) {
        List<ResponeCourseDTO> ResponeCourseDTOList = new ArrayList<>();
        for (Course course : CourseList) {

            ResponeCourseDTOList.add(fromCourseToResponeCourseDTO(course));
        }
        return ResponeCourseDTOList;
    }




    @Override
    public List<ResponeCourseDTO> getCourseList() {

        return courseRepository.findAll().stream().map(course -> fromCourseToResponeCourseDTO(course)).toList();

    }


    public List<Course> getCourseList2() {
        return courseRepository.findAll();
    }

}
