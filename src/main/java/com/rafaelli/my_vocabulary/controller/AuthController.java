package com.rafaelli.my_vocabulary.controller;

import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/auth")
@Controller
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String getLoginPage(){
        return "auth/login";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "auth/register";
    }

    @PostMapping("/create-student")
    public RedirectView createStudent(
            @ModelAttribute Student student
    ){
        System.out.println(STR."Raw \{student}");
        System.out.println(studentService.save(student));

        return new RedirectView("auth/login");
    }
}
