package com.rafaelli.my_vocabulary.controller;

import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "auth/register";
    }

    @PostMapping("/create-student")
    public RedirectView createStudent(
            @RequestParam("email") String studentEmail,
            @RequestParam("password") String studentPassword
    ){
        Student student = new Student();
        student.setEmail(studentEmail);
        student.setPassword(studentPassword);

        studentService.save(student);

        return new RedirectView("auth/login");
    }

}
