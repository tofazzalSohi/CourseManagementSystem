package ContextSingleton;

import ContextStrategy.*;
import java.util.List;

public class Context {
    
    private Strategy strategy;
    static private Context userContext = null;
    static private Context courseContext = null;
    
    public static Context getUserContext(){
        if(userContext == null) {
            userContext = new Context(new UserContext());
            return userContext;
        }
        else return userContext;
    }
    
    public static Context getCourseContext(){
        if(courseContext == null){
            courseContext = new Context(new CourseContext());
            return courseContext;
        }
        else return courseContext;
    }
    
    private Context(Strategy strategy){
        this.strategy = strategy;
    }
    
    public Object get(int id){
        return strategy.get(id);
    }
    
    public Object get(String email){
        return strategy.get(email);
    }
    
    public boolean add(Object o){
        return strategy.add(o);
    }
    
    public boolean remove(Object o){
        return strategy.remove(o);
    }
    
    public int getNewId(){
        return strategy.getNewId();
    }
    
    public List<Object> getAll(){
        return strategy.getAll();
    }
}
