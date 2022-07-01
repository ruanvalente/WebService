package com.udemy.springcourse.webservice.services;

import com.udemy.springcourse.webservice.entities.User;
import com.udemy.springcourse.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll () {
        return userRepository.findAll();
    }

    public Optional<User> findById (Long id) {
        return userRepository.findById(id);
    }
}
