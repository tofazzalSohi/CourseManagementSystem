package Courses;

public class PremiumCourse extends Course {
    public PremiumCourse(int id, String name, String description, int duration, String instructor, double fee) {
        super(id, name, description, instructor, duration, fee, true);
    }
}