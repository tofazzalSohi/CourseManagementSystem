package DB;
import Users.User;
import UsersFactory.UserType;
import java.sql.*;
public class UserBase {
    
    String url = "jdbc:mysql://localhost:3306/ocms";
    String username = "root";
    String password = "1234";
    
    public boolean addUser(User user){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = addQuery(user);
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
    
    public ResultSet getUsers(int type){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM `ocms`.`users` WHERE `type`="+type;
            ResultSet result = stmt.executeQuery(sql);
            return result;
            
        }
        catch(Exception e){
            System.out.println("Error in database while reading users.");
            System.out.println(e);
            return null;
        }
    }
    
    
    private String addQuery(User user){
        int type;
        if(user.getUserType() == UserType.Student) type = 1;
        else type = 2;
        String cmd = "INSERT INTO `ocms`.`users`\n" +
                    "(`name`,\n" +
                    "`email`,\n" +
                    "`password`,\n" +
                    "`type`)\n" +
                    "VALUES(\n" + "'"+
                    user.getName()+"',\n'"+
                    user.getEmail()+"',\n'"+
                    user.getPassword()+"',\n"+
                    type+");";
        return cmd;
    }
}

/*
INSERT INTO `ocms`.`users`
(`name`,
`email`,
`password`,
`type`)
VALUES(
'Muhammad Feeham',
'mf@gmail.com',
'12345',
1);
*/