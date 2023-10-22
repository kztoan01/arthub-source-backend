package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.*;
import com.example.ArtHub.Entity.Category;
import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.InterfaceOfControllers.InterfaceOfCourseController;
import com.example.ArtHub.MailConfig.MailDetail;
import com.example.ArtHub.MailConfig.MailService;
import com.example.ArtHub.Repository.*;
import com.example.ArtHub.ResponeObject.ResponeObject;
import com.example.ArtHub.Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));


    private static final Logger logger = LoggerFactory.getLogger(ControllerOfCourse.class);

    @Autowired
    ServiceOfCourse courseService;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionRepository sectionRepository;

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
    CategoryCourseRepository categoryCourseRepository;

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    LearningObjectiveRepository learningObjectiveRepository;




    @Autowired
    private MailService mailService;


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
        if(course.getAccountId() == null)
        {
            logger.info("Id is null;");
        }
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCoupon(course.getCoupon());
        courseDTO.setId(course.getId());
        courseDTO.setLanguage(course.getLanguage());
        courseDTO.setLevel(course.getLevel());
        courseDTO.setAccountId(course.getAccountId());
        courseDTO.setStatus(course.getStatus());
        courseDTO.setPassed(course.getPassed());
        courseDTO.setIntroduction(course.getIntroduction());
        courseDTO.setImage(course.getImage());
        courseDTO.setDate(course.getDate());
        courseDTO.setSections(fromSectionListToResponeSectionDTOList(sectionService.getSectionList(course.getId())));
        courseDTO.setImages(imageRepository.findByCourseId(course.getId()));
        courseDTO.setBio(accountRepository.findById(course.getAccountId()).get().getBio());
        courseDTO.setInstructorName(accountRepository.findById(course.getAccountId()).get().getFirstname()+" "+accountRepository.findById(course.getAccountId()).get().getLastname());
        courseDTO.setInstructorImage(accountRepository.findById(course.getAccountId()).get().getImage());
        courseDTO.setInstructorAddress(accountRepository.findById(course.getAccountId()).get().getAddress());
        courseDTO.setInstructorEmail(accountRepository.findById(course.getAccountId()).get().getEmail());
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
            sectionService.createSection(createSectionDTO, course.getId(),course.getAccountId());
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
    public List<ResponeCourseDTO> getUnapprovedCourses() {
        return null;
    }

