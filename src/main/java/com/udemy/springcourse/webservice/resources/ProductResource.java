package com.udemy.springcourse.webservice.resources;

import com.udemy.springcourse.webservice.entities.Product;
import com.udemy.springcourse.webservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listAllProducts () {
        List<Product> products = productService.listAllProducts();

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
        Optional<Product> product = productService.getProductById(id);

        return product.map(value -> ResponseEntity.ok()
                .body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
