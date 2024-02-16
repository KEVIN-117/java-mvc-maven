package org.example.controller;

import java.util.List;

public interface Repository<T> {
    public List<T> findAll();

    T findById(String id);

    void save(T t);
    void update(String id, T t);
    void delete(String id);
}
