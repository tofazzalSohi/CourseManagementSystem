package UI;

import ContextSingleton.Context;
import Courses.Course;
import Helpers.Initials;
import Users.User;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

public class StudentHome extends javax.swing.JFrame {

    private User user;
    private Context courseContext = Context.getCourseContext();
    private Context userContext = Context.getUserContext();
    
    public StudentHome(User user) {
        this.user = user;
        initComponents();
        username.setText(user.getName());
        setTitle("Course management system | "+user.getName());
        addCourseTitle.setText("<html><h2>Add a new course</h2></html>");
        if(Initials.positionX != -1 && Initials.positionY != -1){
            setLocation(Initials.positionX, Initials.positionY);
        }
        this.setVisible(true);
        loadCourses();
        loadPayment();
        enrolledCourses();
        removeCourse();
    }
    
    private void removeCourse(){
        removeCourseTitle.setText("<html><h2>Drop courses from your list</h2></html>");
        removeList.removeAllItems();
        removeList.addItem("Select a course");
        int i = 0;
        for(; i<user.getCourses().size(); i++){
            Course course = user.getCourses().get(i);
            if(course == null) {
                i++;
                break;
            }
            removeList.addItem(course.getId()+". "+course.getCourseName()+" (Enrolled)");
        }
        
        for(; i<user.getCourses().size(); i++){
            Course course = user.getCourses().get(i);
            removeList.addItem(course.getId()+". "+course.getCourseName()+" (Wishlisted)");
        }
        
    }
    
    private void loadPayment(){
        paymentTitle.setText("<html><h2>Wishlist (Pay to enroll courses)</h2></html>");
        List<Course> courses = user.getCourses();
        paymentOptions.removeAllItems();
        paymentOptions.addItem("Select a course");
        
        int i = 0; 
        for(i=0; i<courses.size(); i++){
            if(courses.get(i) == null) {
                i++;
                break;
            }
        }
        
        if(courses.size()-i <= 0){
            paymentDisplay.setText("<html><h2>You have no courses to pay!<br/>Add some courses first.</h2></html>");
            return;
        }
        
        String html = "<html><body>"+
                    "<table border=1 width=400px>\n" +
                    "	<tbody>\n" +
                    "		<tr>\n" +
                    "			<th>Course ID</th>\n" +
                    "			<th>Course name</th>\n" +
                    "			<th>Fee (£)</th>\n" +
                    "		</tr>\n";
        for( ; i<courses.size(); i++){
            Course course = courses.get(i);
            paymentOptions.addItem(course.getId()+". "+course.getCourseName());
            html += "		<tr>\n" +
                    "			<td>" + course.getId()+ "</td>\n" +
                    "			<td>" + course.getCourseName() + "</td>\n" +
                    "			<td>" + course.getCourseFee()+ "</td>\n" +
                    "		</tr>\n";
        }
        html += "</body></html>";
        paymentDisplay.setText(html);
    }
    
