package UI;

import ContextSingleton.Context;
import Courses.BasicCourse;
import Courses.Course;
import Courses.PremiumCourse;
import Helpers.Initials;
import Users.User;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

public class TeacherHome extends javax.swing.JFrame {

    private User user;
    private Context courseContext = Context.getCourseContext();
    private Course courseToUpdate;
    
    public TeacherHome(User user) {
        this.user = user;
        initComponents();
        username.setText(user.getName());
        if(Initials.positionX != -1 && Initials.positionY != -1){
            setLocation(Initials.positionX, Initials.positionY);
        }
        this.setVisible(true);
        loadCourses();
        loadPayment();
        updateCourses();
    }
    
    private void updateCourses(){
        updateCourseTitle.setText("<html><h2>Update and existing course</h2></html>");
        coursesList.removeAllItems();
        coursesList.addItem("Select a course");
        for(Course course: user.getCourses()){
            coursesList.addItem(course.getId() +". "+course.getCourseName());
        }
    }
    
    private void loadPayment(){
        paymentTitle.setText("<html><h2>Earnings from all of "+user.getName()+"'s courses</h2></html>");
        addCourseTitle.setText("<html><h2>Add a new course</h2></html>");
        List<Course> courses = user.getCourses();
        
        String html = "<html><body>"+
                    "<table border=1 width=400px>\n" +
                    "	<tbody>\n" +
                    "		<tr>\n" +
                    "			<th>Course Name</th>\n" +
                    "			<th>Fee (£)</th>\n" +
                    "			<th>Enrolled By</th>\n" +
                    "			<th>Total earned</th>\n" +
                    "		</tr>\n";
        for(Course course: courses){
            html += "		<tr>\n" +
                    "			<td>" + course.getCourseName() + "</td>\n" +
                    "			<td>" + course.getCourseFee() + "</td>\n" +
                    "			<td>" + course.getEnrolled()+ "</td>\n" +
                    "			<td>" + (course.getEnrolled() * course.getCourseFee()) + "</td>\n" +
                    "		</tr>\n";
        }
        html += "</body></html>";
        paymentDisplay.setText(html);
    }
    
