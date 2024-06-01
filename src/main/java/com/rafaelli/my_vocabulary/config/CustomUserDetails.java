package com.rafaelli.my_vocabulary.config;

import com.rafaelli.my_vocabulary.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private Student student;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.student.getUserRole().name());
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return this.student.getPassword();
    }

    @Override
    public String getUsername() {
        return this.student.getEmail();
    }
}
