package com.udemy.springcourse.webservice.resources;

import com.udemy.springcourse.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll () {
        User user = new User(1L, "Ruan", "ruan@gmail.com", "99999999", "12233");
        return ResponseEntity.ok().body(user);
    }
}
