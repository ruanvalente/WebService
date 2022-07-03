package com.udemy.springcourse.webservice.repository;

import com.udemy.springcourse.webservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
