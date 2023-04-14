package UI;

import ContextSingleton.Context;
import Helpers.Initials;
import Helpers.Output;
import Users.User;
import UsersFactory.UserFactory;
import UsersFactory.UserType;
import java.awt.Color;
import javax.swing.JOptionPane;


public class SignUp extends javax.swing.JFrame {

    private UserType type;
    private Context userContext = Context.getUserContext();
    
    public SignUp(UserType type) {
        this.type = type;
        initComponents();
        setTitle("Course management system (Sign up)");
        if(Initials.positionX != -1 && Initials.positionY != -1){
            setLocation(Initials.positionX, Initials.positionY);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signupbtn = new javax.swing.JButton();
        gbcl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cpassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        signupbtn.setBackground(new java.awt.Color(255, 102, 0));
        signupbtn.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        signupbtn.setText("Sign up");
        signupbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        signupbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupbtnMouseExited(evt);
            }
        });
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });

        gbcl.setFont(new java.awt.Font("SimSun", 1, 20)); // NOI18N
        gbcl.setForeground(new java.awt.Color(51, 51, 51));
        gbcl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gbcl.setText("<< Go back to login page");
        gbcl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gbcl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gbclMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gbclMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gbclMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/avatar.png"))); // NOI18N

        name.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 1, true));
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameMouseExited(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });

        email.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 1, true));
        email.addMouseListener(new java.awt.event.MouseAdapter() {
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
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 1, true));
        password.addMouseListener(new java.awt.event.MouseAdapter() {
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 51));
        jLabel2.setText("Full name");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("Email address");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 51));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("Confirm password");

        cpassword.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        cpassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 1, true));
        cpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cpasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cpasswordMouseExited(evt);
            }
        });
        cpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpasswordKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Join as a teacher to teach and earn | Join as a student to take courses and learn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(280, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(gbcl, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(365, 365, 365))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(414, 414, 414))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(gbcl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gbclMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gbclMouseClicked
        new Login().setVisible(true);
    }//GEN-LAST:event_gbclMouseClicked

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        String userName = name.getText();
        String userPass = password.getText();
        String userMail = email.getText();
        if(!userPass.equals(cpassword.getText())){
            JOptionPane.showMessageDialog(this, "Passwords doesn't match!");
            return;
        }
        User user = UserFactory.createUser(userName, userMail, userPass, type);
        boolean added = userContext.add(user);
        if (added) {
            JOptionPane.showMessageDialog(this, "Account created. Login to access your account.");
            new Login().setVisible(true);
            this.setVisible(false);
        } 
        else {
            JOptionPane.showMessageDialog(this, "User with email may already exists! Try again.");
        }
    }//GEN-LAST:event_signupbtnActionPerformed

    private void gbclMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gbclMouseEntered
        gbcl.setForeground(Color.decode("#FF6600"));
    }//GEN-LAST:event_gbclMouseEntered

    private void gbclMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gbclMouseExited
        gbcl.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_gbclMouseExited

    private void nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseEntered
        name.setBackground(Color.decode("#E2F2FF"));
    }//GEN-LAST:event_nameMouseEntered

    private void nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseExited
        name.setBackground(Color.decode("#FFFFFF"));
    }//GEN-LAST:event_nameMouseExited

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        name.setForeground(Color.decode("#ff6600"));
    }//GEN-LAST:event_nameKeyPressed

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        name.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_nameKeyReleased

    private void emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseEntered
        email.setBackground(Color.decode("#E2F2FF"));
    }//GEN-LAST:event_emailMouseEntered

    private void emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseExited
        email.setBackground(Color.decode("#ffffff"));
    }//GEN-LAST:event_emailMouseExited

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        email.setForeground(Color.decode("#ff6600"));
    }//GEN-LAST:event_emailKeyPressed

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        email.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_emailKeyReleased

    private void passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseEntered
        password.setBackground(Color.decode("#E2F2FF"));
    }//GEN-LAST:event_passwordMouseEntered

    private void passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseExited
        password.setBackground(Color.decode("#ffffff"));
    }//GEN-LAST:event_passwordMouseExited

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        password.setForeground(Color.decode("#ff6600"));
    }//GEN-LAST:event_passwordKeyPressed

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased
        password.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_passwordKeyReleased

    private void signupbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupbtnMouseEntered
        signupbtn.setBackground(Color.decode("#EE4400"));
        signupbtn.setForeground(Color.decode("#ffffff"));
    }//GEN-LAST:event_signupbtnMouseEntered

    private void signupbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupbtnMouseExited
        signupbtn.setBackground(Color.decode("#FF6600"));
        signupbtn.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_signupbtnMouseExited

    private void cpasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpasswordMouseEntered
        cpassword.setBackground(Color.decode("#E2F2FF"));
    }//GEN-LAST:event_cpasswordMouseEntered

    private void cpasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpasswordMouseExited
        cpassword.setBackground(Color.decode("#ffffff"));
    }//GEN-LAST:event_cpasswordMouseExited

    private void cpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpasswordKeyPressed
        cpassword.setForeground(Color.decode("#ff6600"));
    }//GEN-LAST:event_cpasswordKeyPressed

    private void cpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpasswordKeyReleased
        cpassword.setForeground(Color.decode("#333333"));
    }//GEN-LAST:event_cpasswordKeyReleased

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        Initials.positionX = this.getX();
        Initials.positionY = this.getY();
    }//GEN-LAST:event_formComponentMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpassword;
    private javax.swing.JTextField email;
    private javax.swing.JLabel gbcl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JButton signupbtn;
    // End of variables declaration//GEN-END:variables
}
