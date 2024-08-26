package com.vipul.course_management_api.config;

import com.vipul.course_management_api.event.CourseInitializeEvent;
import com.vipul.course_management_api.model.Course;
import com.vipul.course_management_api.model.CourseInstance;
import com.vipul.course_management_api.repository.CourseInstanceRepository;
import com.vipul.course_management_api.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class CourseInstanceInitializer  {

    private static final Logger logger = LoggerFactory.getLogger(CourseInstanceInitializer.class);


    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @EventListener
    public void handleEvent(CourseInitializeEvent event){
        if(courseRepository.count() > 0){
            List<Course> allCourses = courseRepository.findAll();
            Random random = new Random();

            for(Course item: allCourses){
                int instancesToCreate = random.nextInt(2) + 2;

                for (int i = 0; i < instancesToCreate; i++) {
                    int deliveryYear = 2022;
                    deliveryYear  += random.nextInt(5); // Random year between 2022 and 2026
                    int semester = random.nextInt(2) + 1; // Random semester, 1 or 2

                    CourseInstance instance = new CourseInstance();
                    instance.setDeliveryYear(deliveryYear);
                    instance.setSemester(semester);
                    instance.setCourse(item);

                    logger.info("Creating CourseInstance for course: {}, year: {}, semester: {}", item.getTitle(), instance.getDeliveryYear(), semester);

                    courseInstanceRepository.save(instance);
                }

            }
        }
    }


}
