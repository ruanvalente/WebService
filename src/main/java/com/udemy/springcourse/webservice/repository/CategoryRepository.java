package com.udemy.springcourse.webservice.repository;

import com.udemy.springcourse.webservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> { }
