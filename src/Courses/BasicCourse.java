package Courses;

public class BasicCourse extends Course {
    public BasicCourse(int id, String name, String description, int duration, String instructor) {
        super(id, name, description, instructor, duration, 0, false);
    }
}