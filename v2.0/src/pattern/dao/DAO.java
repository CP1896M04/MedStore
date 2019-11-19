package pattern.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public void add(T o);

    public void remove(String id) throws SQLException;

    public void update(T o);
  public boolean isNotUsed(T o);
    public List<T> getList();
}
