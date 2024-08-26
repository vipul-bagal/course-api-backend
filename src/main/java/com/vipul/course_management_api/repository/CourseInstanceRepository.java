package com.vipul.course_management_api.repository;

import com.vipul.course_management_api.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByDeliveryYearAndSemester(int deliveryYear, int semester);

    List<CourseInstance> findByDeliveryYearAndSemesterAndCourse_Id(@Param("deliveryYear") int deliveryYear, @Param("semester") int semester, @Param("courseId") Long courseId);

    @Modifying
    void deleteByDeliveryYearAndSemesterAndCourse_Id(@Param("deliveryYear") int deliveryYear, @Param("semester") int semester, @Param("courseId") Long courseId);
}
