package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.*;
import com.example.ArtHub.Entity.Category;
import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.InterfaceOfControllers.InterfaceOfCourseController;
import com.example.ArtHub.Repository.*;
import com.example.ArtHub.ResponeObject.ResponeObject;
import com.example.ArtHub.Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfCourse implements InterfaceOfCourseController {
//123
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));


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

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    ImageRepository imageRepository;


    public ResponeSectionDTO FromSectionIntoResponeSectionDTO(Section section)
    {
        ResponeSectionDTO sectionDTO = new ResponeSectionDTO();
        sectionDTO.setSection_id(section.getId());
        sectionDTO.setSection_name(section.getName());
        sectionDTO.setCourse(section.getCourseId());
        sectionDTO.setAccount_id(section.getAccountId());
        sectionDTO.setVideos(videoRepository.findAllBySectionId(section.getId()));
        return sectionDTO;
    }

    public List<ResponeSectionDTO> fromSectionListToResponeSectionDTOList(List<Section> SectionList) {
        List<ResponeSectionDTO> ResponeSectionDTOList = new ArrayList<>();
        for (Section section : SectionList) {
            ResponeSectionDTOList.add(FromSectionIntoResponeSectionDTO(section));
        }
        return ResponeSectionDTOList;
    }



    ResponeCategoryNameDTO fromCategoryToCategotyResponeNameDTO(CategoryCourse categoryCourse) {
        ResponeCategoryNameDTO responeCategoryNameDTO = new ResponeCategoryNameDTO();
        Category category = categoryRepository.findAllById(Collections.singleton(categoryCourse.getCategoryId())).stream().findFirst().orElse(null);
        if (category != null) {
            responeCategoryNameDTO.setName(category.getName());
        }
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

        courseDTO.setSections(fromSectionListToResponeSectionDTOList(sectionService.getSectionList(course.getId())));


        courseDTO.setImages(imageRepository.findByCourseId(course.getId()));


        if(course.getAccountId() == null)
        {
            logger.info("Id is null;");
        }


        courseDTO.setBio(accountRepository.findById(course.getAccountId()).get().getBio());
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
    public ResponeCourseDTO createCourse(CreateCourseDTO dto) throws AppServiceExeption {
        Course course = courseService.createCourse(dto);

        List<CreateSectionDTO> sections = dto.getSections();
        for (CreateSectionDTO createSectionDTO: sections) {
            sectionService.createSection(createSectionDTO, course.getId());
        }

        serviceOfLearningObjective.createLearningObjective(dto.getLearningObjective(), course.getId());

        for(CreateCategoryCourseDTO categoryDTO : dto.getCategories()) {
            serviceOfCategory.createCategoryCourse(categoryDTO, course.getId());
        }

        return fromCourseToResponeCourseDTO(course);
    }

    @Override
    public List<ResponeCourseDTO> getCourses() {
        List<ResponeCourseDTO> courseList =  getCourseList();
        return courseList;
    }

    @Override
    public List<ResponeCourseDTO> findCourseThatContainsKeyword(String keyword) {
        List<Course> courses = courseRepository.findCourseThatContainsKeyword(keyword);
        return fromCourseListToResponeCourseDTOList(courses);
    }

    @Override
    public List<ResponeCourseDTO> getCoursesByCategory(String category) {
        return null;
    }

    @Override
    public ResponseEntity<ResponeObject> updateStatusOfCourse(int courseId) throws AppServiceExeption, IOException {
        int rs = courseRepository.updateCourseStatus(courseId);

        if(rs!=0)
        {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","update status successfully!","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok","update status failed!","")
        );
    }

    @Override
    public ResponseEntity<ResponeObject> updateMainImageOfCourse(@RequestParam int courseId, @RequestParam MultipartFile image) throws AppServiceExeption, IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {

            os.write(image.getBytes());
        }

       int rs = courseRepository.updateMainImage(courseId,image.getOriginalFilename());

        if(rs!=0)
        {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","update main image successfully!","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok","update main image failed!","")
        );
    }
    @Autowired
    public ControllerOfCourse(InterfaceOfCourseSort courseSort) {
        this.courseSort = courseSort;
    }
    private final InterfaceOfCourseSort courseSort;
    @Override
    public List<ResponeCourseDTO> getCoursesByPriceHigher(){
        List<Course> courses=courseRepository.findAllByOrderByPriceDesc();
        return  fromCourseListToResponeCourseDTOList(courses);
    }
    @Override
    public List<ResponeCourseDTO> getCoursesByPriceLower(){
        List<Course> courses=courseRepository.findAllByOrderByPriceAsc();
        return  fromCourseListToResponeCourseDTOList(courses);
    }

    @Override
    public List<ResponeCourseDTO> getCoursesByDateNew(){
        List<Course> courses=courseRepository.findAllByOrderByDateDesc();
        return  fromCourseListToResponeCourseDTOList(courses);
    }

    @Override
    public List<ResponeCourseDTO> getCoursesByDateOld(){
        List<Course> courses=courseRepository.findAllByOrderByDateAsc();
        return  fromCourseListToResponeCourseDTOList(courses);

    }

    public ResponeCourseDTO showSectionAndVideo(@RequestParam int id) {
        Course course = courseRepository.findById(id);
        return fromCourseToResponeCourseDTO(course);
    }

    public  List<ResponeCourseDTO>  displayIsNotApprovedCourses() {
        List<Course> courseList = courseRepository.displayIsNotApprovedCourses();
        return fromCourseListToResponeCourseDTOList(courseList);
    }

}
