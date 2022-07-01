package com.udemy.springcourse.webservice.repository;

import com.udemy.springcourse.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
