package com.rafaelli.my_vocabulary.service;

import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public Student save(Student student){
        return studentRepo.save(student);
    }

    public Student getByUsername(String username) {
        return studentRepo.getByUsername(username);
    }

    public Student getLoggedUser() {
        return studentRepo.getByUsername("leorafaelli");
    }

}
