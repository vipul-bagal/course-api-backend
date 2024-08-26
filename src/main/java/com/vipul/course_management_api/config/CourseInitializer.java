package com.vipul.course_management_api.config;

import com.vipul.course_management_api.event.CourseInitializeEvent;
import com.vipul.course_management_api.model.Course;
import com.vipul.course_management_api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void run(String... args) throws Exception {

        List<Course> courses = new ArrayList<>();

        // Adding sample courses to the list
        courses.add(new Course("Java beginner to advanced", "c01", "Full Java course designed for beginners"));
        courses.add(new Course("Python for Data Science", "c02", "Comprehensive Python course with data science applications"));
        courses.add(new Course("Web Development with JavaScript", "c03", "Learn to build dynamic websites using JavaScript"));
        courses.add(new Course("Data Structures and Algorithms", "c04", "In-depth course on data structures and algorithms"));
        courses.add(new Course("Machine Learning Basics", "c05", "Introduction to machine learning concepts and algorithms"));
        courses.add(new Course("Spring Boot and Microservices", "c06", "Develop microservices using Spring Boot framework"));
        courses.add(new Course("Introduction to Databases", "c07", "Understanding relational databases and SQL"));
        courses.add(new Course("Frontend Development with React", "c08", "Build interactive UIs using React"));
        courses.add(new Course("DevOps Essentials", "c09", "Fundamentals of DevOps practices and tools"));
        courses.add(new Course("Advanced Java Programming", "c10", "Deep dive into advanced Java topics"));
        courses.add(new Course("Cloud Computing with AWS", "c11", "Learn to deploy applications on AWS cloud"));
        courses.add(new Course("Android App Development", "c12", "Create mobile applications for Android devices"));
        courses.add(new Course("Cyber Security Basics", "c13", "Introduction to cyber security principles"));
        courses.add(new Course("Kotlin for Java Developers", "c14", "Transition from Java to Kotlin for Android development"));
        courses.add(new Course("Artificial Intelligence", "c15", "Introduction to AI and its applications"));

        for(Course item: courses){
            courseRepository.save(item);
        }

        publisher.publishEvent(new CourseInitializeEvent(this));
    }
}
