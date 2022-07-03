package com.udemy.springcourse.webservice.resources;

import com.udemy.springcourse.webservice.entities.Order;
import com.udemy.springcourse.webservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> listAllOrders () {
        List<Order> orders = orderService.listAllOrders();

        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long id) {
        Optional<Order> order = orderService.getOrderById(id);

        return order.map(value -> ResponseEntity.ok()
                .body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
