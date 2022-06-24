package graphics.user.admin;

import allof.exceptions.notFound;
import project.first.AdminAccess;

import javax.swing.*;
import java.awt.*;

public class requests extends javax.swing.JFrame {


    public requests() {
        initComponents();

        setResizable(false);
        setVisible(true);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        sellerRequest_btn = new javax.swing.JToggleButton();
        commentBtn = new javax.swing.JToggleButton();
        productChangr_btn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("requests");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 7));

        sellerRequest_btn.setForeground(new java.awt.Color(153, 153, 255));
        sellerRequest_btn.setText("requests for seller acc");
        sellerRequest_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellerRequest_btnActionPerformed(evt);
            }
        });

        commentBtn.setForeground(new java.awt.Color(102, 102, 255));
        commentBtn.setText("add comment");
        commentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBtnActionPerformed(evt);
            }
        });

        productChangr_btn.setForeground(new java.awt.Color(102, 102, 255));
        productChangr_btn.setText("change product by the seller");
        productChangr_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productChangr_btnActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(sellerRequest_btn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(commentBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(productChangr_btn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addGap(0, 57, Short.MAX_VALUE)
                                .addComponent(productChangr_btn)
                                .addGap(68, 68, 68))
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(sellerRequest_btn))
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(commentBtn)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap(48, Short.MAX_VALUE)
                                .addComponent(sellerRequest_btn)
                                .addGap(28, 28, 28)
                                .addComponent(commentBtn)
                                .addGap(27, 27, 27)
                                .addComponent(productChangr_btn)
                                .addGap(43, 43, 43))
        );

        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("choose request type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void productChangr_btnActionPerformed(java.awt.event.ActionEvent evt) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AdminAccess.requestSellerChangings();
                }catch (notFound e){
                    JFrame j=new JFrame();
                    JOptionPane.showMessageDialog(j,e.getMessage());
                }catch (Exception e)
                {
                    jLabel1.setText("error!");
                    jLabel1.setForeground(Color.red);
                }
            }
        }).start();
        this.dispose();
    }

    private void commentBtnActionPerformed(java.awt.event.ActionEvent evt) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AdminAccess.requestComment();
                }catch (notFound e){
                    JFrame j=new JFrame();
                    JOptionPane.showMessageDialog(j,e.getMessage());
                }catch (Exception e)
                {
                    jLabel1.setText("error!");
                    jLabel1.setForeground(Color.red);
                }
            }
        }).start();
        this.dispose();
    }

    private void sellerRequest_btnActionPerformed(java.awt.event.ActionEvent evt) {

       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   AdminAccess.requestAddSeller();
               }catch (notFound e){
                   JFrame j=new JFrame();
                   JOptionPane.showMessageDialog(j,e.getMessage());
               }catch (Exception e)
               {
                   jLabel1.setText("error!");
                   jLabel1.setForeground(Color.red);
               }
           }
       }).start();
       this.dispose();
    }



    // Variables declaration - do not modify
    private javax.swing.JToggleButton commentBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JToggleButton productChangr_btn;
    private javax.swing.JToggleButton sellerRequest_btn;
    // End of variables declaration
}
