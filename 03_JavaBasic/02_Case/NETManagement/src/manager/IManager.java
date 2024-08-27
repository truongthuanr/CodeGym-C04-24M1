package manager;

import model.Device;

import java.util.List;

public interface IManager<T> {
    void add(T t);

    void update(int id, T t);

    void delete(int id);

    int findIndexByID(int id);

    List<T> getAll();


}
