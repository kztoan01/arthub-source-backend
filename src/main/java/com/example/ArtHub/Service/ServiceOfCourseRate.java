package com.example.ArtHub.Service;

import com.example.ArtHub.Repository.CourseRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfCourseRate implements InterfaceOfCourseRate{

    @Autowired
    CourseRateRepository courseRateRepository;
    @Override
    public int deleteCourseRateByCourseId(int id) {
        return courseRateRepository.deleteCourseRateByCourseId(id);
    }
}
