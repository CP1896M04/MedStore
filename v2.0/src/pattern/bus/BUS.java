package pattern.bus;

public interface BUS<T> {
<<<<<<< HEAD
    //Void add object T to database
    public  void add(T o);
    //Void update object to database
    public void update(T o);
    //Void delete object to database
    public void delete(T o);
    //Check is true update
    public boolean isTrueUpdate(T o);
    //Check is an unique name of object T
    public boolean isUniqueName(T o);

=======
    public void add(T o);
    public void update(T o);
    public void delete(T o);
    public boolean isTrueUpdate(T o);
    public boolean isUniqName(T o);
>>>>>>> 3ecfc4fa8522d906303f7d38e882c5fbdf94d9e4
}
