package Users;

import ContextSingleton.Context;
import UsersFactory.UserType;
import Courses.Course;
import DB.EnrolBase;
import Helpers.Initials;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private Context context;
    private EnrolBase enrol = new EnrolBase();

    private List<Course> enrolledCourses;
    private List<Course> wishlistedCourses;

    public Student(String name, String email, String password) {
        super(name, email, password, UserType.Student);
        enrolledCourses = new ArrayList<>();
        wishlistedCourses = new ArrayList<>();
        context = Context.getCourseContext();
    }

    @Override
    public boolean addCourse(Course course) {
        if(!Initials.initialComplete){
            if(course.getCourseFee() <= 0) {
                course.setCourseFee(Math.abs(course.getCourseFee()));
                enrolledCourses.add(course);
            }
            else{
                wishlistedCourses.add(course);
            }
            return true;
        }
        boolean payment = false;
        if(course.getCourseFee() == 0) {
            payment = true;
        }
        try{
            if(enrol.add(course.getId(), getId(), payment)){
                if(course.getCourseFee() <= 0)
                    enrolledCourses.add(course);
                else wishlistedCourses.add(course);
                return true;
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean payment(double cid) {
        int courseId = (int) cid;
        Course course = (Course) context.get(courseId);
        if(dropCourse(courseId) && enrol.add(courseId, getId(), true)){
            for(int i=0; i<enrolledCourses.size(); i++){
                if(enrolledCourses.get(i).getId() == courseId){
                    enrolledCourses.remove(i);
                }
            }
            for(int i=0; i<wishlistedCourses.size(); i++){
                if(wishlistedCourses.get(i).getId() == courseId){
                    wishlistedCourses.remove(i);
                }
            }
            course.addEnrolled();
            enrolledCourses.add(course);
            return true;
        }
        else return false;
    }

    @Override
    public boolean dropCourse(int id) {
        Course course = (Course) context.get(id);
        if (course == null) {
            return false;
        }
        boolean deleted = enrol.remove(id, getId());
        if(deleted){
            for(int i=0; i<enrolledCourses.size(); i++){
                if(enrolledCourses.get(i).getId() == id){
                    enrolledCourses.remove(i);
                }
            }
            for(int i=0; i<wishlistedCourses.size(); i++){
                if(wishlistedCourses.get(i).getId() == id){
                    wishlistedCourses.remove(i);
                }
            }
        }
        return deleted;
    }

    @Override
    public String seePayments() {
        String payments = "";
        for (Course course : wishlistedCourses) {
            payments += course.getCourseName() + " -> " + course.getCourseFee() + "\n";
        }
        return payments;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.addAll(enrolledCourses);
        courses.add(null);
        courses.addAll(wishlistedCourses);
        return courses;
    }
}
