package graphics.user.admin;


import graphics.SAveChanges;
import graphics.mainPage;
import graphics.user.changeInfo;
import graphics.user.admin.*;
import graphics.user.showINFO;
import project.first.AdminAccess;
import project.first.project;

import javax.swing.*;

public class AdminMainMenu extends javax.swing.JFrame {


    public AdminMainMenu() {
        initComponents();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        top_label = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        changeInfo_btn = new javax.swing.JToggleButton();
        requests = new javax.swing.JToggleButton();
        allUsers = new javax.swing.JToggleButton();
        categories = new javax.swing.JToggleButton();
        deleteUser = new javax.swing.JToggleButton();
        logOut = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        top_label.setBackground(new java.awt.Color(255, 204, 204));
        top_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        top_label.setForeground(new java.awt.Color(0, 204, 153));
        top_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        top_label.setText("Admin");

        jToggleButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ES\\Pictures\\project\\99.png")); // NOI18N
        jToggleButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(150, 150));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 4));
        jLayeredPane1.setForeground(new java.awt.Color(0, 102, 102));

        changeInfo_btn.setBackground(new java.awt.Color(0, 153, 153));
        changeInfo_btn.setText("change info");
        changeInfo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInfo_btnActionPerformed(evt);
            }
        });

        requests.setBackground(new java.awt.Color(0, 102, 102));
        requests.setText("requests");
        requests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestsActionPerformed(evt);
            }
        });

        allUsers.setBackground(new java.awt.Color(51, 102, 255));
        allUsers.setText("all users");
        allUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allUsersActionPerformed(evt);
            }
        });

        categories.setBackground(new java.awt.Color(153, 51, 255));
        categories.setText("categories");
        categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesActionPerformed(evt);
            }
        });

        deleteUser.setBackground(new java.awt.Color(102, 102, 255));
        deleteUser.setText("delete a user");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });

        logOut.setBackground(new java.awt.Color(153, 51, 255));
        logOut.setText("log out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(changeInfo_btn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(requests, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(allUsers, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(categories, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(deleteUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(logOut, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(logOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(categories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(allUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(requests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(changeInfo_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(changeInfo_btn)
                                .addGap(36, 36, 36)
                                .addComponent(requests)
                                .addGap(33, 33, 33)
                                .addComponent(allUsers)
                                .addGap(38, 38, 38)
                                .addComponent(categories)
                                .addGap(38, 38, 38)
                                .addComponent(deleteUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(logOut)
                                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)
                                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(top_label, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(top_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void changeInfo_btnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                changeInfo change=new changeInfo();
            }
        });
    }

    private void requestsActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                requests r=new requests();
            }
        });
    }

    private void allUsersActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                users u=new users(AdminAccess.allUsers(1));
            }
        });
    }

    private void categoriesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                deleteUser d=new deleteUser(AdminAccess.allUsers(2));
            }
        });
    }

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {
        project.CategoryOrganize();
        project.saving();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainPage m=new mainPage();
            }
        });
        this.dispose();
    }

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showINFO s=new showINFO();
            }
        });
    }



    // Variables declaration - do not modify
    private javax.swing.JToggleButton allUsers;
    private javax.swing.JToggleButton categories;
    private javax.swing.JToggleButton changeInfo_btn;
    private javax.swing.JToggleButton deleteUser;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton logOut;
    private javax.swing.JToggleButton requests;
    private javax.swing.JLabel top_label;
    // End of variables declaration
}
