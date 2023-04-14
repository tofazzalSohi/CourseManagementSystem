package Courses;

public class Course {
    public int id;
    private String courseName;
    private String courseDescription;
    private int courseDuration;
    private double courseFee;
    private String instructor;
    private int enrolledBy = 0;
    private boolean subInstructors = true;

    public Course(int id, String name, String description, String instructor, int duration, double fee, boolean subInstructors) {
        this.id = id;
        this.courseName = name;
        this.courseDescription = description;
        this.courseDuration = duration;
        this.courseFee = fee;
        this.instructor = instructor;
        this.subInstructors = subInstructors; 
    }
    
    public int getId(){
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public void setCourseDescription(String description) {
        this.courseDescription = description;
    }

    public void setCourseDuration(int duration) {
        this.courseDuration = duration;
    }

    public void setCourseFee(double fee) {
        this.courseFee = fee;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructorName) {
        this.instructor = instructorName;
    }

    public boolean getSubInstructors() {
        return this.subInstructors;
    }

    public void setSubInstructors(boolean subInstructors) {
        this.subInstructors = subInstructors;
    }
    
    public void addEnrolled(){
        enrolledBy++;
    }
    
    public int getEnrolled(){
        return enrolledBy;
    }

    @Override
    public String toString() {
        return "Course Id: ".toUpperCase() + id + "\n"+
                " - Course Name: " + courseName + "\n"
                + " - Description: " + courseDescription + "\n"
                + " - Duration: " + courseDuration + " hours\n"
                + " - Instructor: " + instructor+"\n"
                + " - Fee: " + courseFee+"\n"
                + " - Enrolled by: " + enrolledBy+"\n"
                + " - Sub Instructors \n" + getSubInstructors();
    }
}
