import Helpers.*;
import Users.User;
import java.util.Scanner;
import ContextSingleton.Context;
import Courses.BasicCourse;
import Courses.Course;
import Courses.PremiumCourse;
import UsersFactory.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Context userContext = Context.getUserContext();
    static Context courseContext = Context.getCourseContext();

    public static void main(String[] args) {
        
    }

    static void login() {
        System.out.println("\nLOGIN TO YOUR ACCOUNT");
        User user = null;
        while (user == null) {
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Password: ");
            String password = sc.next();

            for (Object obj : userContext.getAll()) {
                User usr = (User) obj;
                if (usr.getEmail().equals(email) && usr.getPassword().equals(password)) {
                    user = usr;
                    break;
                }
            }
            if (user == null) {
                System.out.println("Incorrect email or password, Try again.");
            }
        }
        System.out.println("WELCOME " + user.getName() + "!");
        functions(user);
    }

    static void functions(User user) {
        System.out.println("1. See My Courses");
        System.out.println("2. Add course");
        System.out.println("3. Drop course");
        System.out.println("4. See payment");
        if (user.getUserType() == UserType.Student) {
            System.out.println("5. Pay");
        }
        System.out.println("0. Exit");
        int choice = input(0, user.getUserType() == UserType.Student ? 5 : 4);
        if (choice == 0) {
            return;
        } 
        else if (choice == 1) {
            Output.show("List of all your courses", user.getCourses());
        } 
        else if (choice == 2) {
            Course course = getCourse(user);
            user.addCourse(course);
        }
        else if(choice == 3){
            drop(user);
        }
        else if(choice == 4){
            Output.show("Payments ", user.seePayments());
        }
        else if(choice == 5){
            pay(user);
        }

        functions(user);
    }
    
    static void drop(User user){
        Output.show("List of your courses", user.getCourses());
        System.out.println("\nENTER ANY COURSE ID FROM ABOVE TO DROP IT");
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        boolean removed = user.dropCourse(id);
        if(removed) System.out.println("\nCOURSE DROPPED!\n");
        else System.out.println("\nINVALID ID!\n");
    }
    
    static void pay(User user){
        Output.show("Pending payments ", user.seePayments());
        System.out.print("Enter amount to pay: ");
        double amount = sc.nextDouble();
        boolean paid = user.payment(amount);
        if(paid) System.out.println("\nPAYMENT COMPLETE!\nCOURSES ARE ENROLLED.\n");
        else System.out.println("\nNOT ENOUGH AMOUNT PAYED!\n");
    }

    static Course getCourse(User user) {
        if (user.getUserType() == UserType.Student) {
            List<Object> courses = courseContext.getAll();
            for (Object o : courses) {
                Course course = (Course) o;
                if (!user.getCourses().contains(course.toString())) {
                    Output.show("COURSE ID " + course.getId(), course.toString());
                }
            }
            Output.show("Select a course", "Select anyone from above courses");
            int id = -1;
            while (id == -1) {
                id = input(0, courses.size());
                if (user.getCourses().contains(courseContext.get(id).toString())) {
                    System.out.println("Course is already taken. Choose another one!");
                    id = -1;
                }
            }
            return (Course) courses.get(id);
        } else {
            Scanner sc = new Scanner(System.in);
            String name = null, des = null, ins = "";
            int dur = 0;
            double fee = 0;
            List<String> subins = new ArrayList<>();
            while (name == null || name.length() < 5) {
                System.out.print("Course name: ");
                name = sc.nextLine();
            }
            while (des == null || des.length() < 10) {
                System.out.print("Description: ");
                des = sc.nextLine();
            }
            while (dur == 0) {
                System.out.print("Duration(Hours): ");
                dur = sc.nextInt();
            }
            System.out.print("Fee ($): ");
            fee = sc.nextDouble();
            if (fee > 0) {
                System.out.print("Enter number of instructors: ");
                int n = sc.nextInt();
                for (int i = 1; i <= n; i++) {
                    String s = null;
                    while (s == null || s.length() < 3) {
                        System.out.print("Sub-instructor " + i + " name: ");
                        s = sc.nextLine();
                    }
                    subins.add(s);
                }
            }
            if (fee == 0) {
                return new BasicCourse(0, name, des, dur, ins);
            } else {
                return new PremiumCourse(0, name, des, dur, ins, fee);
            }
        }
    }

    static void createUser(UserType type) {
        Scanner sc = new Scanner(System.in);
        String name = null, email = null, password = null;
        while (name == null || name.length() < 3) {
            System.out.print("Enter Name: ");
            name = sc.nextLine();
        }
        while (email == null || email.length() < 3) {
            System.out.print("Enter Email: ");
            email = sc.nextLine();
        }
        while (password == null || password.length() < 3) {
            System.out.print("Enter password: ");
            password = sc.nextLine();
        }
        User user = UserFactory.createUser(name, email, password, type);
        boolean added = userContext.add(user);
        if (added) {
            System.out.println("\nAccount created. Login to access your account.");
            login();
        } else {

            Output.show("All users", userContext.getAll());
            System.out.println("User with email may already exists! Try again.");
            createUser(type);
        }
    }

    static Scanner sc = new Scanner(System.in);

    static int input(int from, int to) {
        int in = from - 1;
        System.out.print("Enter your choice (" + from + " to " + to + "): ");
        in = sc.nextInt();
        while (in < from || in > to) {
            System.out.print("Invalid input! Enter another (" + from + " to " + to + "): ");
            in = sc.nextInt();
        }
        return in;
    }
}
