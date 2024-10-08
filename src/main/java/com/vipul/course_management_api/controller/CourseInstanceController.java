package com.vipul.course_management_api.controller;


import com.vipul.course_management_api.model.CourseInstance;
import com.vipul.course_management_api.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        CourseInstance savedCourseInstance = courseInstanceService.saveCourseInstance(courseInstance);
        return ResponseEntity.ok(savedCourseInstance);
    }

    @GetMapping("/{deliveryYear}/{semester}")
    public ResponseEntity<List<CourseInstance>> getInstancesByYearAndSemester(@PathVariable int deliveryYear, @PathVariable int semester) {
        return ResponseEntity.ok(courseInstanceService.getInstancesByYearAndSemester(deliveryYear, semester));
    }

    @GetMapping("/{delivertYear}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getCourseInstanceById(@PathVariable int delivertYear, @PathVariable int semester, @PathVariable Long id) {
        Optional<CourseInstance> courseInstance = courseInstanceService.getInstanceById(id);
        return courseInstance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{delivertYear}/{semester}/{id}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable int deliveryYear, @PathVariable int semester, @PathVariable Long id) {
        courseInstanceService.deleteByYearSemesterCourse(deliveryYear, semester, id);
        return ResponseEntity.noContent().build();
    }
}

