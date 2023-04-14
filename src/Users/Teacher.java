package Users;

import ContextSingleton.Context;
import Courses.Course;
import Helpers.Initials;
import UsersFactory.UserType;
import Helpers.Output;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {

    Context context;

    public Teacher(String name, String email, String password) {
        super(name, email, password, UserType.Teacher);
        context = Context.getCourseContext();
    }
    
    @Override
    public boolean addCourse(Course course) {
        try {
            course.setInstructor(getEmail());
            if(!Initials.initialComplete) {
                return context.add(course);
            }
            
            course.id = context.getNewId();
            boolean added = context.add(course);
            if(added) {
                Output.show("New Course added", course);
                return true;
            }
            else return false;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean dropCourse(int id) {
        try {
            Course course = (Course) context.get(id);
            return context.remove(course);
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean payment(double balance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String seePayments() {
        double total = 0;
        String payments = "";
        for(Object o: context.getAll()){
            Course course = (Course) o;
            if(course.getInstructor().equals(getName())){
                payments += course.getCourseName() + " -> " + (course.getCourseFee() * course.getEnrolled() + "\n");
                total += course.getCourseFee() * course.getEnrolled();
            }
        }
        payments += "Total: "+total+"\n";
        return payments;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        for(Object o: context.getAll()){
            Course course = (Course) o;
            if(course.getInstructor().equals(getEmail())){
                courses.add(course);
            }
        }
        return courses;
    }
    
}
