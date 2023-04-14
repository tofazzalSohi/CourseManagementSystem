package Users;

import ContextSingleton.Context;
import Courses.Course;
import UsersFactory.UserType;
import java.util.List;

public abstract class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private UserType type;

    Context context = Context.getUserContext();

    public User(String name, String email, String password, UserType type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;

        id = context.getAll().size();
        context.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return type;
    }

    public abstract boolean addCourse(Course course);

    public abstract boolean dropCourse(int id);

    public abstract boolean payment(double balance);

    public abstract String seePayments();

    public abstract List<Course> getCourses();

    @Override
    public String toString() {
        return " - Id: " + id + "\n - Name: " + name + "\n - Email: " + email + "\n - Type: " + type+".\n";
    }
}