package com.vipul.course_management_api.service;

import com.vipul.course_management_api.repository.CourseInstanceRepository;
import com.vipul.course_management_api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataCleanupService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    public void deleteAllData(){
        courseInstanceRepository.deleteAll();

        courseRepository.deleteAll();
    }
}
