package com.vipul.course_management_api.event;

import org.springframework.context.ApplicationEvent;

public class CourseInitializeEvent extends ApplicationEvent {
    public CourseInitializeEvent(Object source) {
        super(source);
    }
}
