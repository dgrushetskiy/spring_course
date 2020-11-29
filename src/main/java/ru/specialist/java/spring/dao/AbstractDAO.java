package ru.specialist.java.spring.dao;

import java.util.List;

public interface AbstractDAO<T> {

    void create(T dto);

    List<T> getAll();

    T getById(long id);

    void update(long id, T dto);

    void delete(long id);
}
