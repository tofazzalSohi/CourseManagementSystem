package UI;

import ContextSingleton.Context;
import Helpers.Initials;
import Users.User;
import UsersFactory.UserType;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    private Context userContext = Context.getUserContext();

    public Login() {
        initComponents();
        setTitle("Course management system (Sign in)");
        if(!Initials.initialComplete)
            Initials.setup();
        if(Initials.positionX != -1 && Initials.positionY != -1){
            setLocation(Initials.positionX, Initials.positionY);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jsbtn = new javax.swing.JLabel();
        jtbtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        email.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        email.setForeground(new java.awt.Color(102, 102, 102));
        email.setText("Email address");
        email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 1, true));
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emailMouseExited(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
        });

        password.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(102, 102, 102));
        password.setText("Password");
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true));
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passwordMouseExited(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        loginBtn.setBackground(new java.awt.Color(255, 102, 0));
        loginBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(51, 51, 51));
        loginBtn.setText("Login");
        loginBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnMouseExited(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Don't have an account? ");

        jsbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jsbtn.setForeground(new java.awt.Color(51, 51, 51));
        jsbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jsbtn.setText("Join as a student");
        jsbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jsbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jsbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jsbtnMouseExited(evt);
            }
        });

        jtbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtbtn.setForeground(new java.awt.Color(51, 51, 51));
        jtbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtbtn.setText("Join as a teacher");
        jtbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jtbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtbtnMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/avatar.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 172, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(381, 381, 381))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(482, 482, 482))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(359, 359, 359))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(443, 443, 443))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String mail = email.getText();
        String pass = password.getText();
        
        Object obj = userContext.get(mail);
        if(obj == null) {
            JOptionPane.showMessageDialog(this, "Email doesn't exist.");
            return;
        }
        User user = (User) obj;
        if(!user.getPassword().equals(pass)){
            JOptionPane.showMessageDialog(this, "Wrong password!");
            return;
        }
        JOptionPane.showMessageDialog(this, "Login successfull.");
        if(user.getUserType() == UserType.Teacher)
            new TeacherHome(user);
        else new StudentHome(user);
        this.setVisible(false);
    }//GEN-LAST:event_loginBtnActionPerformed

    private void jsbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsbtnMouseClicked
        new SignUp(UserType.Student).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jsbtnMouseClicked

    private void jtbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtnMouseClicked
        new SignUp(UserType.Teacher).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jtbtnMouseClicked

    private void loginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseEntered
        loginBtn.setBackground(Color.decode("#EE4400"));
        loginBtn.setForeground(Color.decode("#ffffff"));
    }//GEN-LAST:event_loginBtnMouseEntered

    private void loginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseExited
        loginBtn.setBackground(Color.decode("#FF6600"));
        loginBtn.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_loginBtnMouseExited

    private void jsbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsbtnMouseEntered
        jsbtn.setForeground(Color.decode("#FF6600"));
    }//GEN-LAST:event_jsbtnMouseEntered

    private void jsbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsbtnMouseExited
        jsbtn.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_jsbtnMouseExited

    private void jtbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtnMouseEntered
        jtbtn.setForeground(Color.decode("#FF6600"));
    }//GEN-LAST:event_jtbtnMouseEntered

    private void jtbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtnMouseExited
        jtbtn.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_jtbtnMouseExited

    private void emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseEntered
        email.setBackground(Color.decode("#E2F2FF"));
    }//GEN-LAST:event_emailMouseEntered

    private void emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseExited
        email.setBackground(Color.decode("#FFFFFF"));
    }//GEN-LAST:event_emailMouseExited

    private void passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseEntered
        password.setBackground(Color.decode("#E2F2FF"));
    }//GEN-LAST:event_passwordMouseEntered

    private void passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseExited
        password.setBackground(Color.decode("#FFFFFF"));
    }//GEN-LAST:event_passwordMouseExited

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        email.setForeground(Color.decode("#ff6600"));
        if(emailEdit){
            emailEdit = false;
            email.setText("");
            email.setForeground(Color.decode("#333333"));
        }
    }//GEN-LAST:event_emailKeyPressed

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        email.setForeground(Color.decode("#333333"));
        
    }//GEN-LAST:event_emailKeyReleased

    boolean emailEdit = true;
    private void emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseClicked
        
    }//GEN-LAST:event_emailMouseClicked

    boolean passEdit = true;
    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        
    }//GEN-LAST:event_passwordMouseClicked

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if(passEdit){
            passEdit = false;
            password.setText("");
            password.setForeground(Color.decode("#333333"));
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        Initials.positionX = this.getX();
        Initials.positionY = this.getY();
    }//GEN-LAST:event_formComponentMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jsbtn;
    private javax.swing.JLabel jtbtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField password;
    // End of variables declaration//GEN-END:variables
}
