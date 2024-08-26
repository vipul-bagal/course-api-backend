package com.vipul.course_management_api.service;

import com.vipul.course_management_api.model.CourseInstance;
import com.vipul.course_management_api.repository.CourseInstanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Transactional
    public CourseInstance saveCourseInstance(CourseInstance courseInstance){
        return courseInstanceRepository.save(courseInstance);
    }

    private List<CourseInstance> getAllCourseInstances(){
        return courseInstanceRepository.findAll();
    }

    public List<CourseInstance> getInstancesByYearAndSemester(int deliveryYear, int semester) {
        return courseInstanceRepository.findByDeliveryYearAndSemester(deliveryYear, semester);
    }

    public List<CourseInstance> findByDeliveryYearAndSemesterAndCourse_Id(int deliveryYear, int semester, Long courseId) {
        return courseInstanceRepository.findByDeliveryYearAndSemesterAndCourse_Id(deliveryYear, semester, courseId);
    }

    public Optional<CourseInstance> getInstanceById(Long id){
        return courseInstanceRepository.findById(id);
    }

    @Transactional
    public void deleteByYearSemesterCourse(int deliveryYear, int semester, Long courseId){
        courseInstanceRepository.deleteByDeliveryYearAndSemesterAndCourse_Id(deliveryYear, semester, courseId);
    }



}
