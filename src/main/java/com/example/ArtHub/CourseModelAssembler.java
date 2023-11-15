package com.example.ArtHub;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.ArtHub.Controller.ControllerOfCourse;
import com.example.ArtHub.Entity.Course;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CourseModelAssembler implements RepresentationModelAssembler<Course, EntityModel<Course>> {

    @Override
    public EntityModel<Course> toModel(Course course) {

        return EntityModel.of(course, //
                linkTo(methodOn(ControllerOfCourse.class).findCoursesByInstructorId(course.getAccount().getId())).withSelfRel());
    }
}