//    @Override
//    public List<ResponeCourseDTO> getUnapprovedCourses() {
//        List<Course> courseListFromDB = courseRepository.getUnapprovedCourse();
//        List<ResponeCourseDTO> responeCourseDTOList = fromCourseListToResponeCourseDTOList(courseListFromDB);
//        return responeCourseDTOList;
//    }

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
    public ResponseEntity<ResponeObject> updateStatusOfCourse(@RequestParam int courseId, String InstructorEmail, String StaffMessages , @RequestParam int action) throws AppServiceExeption, IOException {
        String messageBody = "";
        String subject = "";
        String status = "";
        String courseName = courseRepository.findById(courseId).getName();
        if(action == -1)
        {
            List<Section> sections = sectionService.getSectionList(courseId);
            for (Section section: sections) {
                int rs = videoRepository.deleteVideosBySectionID(section.getId());
                if(rs!= 0)
                {
                    logger.info("Deleted course video;");
                }
            }

            if(imageRepository.deleteImageByCourseId(courseId)!= 0)
            {
                logger.info("Deleted course image;");
            }


            if(sectionRepository.deleteSectionsByCourseID(courseId)!= 0)
            {
                logger.info("Deleted course section;");
            }


            if(categoryCourseRepository.deleteCategoryCourseByCourseID(courseId)!= 0)
            {
                logger.info("Deleted categoryCourse;");
            }


            if(learningObjectiveRepository.deleteLearningObjectivesByCourseID(courseId)!= 0)
            {
                logger.info("Deleted learningObjective;");
            }


            if(courseRepository.deleteViolatedCourse(courseId)!= 0)
            {
                logger.info("Deleted course;");
            }


            status = "Violate Course deleted";
            messageBody = "Dear Instructor,\n\nWe regret to inform you that your course ," + courseName + ", has been rejected due to a violation of ArtHub's privacy policy. Our team has determined that the course content infringes upon the privacy of the ArtHub application and its users.\n\n"+ StaffMessages +"\n\nWe take the privacy and security of our platform and community very seriously, and we cannot allow any content that compromises this. We encourage you to review our privacy policy and ensure that any future courses you submit comply with our guidelines.\n\nThank you for your understanding.\n\nBest regards,\n\n[ArtHub Staff]\n[ArtHub]\n\n🚫🔒🙅‍♀️ Avatar";
            subject = "Your Course Has Been Rejected!";

        }
        else if(action == 2)
        {
            status = "Course approved";
            if (courseRepository.updateCourseStatus(courseId, 2) != 0) {
                messageBody = "Dear instructor,\n\nWe are pleased to inform you that your course, " + courseName + ", has been approved and is now available on our online drawing course platform. Congratulations!\n\nYour course has passed our rigorous review process, and we believe it will be a valuable addition to our platform. We appreciate your hard work and dedication in creating a quality course that will help children in Vietnam learn to draw.\n\nYour course is now live and available for students to enroll. You can log in to your instructor dashboard to view the number of registered students, comments, and reports from your course. We encourage you to engage with your students and provide them with the best learning experience possible.\n\nThank you for choosing our platform to share your knowledge and expertise. We look forward to working with you and helping you grow your audience.\n\nBest regards,\n\n[ArtHub staff]\n[ArtHub]\n\nAvatar";
                subject = "Your Course Has Been Approved!";
            }
        }
        else {
            status = "Course details setting are done!";
            if (courseRepository.updateCourseStatus(courseId, 1) != 0) {
                messageBody = "Dear instructor,\n\nWe are pleased to inform you that the course details for your course, " + courseName + ", have been successfully set up on our online drawing course platform. Your course is now being reviewed by our team to ensure it meets our quality standards.\n\nOnce your course has passed our rigorous review process, it will be made available on our platform for students to enroll. You will be notified via email when your course is approved and live on our platform.\n\nWe appreciate your hard work and dedication in creating a quality course that will help children in Vietnam learn to draw. Thank you for choosing our platform to share your knowledge and expertise.\n\nIf you have any questions or concerns, please don't hesitate to contact us.\n\nBest regards,\n[ArtHub staff]\n[ArtHub]\nAvatar";
                subject = "Your Course are being validated!";
            }
        }
        MailDetail mailDetail = new MailDetail();
        mailDetail.setMsgBody(messageBody);
        mailDetail.setRecipient(InstructorEmail);
        mailDetail.setSubject(subject);
        mailService.sendMail(mailDetail);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok",  status  + "  successfully!\n" + mailService.sendMail(mailDetail), "")
        );
    }
    @Override
    public ResponseEntity<ResponeObject> sendMailToReceiver(@RequestParam int courseId, String receiverEmail,String SenderMessages, String receiverName,String receiverPassword,String senderName, @RequestParam int action) throws AppServiceExeption, IOException {
        String messageBody = "";
        String subject = "";
        String courseName = courseRepository.findById(courseId).getName();
        Float coursePrice = courseRepository.findById(courseId).getPrice();
        if(action == 1) // receiver dont have arthub account
        {
            messageBody = "Hello " + receiverName +", you are given a drawing course named " + courseName +" on the online teaching and learning platform ArtHub that worth " +coursePrice+"$\n\n" +
                "The sender is " + senderName +" with the following message:\n\n" +
                SenderMessages +"\n\n\n" +
                "We notice that your email address does not currently have an account on ArtHub. We are very sorry about this.\n\n" +
                "However, you can still access the gifted course by accessing the account we created for you.\n\n" +
                "Account contents are as follows:\n\n" +
                "Email: " + receiverEmail +"\n\n\n" +
                "Password: " + receiverPassword +"\n\n\n" +
                "After logging in, change your personal information including your password to increase security.\n\n" +
                "You will then have full access to the " + courseName +" course sent to you by " + senderName +"\n\n"+
                "Visit the ArtHub website at http://localhost:3000/ and start learning now!!!\n\n" +
                "If you have any questions or concerns, please don't hesitate to contact us.\n\nBest regards,\n[ArtHub staff]\n[ArtHub]\nAvatar";
            subject = "You are given a course on ArtHub worth " +coursePrice;
        }
        else if(action == 2) // receiver have arthub account
        {
            messageBody = "Hello " + receiverName +", you are given a drawing course named " + courseName +" on the online teaching and learning platform ArtHub that worth " +coursePrice+"\n\n" +
                    "The sender is " + senderName +" with the following message:\n\n" +
                    SenderMessages +"\n\n\n" +
                    "We noticed that you already have an ArtHub account using this email as your login name.\n\n" +
                    "Account contents are as follows:\n\n" +
                    "Email: " + receiverEmail +"\n\n\n" +
                    "Password: ######## \n\n\n" +
                    "After logging in, you will then have full access to the " + courseName +" course sent to you by " + senderName +"\n\n"+
                    "Visit the ArtHub website at http://localhost:3000/ and start learning now!!!\n\n" +
                    "If you have any questions or concerns, please don't hesitate to contact us.\n\nBest regards,\n[ArtHub staff]\n[ArtHub]\nAvatar";
            subject = "You are given a course on ArtHub worth " +coursePrice;
        }
        MailDetail mailDetail = new MailDetail();
        mailDetail.setMsgBody(messageBody);
        mailDetail.setRecipient(receiverEmail);
        mailDetail.setSubject(subject);
        mailService.sendMail(mailDetail);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok",  "ok"  + "  successfully!\n" + mailService.sendMail(mailDetail), "")
        );
    }
    public int updateCourseStatusTo1(@RequestParam int courseId,@RequestParam int status ) {
        int update = courseRepository.updateCourseStatus(courseId,status);
        return update;
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

    @Override
    public List<ResponeCourseDTO> displayIsNotApprovedCourses() {
        List<Course> courseList = courseRepository.displayIsNotApprovedCourses();
        return fromCourseListToResponeCourseDTOList(courseList);
    }

    public ResponeCourseDTO showSectionAndVideo(@RequestParam int id) {
        Course course = courseRepository.findById(id);
        return fromCourseToResponeCourseDTO(course);
    }

//    public  List<ResponeCourseDTO>  displayIsNotApprovedCourses() {
//        List<Course> courseList = courseRepository.displayIsNotApprovedCourses();
//        return fromCourseListToResponeCourseDTOList(courseList);
//    }

}
