package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.getReferenceById(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/add")
    public List<Product> createProduct(@RequestBody Product newProduct) {
        productRepository.save(newProduct);

        return productRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public List<Product> deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);

        return productRepository.findAll();
    }

    @GetMapping("/max/{cost}")
    public List<Product> getProductByMaxCost(@PathVariable int cost) {
        return productRepository.getProductsByMaxCost(cost);
    }

    @GetMapping("/min/{cost}")
    public List<Product> getProductByMinCost(@PathVariable int cost) {
        return productRepository.getProductsByMinCost(cost);
    }

    @GetMapping("/range/{costMin}/{costMax}")
    public List<Product> getProductsByCostInRange(@PathVariable int costMin, @PathVariable int costMax) {
        return productRepository.getProductsByCostInRange(costMin, costMax);
    }
}
