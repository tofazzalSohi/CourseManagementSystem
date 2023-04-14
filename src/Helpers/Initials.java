package Helpers;

import ContextSingleton.Context;
import Courses.Course;
import DB.EnrolPair;
import Users.User;
import java.util.List;

public class Initials {
    
    public static boolean initialComplete = false;
    public static int positionX = - 1, positionY = -1;
    
    public static void setup() {
//        Output.print = true;
        
        // Contexts
        Context userContext = Context.getUserContext();
        Context courseContext = Context.getCourseContext();
        
        // To load everything from database
        LoadData load = new LoadData();
        
        // Load all teachers from the database
        List<User> teachers = load.teachers();
        // Load all students from the database
        List<User> students = load.students();
        
        // Get all courses from the database
        List<Course> courses = load.courses();
        
        for(Course course: courses){
            String instructor = course.getInstructor();
            Object tcr = userContext.get(instructor);
            if(tcr == null) continue;
            User teacher = (User) userContext.get(instructor);
            teacher.addCourse(course);
        }
        
        // Add all enrolments
        List<EnrolPair> enrolments = load.enrolments();
        for(EnrolPair ep: enrolments){
            
            // Extracting enrolment information
            User student = (User) userContext.get(ep.studentId);
            Course course = (Course) courseContext.get(ep.courseId);
            boolean paid = ep.payment;
            if(course == null) continue;
            // Marging enrolment and student
            if(course.getCourseFee() > 0 && paid){
                course.setCourseFee(-course.getCourseFee());
            }
            student.addCourse(course);
            course.setCourseFee(Math.abs(course.getCourseFee()));
            
            // Marging enrolment and course
            if(course.getCourseFee() == 0 || paid) {
                course.addEnrolled();
            }
        }
        
        
        
//        System.out.println(teachers);
        
        
        /////////////////////////////////////////////////
        initialComplete = true;
    }
}
