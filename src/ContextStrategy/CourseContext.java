package ContextStrategy;

import Courses.Course;
import DB.CourseBase;
import Helpers.Initials;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseContext implements Strategy {

    private List<Object> courses = new ArrayList<>();
    private CourseBase courseBase = new CourseBase();
    
    @Override 
    public Object get(int id){
        for(Object o: courses){
            Course course = (Course) o;
            if(course.getId() == id) return course;
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        try {
            Course course = (Course) o;
            if(courses.contains(course)) return true;
            courses.add(course);
            if(Initials.initialComplete == false) {
                return true;
            }
            return courseBase.addCourse(course);
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            Course course = (Course) o;
            if(courseBase.deleteCourse(course.getId())){
                courses.remove(course);
                return true;
            }
            else return false;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public List<Object> getAll() {
        return courses;
    }

    @Override
    public Object get(String email) {
        return null;
    }

    @Override
    public int getNewId() {
        List<Object> list = getAll();
        Set<Integer> ids = new HashSet<>();
        for(Object o: list){
            Course course = (Course) o;
            ids.add(course.getId());
        }
        for(int i=1; i>0; i++){
            if(!ids.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
