package com.vipul.course_management_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "course_code", unique = true)
    private String courseCode;

    @Column(name = "description")
    private String description;

    public Course(String title, String courseCode, String description){
        this.title = title;
        this.courseCode = courseCode;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }
}
