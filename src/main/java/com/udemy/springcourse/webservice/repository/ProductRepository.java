package com.udemy.springcourse.webservice.repository;

import com.udemy.springcourse.webservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }
