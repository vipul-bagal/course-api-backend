package com.vipul.course_management_api.controller;

import com.vipul.course_management_api.service.DataCleanupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private DataCleanupService dataCleanupService;

    @DeleteMapping("/clean")
    public ResponseEntity<String> deleteALlData(){
        dataCleanupService.deleteAllData();
        return new ResponseEntity<>("Cleanup done!", HttpStatus.OK);
    }
}
