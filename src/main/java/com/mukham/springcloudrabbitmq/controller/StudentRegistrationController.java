package com.mukham.springcloudrabbitmq.controller;

import com.mukham.springcloudrabbitmq.model.Student;
import com.mukham.springcloudrabbitmq.source.StudentRegistrationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(StudentRegistrationSource.class)
public class StudentRegistrationController {
    @Autowired
    StudentRegistrationSource studentRegistrationSource;

    @PostMapping("/register")
    public String register(@RequestBody Student student) {
        studentRegistrationSource.studentRegistration().send(MessageBuilder.withPayload(student).build());
        return "Student Registered";
    }
}
