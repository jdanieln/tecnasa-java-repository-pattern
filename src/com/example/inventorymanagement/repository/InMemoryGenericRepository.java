package com.example.inventorymanagement.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class InMemoryGenericRepository<T, ID> implements GenericRepository<T, ID> {
    private final List<T> entities = new ArrayList<>();
    private long currentId = 1L;

    protected abstract ID getId(T entity);
    protected abstract void setId(T entity, ID id);

    @Override
    public T save(T entity) {
        ID id = getId(entity);
        if (id == null) {
            setId(entity, (ID) Long.valueOf(currentId++));
            entities.add(entity);
        } else {
            int index = entities.indexOf(findById(id).orElse(null));
            if (index >= 0) {
                entities.set(index, entity);
            } else {
                entities.add(entity);
            }
        }
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return entities.stream()
                .filter(entity -> getId(entity).equals(id))
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void deleteById(ID id) {
        entities.removeIf(entity -> getId(entity).equals(id));
    }
}
