package com.rafaelli.my_vocabulary.repository;

import com.rafaelli.my_vocabulary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);
}
