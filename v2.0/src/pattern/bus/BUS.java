package pattern.bus;

public interface BUS<T> {
    public void add(T o);
    public void update(T o);
    public void delete(T o);
    public boolean isTrueUpdate(T o);
    public boolean isUniqName(T o);
}
