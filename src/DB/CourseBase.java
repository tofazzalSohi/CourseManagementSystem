package DB;
import Courses.Course;
import java.sql.*;
public class CourseBase {
    
    String url = "jdbc:mysql://localhost:3306/ocms";
    String username = "root";
    String password = "1234";
    
    public boolean addCourse(Course course){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = addQuery(course);
            int result = stmt.executeUpdate(sql);
            if(result == 1){
                return true;
            }
            else {
                return false;
            }
        }
        catch(SQLIntegrityConstraintViolationException e){
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public boolean deleteCourse(int id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM `ocms`.`courses` WHERE ID="+id;
            int result = stmt.executeUpdate(sql);
            return result == 1 ? true : false;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public ResultSet getCourses(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM `ocms`.`courses`";
            ResultSet result = stmt.executeQuery(sql);
            return result;
        }
        catch(Exception e){
            System.out.println("Error while accessing database");
            return null;
        }
    }
    
    
    private String addQuery(Course course){
        String cmd = "INSERT INTO `ocms`.`courses`\n" +
"    (\n" +
"        `id`, \n" +
"        `name`,\n" +
"        `description`,\n" +
"        `duration`,\n" +
"        `fee`,\n" +
"        `instructor`,\n" +
"        `subins`\n" +
"    )\n" +
"    VALUES(\n" +
"        '"+course.getId()+"',\n" +
"        '"+course.getCourseName()+"',\n" +
"        '"+course.getCourseDescription()+"',\n" +
"        "+course.getCourseDuration()+",\n" +
"        "+course.getCourseFee()+",\n" +
"        '"+course.getInstructor()+"',\n" +
"        "+course.getSubInstructors()+"\n" +
"    );";
        return cmd;
    }
    
    /*
    INSERT INTO `ocms`.`courses`
    (
        `name`,
        `description`,
        `duration`,
        `fee`,
        `instructor`,
        `subins`
    )
    VALUES(
        'Physis I',
        'Learn the fundamental physics',
        21,
        10.254,
        'Albert Einstein',
        true
    );

    */
}
