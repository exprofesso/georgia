package by.georgia.repository;

public interface CrudRepository<K, V> {
    V update(V object);

    V findById(K key);
}
