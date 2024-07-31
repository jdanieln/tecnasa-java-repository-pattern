package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.model.Product;

public class InMemoryProductRepository extends InMemoryGenericRepository<Product, Long> implements ProductRepository {
    @Override
    protected Long getId(Product entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Product entity, Long id) {
        entity.setId(id);
    }
}