    private void enrolledCourses(){
        myCoursesTitle.setText("<html><h2>All courses enrolled by "+user.getName()+"</h2></html>");
        
        List<Course> courses = user.getCourses();
        int courseCount = 0;
        for(int i=0; i<courses.size(); i++){
            if(courses.get(i) == null) break;
            else courseCount++;
        }
        String html = "<html><body>";
        if(courseCount == 0){
            html += "<h2>You enrolled no courses yet! <br/>Add new course to see here.</h2><ul>";
        }
        for(Object o: courses){
            if(o == null) break;
            Course course = (Course) o;
            
            html += "<table border=1 width=400px>\n" +
                    "	<tbody>\n" +
                    "		<tr>\n" +
                    "			<th colspan=\"2\">"+course.getCourseName()+"</th>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td align=\"center\" colspan=\"2\">"+course.getCourseDescription()+"</td>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td>Conducted by </td>\n" +
                    "			<td>" + ((User)(userContext.get(course.getInstructor()))).getName() + "</td>\n" +
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
        enrolledCourses.setText(html);
    }
    
    private void loadCourses(){
        addCourseOptions.removeAllItems();
        addCourseOptions.addItem("Select a course to add");
        
        List<Object> courses = courseContext.getAll();
        String html = "<html><body>";
        if(courses.size() == 0){
            html += "<h2>There is no new course available for you</h2><ul>";
        }
        else {
            html += "<h2>Pick courses for you from all available courses shown below.</h2><ul>";
        }
        for(Object o: courses){
            Course course = (Course) o;
            if(user.getCourses().contains(course)){
                continue;
            }
            addCourseOptions.addItem(course.getId()+". "+course.getCourseName());
            
            html += "<table border=1 width=400px>\n" +
                    "	<tbody>\n" +
                    "		<tr>\n" +
                    "			<th colspan=\"2\">"+course.getCourseName()+"</th>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td align=\"center\" colspan=\"2\">"+course.getCourseDescription()+"</td>\n" +
                    "		</tr>\n" +
                    "		<tr>\n" +
                    "			<td>Conducted by </td>\n" +
                    "			<td>" + ((User)(userContext.get(course.getInstructor()))).getName() + "</td>\n" +
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
        availableCourses.setText(html);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        myCoursesTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enrolledCourses = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addCourseTitle = new javax.swing.JLabel();
        addCourseOptions = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableCourses = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        removeCourseTitle = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        removeList = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        paymentTitle = new javax.swing.JLabel();
        paymentOptions = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        paymentDisplay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        courses = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        drop = new javax.swing.JLabel();
        payment = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        username = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

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

        myCoursesTitle.setBackground(new java.awt.Color(250, 234, 228));
        myCoursesTitle.setText("All courses conducted by");

        jScrollPane1.setBackground(new java.awt.Color(250, 234, 228));
        jScrollPane1.setBorder(null);

        enrolledCourses.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        enrolledCourses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(enrolledCourses);

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

        addCourseTitle.setText("Enroll in a new course");

        addCourseOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Add course");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        availableCourses.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        availableCourses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane2.setViewportView(availableCourses);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addCourseOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(addCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(addCourseOptions))
                .addContainerGap())
        );

        tabs.addTab("Enroll in a new course", jPanel3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        removeCourseTitle.setText("Add a new Course");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Drop Course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        removeList.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        removeList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(removeCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(removeList, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(removeCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(removeList, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addGap(147, 147, 147))
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

        tabs.addTab("Remove existing course", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        paymentTitle.setText("All courses conducted by");

        paymentOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Pay");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        paymentDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane4.setViewportView(paymentDisplay);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(paymentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paymentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(paymentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paymentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        tabs.addTab("Wishlist & Payments", jPanel5);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        courses.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        courses.setForeground(new java.awt.Color(255, 255, 255));
        courses.setText("My courses");
        courses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        courses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coursesMouseClicked(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add.setText("Enroll in a new course");
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        drop.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        drop.setText("Remove existing course");
        drop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        drop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropMouseClicked(evt);
            }
        });

        payment.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        payment.setText("Wishlist & Payments");
        payment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(drop, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(courses, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator4)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(courses)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(drop, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(payment)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username.setText("Full name of user");

        jButton3.setBackground(new java.awt.Color(255, 153, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Logout");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tabs.setSelectedIndex(3);
        markLeft(payment);
    }//GEN-LAST:event_paymentMouseClicked

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked

    }//GEN-LAST:event_tabsMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            int selected = Integer.parseInt(String.valueOf(paymentOptions.getSelectedItem()).substring(0, String.valueOf(paymentOptions.getSelectedItem()).indexOf(".")));
            Course course = (Course) courseContext.get(selected);
            String input = JOptionPane.showInputDialog(this, "Pay "+course.getCourseFee()+" \nfor the course "+course.getCourseName());
            int paid = Integer.parseInt(input);
            if(paid >= course.getCourseFee()){
                boolean added = user.payment(course.getId());
                if(added){
                    JOptionPane.showMessageDialog(this, "Payment complete!\nCourse is added to enrolled list.\nHappy learning.");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Failed to add course. Reason: Database error.");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Insufficient payment");
            }
            course.setCourseFee(Math.abs(course.getCourseFee()));
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Failed to pay for the course.");
        }
        loadCourses();
        loadPayment();
        enrolledCourses();
        removeCourse();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String selText = String.valueOf(removeList.getSelectedItem());
        if(selText.startsWith("S")) {
            JOptionPane.showMessageDialog(this, "Select a course from the drop down list first");
            return;
        }
        int courseId = Integer.parseInt(selText.substring(0, selText.indexOf(".")));
        Course course = (Course) courseContext.get(courseId);
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to drop the course\n"+course.getId()+"?", "Delete course", 0);
        if(choice == 0){
            boolean done = user.dropCourse(courseId);
            if(done) {
                JOptionPane.showMessageDialog(this, "Course removed!");
            }
            else{
                JOptionPane.showMessageDialog(this, "Failed to remove course!");
            }
            loadCourses();
            loadPayment();
            enrolledCourses();
            removeCourse();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String selected = String.valueOf(addCourseOptions.getSelectedItem());
        int courseId;
        try{
            courseId = Integer.parseInt(selected.substring(0, selected.indexOf(".")));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Select a course first");
            return;
        }
        Course course = (Course) courseContext.get(courseId);
        boolean added = user.addCourse(course);
        if(added){
            if(course.getCourseFee() > 0)
            JOptionPane.showMessageDialog(this, "Course '" +selected.substring(selected.indexOf(".")+1)+"' added to your wishlist. "
                + "\nGo to payment and pay for this course\nto start learning!");
            else JOptionPane.showMessageDialog(this, "Course '" +selected.substring(selected.indexOf(".")+1)+"' added to your enrolled course list. \nHappy learning!");
            loadCourses();
            loadPayment();
            enrolledCourses();
            removeCourse();
        }
        else{
            JOptionPane.showMessageDialog(this, "Failed to add course. \nPossible reason: database failure.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Login().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        Initials.positionX = this.getX();
        Initials.positionY = this.getY();
    }//GEN-LAST:event_formComponentMoved

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JComboBox<String> addCourseOptions;
    private javax.swing.JLabel addCourseTitle;
    private javax.swing.JLabel availableCourses;
    private javax.swing.JLabel courses;
    private javax.swing.JLabel drop;
    private javax.swing.JLabel enrolledCourses;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel myCoursesTitle;
    private javax.swing.JLabel payment;
    private javax.swing.JLabel paymentDisplay;
    private javax.swing.JComboBox<String> paymentOptions;
    private javax.swing.JLabel paymentTitle;
    private javax.swing.JLabel removeCourseTitle;
    private javax.swing.JComboBox<String> removeList;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
