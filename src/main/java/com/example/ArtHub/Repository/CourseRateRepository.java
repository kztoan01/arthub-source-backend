package com.example.ArtHub.Repository;


import com.example.ArtHub.Entity.CourseRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CourseRateRepository extends JpaRepository<CourseRate,Integer> {

    @Query("SELECT cr FROM CourseRate  cr WHERE cr.courseId=?1")
    List<CourseRate> getCourseRateByCourseId(Integer courseId);

    Optional<CourseRate> getCourseRateByAccountIdAndCourseId(Integer accountId, Integer courseId);
    @Modifying
    @Transactional
    @Query("UPDATE CourseRate cr SET cr.comment = ?1 WHERE cr.id=?2")
    int updateAnn(String comment,int id);
    @Modifying
    @Transactional
    @Query("DELETE CourseRate cr WHERE cr.id=?1")
    int deleteAnn(int id);
    @Query("SELECT c FROM CourseRate c WHERE c.courseId = ?1")
    List<CourseRate> showCourseRateByCourseId(Integer courseId);
    @Query("SELECT COUNT(c.courseId) FROM CourseRate c WHERE c.courseId = ?1 AND c.rate > 0")
    Integer countCourseRateByCourseId(Integer courseId);
    @Query("SELECT ROUND(AVG(c.rate), 0) FROM CourseRate c WHERE c.courseId = ?1 AND c.rate > 0")
    Float avgCourseRateByCourseId(Integer courseId);

}
