package UsersFactory;

import Users.Student;
import Users.Teacher;
import Users.User;

public class UserFactory {
    private UserFactory() {}

    public static User createUser(String name, String email, String password, UserType userType) {
        switch (userType) {
            case Student:
                return new Student(name, email, password);
            case Teacher:
                return new Teacher(name, email, password);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}
