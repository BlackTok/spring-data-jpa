package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = """
            select * from product where cost > :cost""")
    List<Product> getProductsByMaxCost(int cost);

    @Query(nativeQuery = true, value = """
            select * from product where cost < :cost""")
    List<Product> getProductsByMinCost(int cost);

    @Query(nativeQuery = true, value = """
            select * from product where cost > :costMin and cost < :costMax""")
    List<Product> getProductsByCostInRange(int costMin, int costMax);
}
