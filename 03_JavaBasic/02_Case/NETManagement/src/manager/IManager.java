package manager;

import java.util.List;

public interface IManager<T> {
    void add(T t);
    void update(T t);
    void delete(T t);
    List<T> getAll();
    int findIndexByID(int id);
    
}
