package pattern.dao;

import java.util.List;

public interface DAO<T> {
    public void add(T o);

    public void remove(String id);

    public void update(T o);

    public List<T> getList();
}
