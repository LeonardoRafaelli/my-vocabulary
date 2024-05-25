package com.rafaelli.my_vocabulary.repository;

import com.rafaelli.my_vocabulary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
