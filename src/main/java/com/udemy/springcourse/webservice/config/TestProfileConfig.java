package com.udemy.springcourse.webservice.config;

import com.udemy.springcourse.webservice.entities.Category;
import com.udemy.springcourse.webservice.entities.Order;
import com.udemy.springcourse.webservice.entities.Product;
import com.udemy.springcourse.webservice.entities.User;
import com.udemy.springcourse.webservice.entities.enums.OrderStatus;
import com.udemy.springcourse.webservice.repository.CategoryRepository;
import com.udemy.springcourse.webservice.repository.OrderRepository;
import com.udemy.springcourse.webservice.repository.ProductRepository;
import com.udemy.springcourse.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) {
        User user1 = new User(
                null,
                "Freeman Romana",
                "freeman.romana@gmail.com", "99999999",
                "11929292"
        );
        User user2 = new User(
                null,
                "Ada Rauha",
                "ada.rauha@gmail.com",
                "55999299",
                "2291928"
        );

        Order order1 = new Order(
                null,
                Instant.parse("2022-06-20T19:53:07Z"),
                OrderStatus.PAID,
                user1
        );
        Order order2 = new Order(
                null,
                Instant.parse("2022-07-21T03:42:10Z"),
                OrderStatus.WAITING_PAYMENT,
                user2
        );
        Order order3 = new Order(
                null,
                Instant.parse("2022-07-22T15:21:22Z"),
                OrderStatus.WAITING_PAYMENT,
                user1
        );

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null,  "Book");
        Category category3 = new Category(null, "Computers");

        Product product1 = new Product(
                null,
                "The Lord of the Rings",
                "Lorem ipsum dolor sit amet, consectetur.",
                90.5,
                ""
        );
        Product product2 = new Product(
                null,
                "Smart TV",
                "Nulla eu imperdiet purus. Maecenas ante.",
                2190.0,
                ""
        );
        Product product3 = new Product(
                null,
                "Macbook Pro",
                "Nam eleifend maximus tortor, at mollis.",
                1250.0,
                ""
        );
        Product product4 = new Product(
                null,
                "PC Gamer",
                "Donec aliquet odio ac rhoncus cursus.",
                1200.0,
                ""
        );
        Product product5 = new Product(
                null,
                "Rails for Dummies",
                "Cras fringilla convallis sem vel faucibus.",
                100.99,
                ""
        );

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(
                category1,
                category2,
                category3
                )
        );
        productRepository.saveAll(
                Arrays.asList(
                        product1,
                        product2,
                        product3,
                        product4,
                        product5
                )
        );
    }
}
