package main.java.dao;

import java.util.List;

public interface DAO<T>{
    public void add(T o);

    public void remove(T o);

    public void update(T o);

    public List<T> getList();
}