    private void loadCourses(){
        myCoursesTitle.setText("<html><h2>All courses conducted by "+user.getName()+"</h2></html>");
        
        List<Course> courses = user.getCourses();
        String html = "<html><body><ul>";
        for(Course course: courses){
            html += "<table border=1 width=400px>\n" +
                    "	<tbody>\n" +
                    "		<tr>\n" +
                    "			<th colspan=\"2\">"+course.getCourseName()+"</th>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td align=\"center\" colspan=\"2\">"+course.getCourseDescription()+"</td>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td>Course ID </td>\n" +
                    "			<td>" + course.getId() + "</td>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td>Total duration (Hour) </td>\n" +
                    "			<td>" + course.getCourseDuration() + "</td>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td>Course fee</td>\n" +
                    "			<td>" + course.getCourseFee() + "</td>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td>Total enrolled </td>\n" +
                    "			<td>" + course.getEnrolled() + "</td>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td>Sub instructors: </td>\n" +
                    "			<td>" + (course.getSubInstructors() ? "Yes" : "No") + "</td>\n" +
                    "		</tr>\n" +
                    "	</tbody>\n" +
                    "</table><br/><br/>";
        }
        html += "</body></html>";
        coursesDisplay.setText(html);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        myCoursesTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coursesDisplay = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addCourseTitle = new javax.swing.JLabel();
        addCname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addCduration = new javax.swing.JTextField();
        addCfee = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        addCdescription = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        updateCourseTitle = new javax.swing.JLabel();
        updateName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        updateDuration = new javax.swing.JTextField();
        updateFee = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        updateDes = new javax.swing.JTextArea();
        coursesList = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        paymentTitle = new javax.swing.JLabel();
        paymentDisplay = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        payment = new javax.swing.JLabel();
        drop = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        courses = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        username = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });
        tabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabsMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        myCoursesTitle.setText("All courses conducted by");

        coursesDisplay.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        coursesDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(coursesDisplay);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addComponent(myCoursesTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myCoursesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("My courses", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        addCourseTitle.setText("Add a new Course");

        addCname.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Course name");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Description of the course");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Duration in Hours");

        addCduration.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        addCfee.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Enrolment fee (£)");

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Add Course");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addCdescription.setColumns(20);
        addCdescription.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        addCdescription.setRows(5);
        jScrollPane2.setViewportView(addCdescription);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCfee, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addCname, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(addCduration, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)))))
                        .addGap(78, 78, 78))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(229, 229, 229))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(addCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addCname, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addCduration, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addCfee, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        tabs.addTab("Add course", jPanel3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        updateCourseTitle.setText("Add a new Course");

        updateName.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Course name");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Description of the course");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Duration in Hours");

        updateDuration.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        updateFee.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Enrolment fee (£)");

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Update course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        updateDes.setColumns(20);
        updateDes.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        updateDes.setRows(5);
        jScrollPane3.setViewportView(updateDes);

        coursesList.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        coursesList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                coursesListItemStateChanged(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setText("Delete course");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateFee, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(updateName, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane3)
                                                .addComponent(updateDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(updateCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coursesList, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(78, 78, 78))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(updateCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(coursesList, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateFee, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabs.addTab("Update course", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        paymentTitle.setText("All courses conducted by");

        paymentDisplay.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        paymentDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paymentDisplay.setText("asdfsdf");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paymentDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(paymentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paymentDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tabs.addTab("Payment", jPanel5);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        payment.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        payment.setText("Payment");
        payment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentMouseClicked(evt);
            }
        });

        drop.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        drop.setText("Update or drop course");
        drop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        drop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropMouseClicked(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add.setText("Add course");
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        courses.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        courses.setText("My courses");
        courses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        courses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coursesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courses, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drop)
                            .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(jSeparator4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(courses, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(drop)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username.setText("Full name of user");

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Logout");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabs)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void markLeft(javax.swing.JLabel clicked){
        javax.swing.JLabel label1 = courses;
        javax.swing.JLabel label2 = add;
        javax.swing.JLabel label3 = drop;
        javax.swing.JLabel label4 = payment;
        label1.setForeground(Color.decode("#333333"));
        label2.setForeground(Color.decode("#333333"));
        label3.setForeground(Color.decode("#333333"));
        label4.setForeground(Color.decode("#333333"));
        clicked.setForeground(Color.decode("#ffffff"));
    }
    
    private void coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursesMouseClicked
        tabs.setSelectedIndex(0);
        loadCourses();
        markLeft(courses);
    }//GEN-LAST:event_coursesMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        tabs.setSelectedIndex(1);
        markLeft(add);
    }//GEN-LAST:event_addMouseClicked

    private void dropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dropMouseClicked
        tabs.setSelectedIndex(2);
        markLeft(drop);
    }//GEN-LAST:event_dropMouseClicked

    private void paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseClicked
        loadPayment();
        tabs.setSelectedIndex(3);
        markLeft(payment);
    }//GEN-LAST:event_paymentMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = addCname.getText();
        if(name.length() < 6) {
            JOptionPane.showMessageDialog(this, "Name is too short (At least 6 letters.)");
            return;
        }
        try{
            int x = Integer.parseInt(name);
            JOptionPane.showMessageDialog(this, "Invalid course name.");
            return;
        }
        catch(Exception e){}
        for(Course c: user.getCourses()){
            if(c.getCourseName().equals(name)){
                JOptionPane.showMessageDialog(this, "A course with the same name already exists.");
                return;
            }
        }
        
        String description = addCdescription.getText();
        if(description.length() < 10) {
            JOptionPane.showMessageDialog(this, "Description is too short (At least 10 letters.)");
            return;
        }
        try{
            int x = Integer.parseInt(description);
            JOptionPane.showMessageDialog(this, "Invalid description.");
            return;
        }
        catch(Exception e){}
        
        int duration;
        try{
            duration = Integer.parseInt(addCduration.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Invalid duration.");
            return;
        }
        if(duration < 1 || duration > 1000){
            JOptionPane.showMessageDialog(this, "Duration is out of range (1-1000)");
            return;
        }
        
        double fee;
        try{
            fee = Double.parseDouble("0"+addCfee.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Invalid fee.");
            return;
        }
        
        Course course;
        
        if(fee == 0) {
            course = new BasicCourse(courseContext.getNewId(), name, description, duration, user.getEmail());
        }
        else {
            course = new PremiumCourse(courseContext.getNewId(), name, description, duration, user.getEmail(), fee);
        }
        
        if(user.addCourse(course)){
            addCname.setText("");
            addCdescription.setText("");
            addCduration.setText("");
            addCfee.setText("");
            JOptionPane.showMessageDialog(this, "Course addition succesfull!");
        }
        else {
            JOptionPane.showMessageDialog(this, "Failed to add a new course, possible reason: database error.");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked
        loadCourses();
        loadPayment();
        updateCourses();
    }//GEN-LAST:event_tabsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String name = updateName.getText();
        if(name.length() < 6) {
            JOptionPane.showMessageDialog(this, "Name is too short (At least 6 letters.)");
            return;
        }
        try{
            int x = Integer.parseInt(name);
            JOptionPane.showMessageDialog(this, "Invalid course name.");
            return;
        }
        catch(Exception e){}
        
        String description = updateDes.getText();
        if(description.length() < 10) {
            JOptionPane.showMessageDialog(this, "Description is too short (At least 10 letters.)");
            return;
        }
        try{
            int x = Integer.parseInt(description);
            JOptionPane.showMessageDialog(this, "Invalid description.");
            return;
        }
        catch(Exception e){}
        
        int duration;
        try{
            duration = Integer.parseInt(updateDuration.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Invalid duration.");
            return;
        }
        if(duration < 1 || duration > 1000){
            JOptionPane.showMessageDialog(this, "Duration is out of range (1-1000)");
            return;
        }
        
        double fee;
        try{
            fee = Double.parseDouble("0"+updateFee.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Invalid fee.");
            return;
        }
        
        Course course;
        
        if(fee == 0) {
            course = new BasicCourse(courseContext.getNewId(), name, description, duration, user.getEmail());
        }
        else {
            course = new PremiumCourse(courseContext.getNewId(), name, description, duration, user.getEmail(), fee);
        }
        if(user.dropCourse(courseToUpdate.getId()) && user.addCourse(course)){
            JOptionPane.showMessageDialog(this, "Course updated succesfully!");
        }
        else {
            JOptionPane.showMessageDialog(this, "Failed to update the course, possible reason: database error.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void coursesListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_coursesListItemStateChanged
        String selected = String.valueOf(coursesList.getSelectedItem());
        try{
            int id = Integer.parseInt(selected.substring(0, selected.indexOf(".")));
            courseToUpdate = (Course) courseContext.get(id);
            updateName.setText(courseToUpdate.getCourseName());
            updateDes.setText(courseToUpdate.getCourseDescription());
            updateDuration.setText(courseToUpdate.getCourseDuration()+"");
            updateFee.setText(courseToUpdate.getCourseFee()+"");
        }
        catch(Exception nfe){
            courseToUpdate = null;
            updateName.setText("");
            updateDes.setText("");
            updateDuration.setText("");
            updateFee.setText("");
        }
    }//GEN-LAST:event_coursesListItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(courseToUpdate == null) {
            JOptionPane.showMessageDialog(this, "You didn't select any course.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the course '"+courseToUpdate.getCourseName()+"'?", "Delete course confirmation", 0);
        if(confirm != 0){
            return;
        }
        if(user.dropCourse(courseToUpdate.getId())){
            JOptionPane.showMessageDialog(this, "Course deleted!");
            loadCourses();
            updateCourses();
            courseToUpdate = null;
            updateName.setText("");
            updateDes.setText("");
            updateDuration.setText("");
            updateFee.setText("");
            tabs.setSelectedIndex(1);
        }
        else{
            JOptionPane.showMessageDialog(this, "Failed to delete. Possible reason: Database error.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged
        switch(tabs.getSelectedIndex()){
            case 0:
                markLeft(courses);
                break;
            case 1:
                markLeft(add);
                break;
            case 2:
                markLeft(drop);
                break;
            case 3:
                markLeft(payment);
                break;
        }
    }//GEN-LAST:event_tabsStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Login().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        Initials.positionX = this.getX();
        Initials.positionY = this.getY();
    }//GEN-LAST:event_formComponentMoved

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JTextArea addCdescription;
    private javax.swing.JTextField addCduration;
    private javax.swing.JTextField addCfee;
    private javax.swing.JTextField addCname;
    private javax.swing.JLabel addCourseTitle;
    private javax.swing.JLabel courses;
    private javax.swing.JLabel coursesDisplay;
    private javax.swing.JComboBox<String> coursesList;
    private javax.swing.JLabel drop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel myCoursesTitle;
    private javax.swing.JLabel payment;
    private javax.swing.JLabel paymentDisplay;
    private javax.swing.JLabel paymentTitle;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JLabel updateCourseTitle;
    private javax.swing.JTextArea updateDes;
    private javax.swing.JTextField updateDuration;
    private javax.swing.JTextField updateFee;
    private javax.swing.JTextField updateName;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
