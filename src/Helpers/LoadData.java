package Helpers;

import Courses.BasicCourse;
import Courses.Course;
import Courses.PremiumCourse;
import DB.CourseBase;
import DB.EnrolBase;
import DB.EnrolPair;
import DB.UserBase;
import Users.User;
import UsersFactory.UserFactory;
import UsersFactory.UserType;
import java.sql.*;
import java.util.*;

public class LoadData {
    
    private UserBase userBase = new UserBase();
    private CourseBase courseBase = new CourseBase();
    private EnrolBase enrolBase = new EnrolBase();
    
    List<User> teachers(){
        List<User> teachers = new ArrayList<>();
        ResultSet result = userBase.getUsers(2);
        try {
            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String pas = result.getString(4);
                int type = result.getInt(5);
                User user = UserFactory.createUser(name, email, pas, UserType.Teacher);
                teachers.add(user);
            }
        } catch (SQLException ex) {}
        return teachers;
    }
    
    List<User> students(){
        List<User> students = new ArrayList<>();
        ResultSet result = userBase.getUsers(1);
        try {
            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String pas = result.getString(4);
                int type = result.getInt(5);
                User user = UserFactory.createUser(name, email, pas, UserType.Student);
                students.add(user);
            }
        } catch (SQLException ex) { }
        return students;
    }
    
    List<Course> courses(){
        List<Course> courses = new ArrayList<>();
        ResultSet result = courseBase.getCourses();
        try {
            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String description = result.getString(3);
                int duration = result.getInt(4);
                double fee = result.getInt(5);
                String instructor = result.getString(6);
                int enrolled = result.getInt(7);
                boolean subinstructors = result.getBoolean(8);
                
                Course course;
                if(fee == 0)
                    course = new BasicCourse(id, name, description, duration, instructor);
                else course = new PremiumCourse(id, name, description, duration, instructor, fee);
                courses.add(course);
            }
        } catch (SQLException ex) { }
        return courses;
    }
    
    List<EnrolPair> enrolments(){
        return enrolBase.getAll();
    }
}