package ContextStrategy;

import DB.UserBase;
import Users.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserContext implements Strategy {

    private List<Object> users = new ArrayList<>();
    private UserBase userBase = new UserBase();

    @Override
    public Object get(int id) {
        for (Object o : users) {
            User user = (User) o;
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        try {
            boolean exist = false;
            User user = (User) o;
            List<Object> users = getAll();
            for (int i=0; i<users.size()-1; i++) {
                Object e = users.get(i);
                User eu = (User) e;
                if(eu.getEmail().equals(user.getEmail())) return false;
            }
            if(!exist && userBase.addUser(user)){
                users.add(user);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            User user = (User) o;
            users.remove(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Object> getAll() {
        return users;
    }

    @Override
    public Object get(String email) {
        for(Object o: users){
            User user = (User) o;
            if(user.getEmail().equals(email)) 
                return user;
        }
        return null;
    }

    @Override
    public int getNewId() {
        List<Object> list = getAll();
        Set<Integer> ids = new HashSet<>();
        for(Object o: list){
            User user = (User) o;
            ids.add(user.getId());
        }
        for(int i=1; i>0; i++){
            if(!ids.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
