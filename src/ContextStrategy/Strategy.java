package ContextStrategy;

import java.util.List;

public interface Strategy {
    Object get(int id);
    boolean add(Object o);
    boolean remove(Object o);
    List<Object> getAll();
    public Object get(String email);
    public int getNewId();
}
