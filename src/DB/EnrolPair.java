package DB;
public class EnrolPair {
    public int studentId, courseId;
    public boolean payment;
    public EnrolPair(int studentId, int courseId, boolean payment){
        this.studentId = studentId;
        this.courseId = courseId;
        this.payment = payment;
    }
    @Override
    public String toString(){
        return studentId+" -> "+courseId+" @"+(payment ? "paid" : "unpaid");
    }
}
