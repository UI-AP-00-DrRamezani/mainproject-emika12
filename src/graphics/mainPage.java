package graphics;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import allof.exceptions.*;
import graphics.products.showAllProducts;
import graphics.user.signUp;
import project.first.project;

import javax.swing.*;
import java.awt.*;

public class mainPage extends javax.swing.JFrame {



    public mainPage() {
        initComponents();
        project.useraccount=null;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        top_picture = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        ID_label = new javax.swing.JLabel();
        passcodeLabel = new javax.swing.JLabel();
        ID_txtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        wrongInputTXT = new javax.swing.JLabel();
        pass_eye = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        saving = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("login /sign up");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 500));
        setType(java.awt.Window.Type.POPUP);

        top_picture.setIcon(new javax.swing.ImageIcon("C:\\Users\\ES\\Pictures\\project\\11.png")); // NOI18N
        top_picture.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        loginLabel.setForeground(new java.awt.Color(204, 204, 255));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("LOGIN");
        loginLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginLabel.setInheritsPopupMenu(false);

        ID_label.setForeground(new java.awt.Color(255, 153, 255));
        ID_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID_label.setText("ID");

        passcodeLabel.setForeground(new java.awt.Color(204, 153, 255));
        passcodeLabel.setText("Passcode");

        ID_txtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_txtFieldActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("    not having an account ? ");

        signUpButton.setBackground(new java.awt.Color(255, 153, 255));
        signUpButton.setFont(new java.awt.Font("Traditional Arabic", 0, 11)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(0, 204, 102));
        signUpButton.setText("sign up");
        signUpButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153)));
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(153, 153, 255));
        jButton1.setText("continue without  signing up ");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        wrongInputTXT.setForeground(new java.awt.Color(255, 102, 102));

        pass_eye.setIcon(new javax.swing.ImageIcon("C:\\Users\\ES\\Pictures\\project\\2.png")); // NOI18N
        pass_eye.setPreferredSize(new java.awt.Dimension(33, 9));
        pass_eye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_eyeActionPerformed(evt);
            }
        });

        jPasswordField.setBackground(new java.awt.Color(255, 102, 102));
        jPasswordField.setForeground(new java.awt.Color(51, 51, 255));
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        loginBtn.setForeground(new java.awt.Color(204, 0, 204));
        loginBtn.setText("login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        saving.setIcon(new javax.swing.ImageIcon("C:\\Users\\ES\\Pictures\\project\\6.png")); // NOI18N
        saving.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saving.setPreferredSize(new java.awt.Dimension(100, 27));
        saving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(270, 270, 270)
                                                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(wrongInputTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(92, 92, 92)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(30, 30, 30)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(passcodeLabel)
                                                                                .addComponent(ID_label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(saving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(ID_txtField, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                                                .addComponent(top_picture, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jPasswordField))
                                                        .addGap(28, 28, 28)
                                                        .addComponent(pass_eye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(140, 140, 140))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(loginBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(top_picture, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(saving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ID_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ID_label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passcodeLabel)
                                                        .addComponent(jPasswordField))
                                                .addGap(27, 27, 27)
                                                .addComponent(loginBtn)
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(69, 69, 69))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(57, 57, 57)
                                                .addComponent(wrongInputTXT))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(pass_eye, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        loginLabel.getAccessibleContext().setAccessibleName("LoginLabel");
        ID_label.getAccessibleContext().setAccessibleName("ID_label");
        passcodeLabel.getAccessibleContext().setAccessibleName("passcode_label");
        ID_txtField.getAccessibleContext().setAccessibleName("ID_txtField");
        signUpButton.getAccessibleContext().setAccessibleName("sign up ");


        setResizable(false);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);


        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                project.setNotifying(true);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        project.mySuspend();
                    }
                }).start();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
        });
    }// </editor-fold>
    // </editor-fold>

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                signUp signingPage=new signUp();
            }
        });
        this.dispose();
        //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showAllProducts s=new showAllProducts();
            }
        });


    }

    private void pass_eyeActionPerformed(java.awt.event.ActionEvent evt) {
        //for showing the password to the user
        jPasswordField.setEchoChar((char) 0);

    }

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {
        if (jPasswordField.getPassword().length >= 8)
            jPasswordField.setBackground(Color.GREEN);
    }

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            project.login(ID_txtField.getText() ,jPasswordField.getText());
            this.dispose();
        }catch (AccessAllowance allowance)
        {
            jLabel1.setText(allowance.toString());
        }
        catch (noUser e){
            jLabel1.setText(e.getMessage());
            jLabel1.setForeground(Color.pink);
        }catch (Exception e){
            jLabel1.setText(e.getMessage());
            jLabel1.setForeground(Color.pink);
        }

    }
    private void ID_txtFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void savingActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                saving Saving = new saving();
            }
        });
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                com.formdev.flatlaf.FlatDarculaLaf.setup();
                new mainPage().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel ID_label;
    private javax.swing.JTextField ID_txtField;
    private javax.swing.JButton jButton1;//product button
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JButton pass_eye;
    private javax.swing.JLabel passcodeLabel;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel top_picture;
    private javax.swing.JLabel wrongInputTXT;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton saving;
    // End of variables declaration


    //==============================getter setter========================================



    public JTextField getID_txtField() {
        return ID_txtField;
    }


    public JPasswordField getjPasswordField() {
        return jPasswordField;
    }


}
