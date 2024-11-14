package service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();

    void add(T t);
    void update(int id,T t);
    void delete(T t);

    T getById(int id);

    int findIndexById(int id);
}
