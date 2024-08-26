package com.vipul.course_management_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_instance")
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_year", nullable = false)
    private int deliveryYear;

    @Column(name = "semester", nullable = false)
    private int semester;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeliveryYear(int deliveryYear) {
        this.deliveryYear = deliveryYear;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public int getDeliveryYear() {
        return deliveryYear;
    }

    public int getSemester() {
        return semester;
    }

    public Course getCourse() {
        return course;
    }
}
