package bednarhalaj.repository;

import bednarhalaj.model.DBEntity;

import java.util.List;

public interface CRUDRepository<T extends DBEntity> {
    void create(T entity) throws IllegalAccessException;
    List<T> readAll() throws IllegalAccessException;
    T update(T entity) throws IllegalAccessException;
    void delete(T entity) throws IllegalAccessException;
}