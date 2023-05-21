package bednarhalaj.crud;

public interface CrudRepository<T> {
    void create(T entity);
    T read(Class<T> entityClass, Integer id);
    T update(T entity);
    void delete(T entity);
}