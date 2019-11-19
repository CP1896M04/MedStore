package pattern.bus;

public interface BUS<T> {
    //Void add object T to database
    public  void add(T o);
    //Void update object to database
    public void update(T o);
    //Void delete object to database
    public void delete(String id);
}
