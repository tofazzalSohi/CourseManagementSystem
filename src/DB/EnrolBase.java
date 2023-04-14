package DB;
import Courses.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EnrolBase {
    
    String url = "jdbc:mysql://localhost:3306/ocms";
    String username = "root";
    String password = "1234";
    Connection con;
    Statement stmt;
    String sql;
    
    private boolean setup(){
        if(con == null || stmt == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
                stmt = con.createStatement();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    
    public boolean add(int courseId, int studId, boolean payment){
        setup();
        sql = "INSERT INTO `ocms`.`enrolment`\n" +
                "(\n" +
                "	`course_id`,\n" +
                "	`user_id`,\n" +
                "	`payment`\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "	"+courseId+",\n" +
                "	"+studId+",\n" +
                "	"+payment+"\n" +
                ");";
        try{
            int result = stmt.executeUpdate(sql);
            return result == 1 ? true : false;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean remove(int courseId, int studentId){
        setup();
        sql = "DELETE FROM `ocms`.`enrolment`\n" +
              "WHERE course_id="+courseId+" AND user_id="+studentId+";";
        try{
            int result = stmt.executeUpdate(sql);
            return result >= 1 ? true : false;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public List<EnrolPair> getAll(){
        setup();
        sql = "SELECT * FROM `ocms`.`enrolment`";
        List<EnrolPair> list = new ArrayList<>();
        try{
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                int courseId = result.getInt(2);
                int studentId = result.getInt(3);
                boolean payment = result.getBoolean(4);
                list.add(new EnrolPair(studentId, courseId, payment));
            }
            return list;
        }
        catch(Exception e){
            return null;
        }
    }
}
