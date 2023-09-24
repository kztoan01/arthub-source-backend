package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.*;
import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.Repository.CategoryRepository;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Service.ServiceOfCategoryCourse;
import com.example.ArtHub.Service.ServiceOfCourse;
import com.example.ArtHub.Service.ServiceOfLearningObjective;
import com.example.ArtHub.Service.ServiceOfSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfCourse implements InterfaceOfCourseController {


    private static final Logger logger = LoggerFactory.getLogger(ControllerOfCourse.class);

    @Autowired
    ServiceOfCourse courseService;
    @Autowired
    CourseRepository courseRepository;



    @Autowired
    ServiceOfSection sectionService;

    @Autowired
    ServiceOfCategoryCourse serviceOfCategory;

    @Autowired
    ServiceOfLearningObjective serviceOfLearningObjective;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AccountRepository accountRepository;



    ResponeCategoryNameDTO fromCategoryToCategotyResponeNameDTO(CategoryCourse categoryCourse)
    {
        ResponeCategoryNameDTO responeCategoryNameDTO = new ResponeCategoryNameDTO();

        responeCategoryNameDTO.setName(categoryRepository.findById(categoryCourse.getCategoryId()).get().getName());

        return responeCategoryNameDTO;
    }


     List<ResponeCategoryNameDTO> fromCategoryListToCategoryDTOList(List<CategoryCourse> CategoryCourseList)
    {
        List<ResponeCategoryNameDTO> responeCategoryNameDTOS = new ArrayList<>();
        for (CategoryCourse category : CategoryCourseList) {
            responeCategoryNameDTOS.add(fromCategoryToCategotyResponeNameDTO(category));
        }
        return responeCategoryNameDTOS;
    }






    public  List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList) { //This fucntion use to convert courseList into ResponeCourseDTO list
        List<ResponeCourseDTO> ResponeCourseDTOList = new ArrayList<>();
        for (Course course : CourseList) {

            ResponeCourseDTOList.add(fromCourseToResponeCourseDTO(course));
        }
        return ResponeCourseDTOList;
    }

    public List<ResponeCourseDTO> getCourseList() {
        List<Course> courseListFromDB = courseRepository.findAll();
        List<ResponeCourseDTO> responeCourseDTOList = fromCourseListToResponeCourseDTOList(courseListFromDB);
        return responeCourseDTOList;
    }


    public  ResponeCourseDTO fromCourseToResponeCourseDTO(Course course) { //This function use to convert courseEntity to ResponeCourseDTO
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCoupon(course.getCoupon());
        courseDTO.setId(course.getId());
        courseDTO.setLanguage(course.getLanguage());
        courseDTO.setLevel(course.getLevel());
        courseDTO.setAccountId(course.getAccountId());
        courseDTO.setApproved(course.getApproved());
        courseDTO.setPassed(course.isPassed());
        courseDTO.setIntroduction(course.getIntroduction());
        courseDTO.setImage(course.getImage());
        courseDTO.setDate(course.getDate());
        courseDTO.setSections(sectionService.getSectionList(course.getId()));


        if(course.getAccountId() == null)
        {
            logger.info("Id is null;");
        }



        courseDTO.setInstructorName(accountRepository.findById(course.getAccountId()).get().getFirstname()+" "+accountRepository.findById(course.getAccountId()).get().getLastname());
        courseDTO.setIntructorImage(accountRepository.findById(course.getAccountId()).get().getImage());
        courseDTO.setIntructorAddress(accountRepository.findById(course.getAccountId()).get().getAddress());
        courseDTO.setInstrutorEmail(accountRepository.findById(course.getAccountId()).get().getEmail());
        courseDTO.setInstructorFacebook(accountRepository.findById(course.getAccountId()).get().getFacebook());
        courseDTO.setInstructorPhone(accountRepository.findById(course.getAccountId()).get().getPhone());
        courseDTO.setInstructorTwitter(accountRepository.findById(course.getAccountId()).get().getTwitter());

        courseDTO.setCategories(fromCategoryListToCategoryDTOList(serviceOfCategory.getCategoriesByCourseID(course.getId())));

        courseDTO.setLearningObjective(serviceOfLearningObjective.getLearningObjectiveByCourseId(course.getId()));

        return courseDTO;
    }


    @Override
    public List<ResponeCourseDTO> findAllCourseByLanguageAndPrice(String language, float price) {
        List<Course> courseList = courseRepository.findByLanguageAndPrice(language, price);
        return fromCourseListToResponeCourseDTOList(courseList);
    }

    @Override
    public ResponeCourseDTO createCourse(CreateCourseDTO dto) throws AppServiceExeption, IOException {
        Course cousre = courseService.createCourse(dto);


        List<CreateSectionDTO> Sections = dto.getSections();
        for (CreateSectionDTO CreatesectionDTO: Sections) {
            sectionService.createSection(CreatesectionDTO,cousre.getId());
        }

        CreateLearningObjectiveDTO learningObjects = dto.getLearningObjective();
        serviceOfLearningObjective.createLearningObjective(learningObjects,cousre.getId());

        List<CreateCategoryCourseDTO> Categoris = dto.getCategories();
        for(CreateCategoryCourseDTO categoryDTO : Categoris )
        {
            serviceOfCategory.createCategoryCourse(categoryDTO,cousre.getId());
        }


        return fromCourseToResponeCourseDTO(cousre);
    }
    @Override
    public List<ResponeCourseDTO> getCourses() {
        List<ResponeCourseDTO> courseList =  getCourseList();
        return courseList;
    }

    @Override
    public List<ResponeCourseDTO> getCoursesByName(String name) {
        List<Course> courses = courseRepository.findByNameContains(name);
        return fromCourseListToResponeCourseDTOList(courses);
    }

    @Override
    public List<ResponeCourseDTO> getCoursesByCategory(String category) {
        return null;
    }
}
