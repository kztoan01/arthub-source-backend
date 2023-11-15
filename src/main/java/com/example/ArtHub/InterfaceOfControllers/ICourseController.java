package com.example.ArtHub.InterfaceOfControllers;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseProfitDTO;
import com.example.ArtHub.ResponeObject.ResponeObject;
import jakarta.validation.Valid;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/course")
public interface ICourseController {

    @GetMapping("/displayIsNotApprovedCourses")
    List<ResponeCourseDTO> displayIsNotApprovedCourses();

    @PostMapping("/showSectionAndVideo")
    ResponeCourseDTO showSectionAndVideo(@RequestParam int id) throws IOException;

    // http://localhost:8080/course/thailan/5000
    @GetMapping("/{language}/{price}")
    List<ResponeCourseDTO> findAllCourseByLanguageAndPrice(@PathVariable String language, @PathVariable float price);

    @GetMapping("/displayProfitsOFCourses")
    List<ResponeCourseProfitDTO> displayProfitsOFCourses();


    @PostMapping("/addCourse")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeCourseDTO createCourse(@RequestBody @Valid CreateCourseDTO dto) throws AppServiceExeption, IOException;

    @GetMapping("/GetCourseByInstructorID/{id}")
    @ResponseStatus(HttpStatus.OK)
    List<ResponeCourseDTO> findCoursesByInstructorId(@PathVariable int id);


    @GetMapping("/getCourses")
    List<ResponeCourseDTO> getCourses();

    @GetMapping("/getUnapprovedCourses")
    List<ResponeCourseDTO> getUnapprovedCourses();


    @GetMapping("/getCourse/{keyword}")//search course by keyword
    List<ResponeCourseDTO> findCourseThatContainsKeyword(@PathVariable String keyword);

    @GetMapping("/getCourse/category/{category}")//search course by LIKE category
    List<ResponeCourseDTO> getCoursesByCategory(@PathVariable String category);

    @PostMapping("/updateCourseStatus")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ResponeObject> updateStatusOfCourse( @PathVariable int courseId,String InstructorEmail,String StaffMessages , @PathVariable int action,String attachment) throws AppServiceExeption, IOException;
    // action = -1 ===> Reject the course ,  action = 1 ==> instructor done setting course details, action = 2 ==> approve the course

    @PostMapping("/sendMailToReceiver")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ResponeObject> sendMailToReceiver( @RequestParam int courseId,String receiverEmail,String SenderMessages, String receiverName,String receiverPassword,String senderName, @RequestParam  int action) throws AppServiceExeption, IOException;

    @PostMapping("/updateCourseStatusTo1")
    public int updateCourseStatusTo1(@RequestParam int courseId,@RequestParam int status );
    @PostMapping("/updateMainImage")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ResponeObject> updateMainImageOfCourse(int courseId, MultipartFile image) throws AppServiceExeption, IOException;

    @GetMapping("/getCourseSort1")
    public List<ResponeCourseDTO> getCoursesByPriceHigher();
    @GetMapping("/getCourseSort2")
    public List<ResponeCourseDTO> getCoursesByPriceLower();

    @GetMapping("/getCourseSort3")
    public  List<ResponeCourseDTO> getCoursesByDateNew();

    @GetMapping("/getCourseSort4")
    public  List<ResponeCourseDTO> getCoursesByDateOld();





}
