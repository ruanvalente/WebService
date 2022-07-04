package com.udemy.springcourse.webservice.resources;

import com.udemy.springcourse.webservice.entities.Category;
import com.udemy.springcourse.webservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listAllCategories () {
        List<Category> categories = categoryService.findAllCategories();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById (@PathVariable(value =
            "id") Long id) {
        Optional<Category> category = categoryService.getCategoryById(id);

        return category.map(value -> ResponseEntity.ok()
                .body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
