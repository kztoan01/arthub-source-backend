package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LearnerRepository extends JpaRepository<Learner, Integer> {

    @Query("SELECT l FROM Learner l WHERE l.account.id = ?1 AND l.price > 0")
    List<Learner> showStudentPurchaseByAccountId(Integer accountId);


    @Query(value = "SELECT SUM(Course.price) as SumProfit FROM Course JOIN Learner ON Course.id = Learner.courseId where Course.id = ?1",nativeQuery = true)
    Integer getCourseProfitsByCourseID(int id);




    @Query(value = "SELECT SUM(CASE WHEN MONTH(l.date) = MONTH(DATEADD(month, -1, GETDATE())) THEN c.price ELSE 0 END) AS lastMonthProfit FROM Course c JOIN Learner l ON c.id = l.courseId WHERE c.id = ?1", nativeQuery = true)
    Integer getCourseLastMonthProfitsByCourseID(int id);


    @Query("SELECT COUNT(DISTINCT l.account.id) FROM Learner l WHERE l.ownerCourse = :owner GROUP BY l.ownerCourse")
    Integer countDistinctAccountIdByOwner(@Param("owner") int owner);

    @Query(value = "SELECT SUM(CASE WHEN MONTH(Learner.[date]) = MONTH(DATEADD(month, -1, getdate()))THEN Course.price ELSE 0 END) as lastMonthProfit FROM Course JOIN Learner ON Course.id = Learner.courseId where Learner.ownerCourse = ?1",nativeQuery = true)
    Double sumOfProfit(int owner);

    @Query("SELECT l from Learner l where l.account.id = ?1 and l.course.id = ?2")
    Learner findById(int id,int courseId);


    @Query("select a from Learner l join Account a on a.id = l.account.id where l.course.id = ?1")
    List<Account> findLeanerOfCourse(int courseID);

    Optional<Learner> findByAccountIdAndCourseId(Integer accountId,Integer courseId);

    List<Learner> findByAccountId(Integer accountId);
}
