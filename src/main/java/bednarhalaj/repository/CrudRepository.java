package bednarhalaj.repository;

import java.util.List;

public interface CrudRepository<T> {
    void create(T entity);
    T read(Class<T> entityClass, Integer id);
    List<T> readAll();
    T update(T entity);
    void delete(T entity);
}