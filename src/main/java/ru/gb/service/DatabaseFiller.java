package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;

@Component
public class DatabaseFiller {
    @Autowired
    private ProductRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartApp() {
        repository.save(createProduct("Apple", 80));
        repository.save(createProduct("Banana", 120));
        repository.save(createProduct("Orange", 110));
        repository.save(createProduct("Green Apple", 115));
        repository.save(createProduct("Red Apple", 130));
        repository.save(createProduct("Yellow Apple", 70));
        repository.save(createProduct("Pineapple", 230));
    }

    private Product createProduct(String title, int cost) {
        Product product = new Product();
        product.setTitle(title);
        product.setCost(cost);

        return product;
    }
}
