package com.udemy.springcourse.webservice.config;

import com.udemy.springcourse.webservice.entities.User;
import com.udemy.springcourse.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Freeman Romana", "freeman.romana@gmail.com", "99999999", "11929292");
        User user2 = new User(null, "Ada Rauha", "ada.rauha@gmail.com", "55999299", "2291928");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
