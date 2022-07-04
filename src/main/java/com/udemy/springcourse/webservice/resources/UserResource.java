package com.udemy.springcourse.webservice.resources;

import com.udemy.springcourse.webservice.entities.User;
import com.udemy.springcourse.webservice.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;
    @GetMapping
    public ResponseEntity<List<User>> listAllUser () {
        List<User> user = userServices.listAllUsers();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") Long id) {
        Optional<User> user = userServices.findByUserId(id);

        return user.map(value -> ResponseEntity.ok()
                .body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
