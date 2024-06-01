package com.rafaelli.my_vocabulary.config;

import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> optionalStudent = studentRepo.findByEmail(username);

        if(optionalStudent.isPresent()) {
            return new CustomUserDetails(optionalStudent.get());
        }

        throw new UsernameNotFoundException("Student email could not be found!");
    }
}
