package graphics.user.seller;


import account.making.Request;
import allof.exceptions.AccessAllowance;
import graphics.SAveChanges;
import graphics.mainPage;
import graphics.user.changeInfo;
import graphics.user.showINFO;
import project.first.SellerAccess;
import project.first.project;

import javax.swing.*;
import java.awt.*;

import static project.first.SellerAccess.*;
import static project.first.project.print;
import static project.first.project.useraccount;

public class SellerMainMenu extends javax.swing.JFrame {


    public SellerMainMenu() {
        initComponents();

        setResizable(false);
        this.setLocationRelativeTo(null); //make it center
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        top_label = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        changeInfo_btn = new javax.swing.JToggleButton();
        addPro = new javax.swing.JToggleButton();
        changePro = new javax.swing.JToggleButton();
        deletePro = new javax.swing.JToggleButton();
        sellHistory = new javax.swing.JToggleButton();
        logOut = new javax.swing.JToggleButton();
        ownProducts = new javax.swing.JToggleButton();
        discountMake = new javax.swing.JToggleButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        changeAsk = new javax.swing.JToggleButton();
        AskDelete = new javax.swing.JToggleButton();
        AskAdd = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        top_label.setBackground(new java.awt.Color(255, 204, 204));
        top_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        top_label.setForeground(new java.awt.Color(0, 255, 255));
        top_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        top_label.setText("Seller");

        jToggleButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ES\\Pictures\\project\\8.png")); // NOI18N
        jToggleButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLayeredPane1.setBackground(new java.awt.Color(102, 102, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 4));
        jLayeredPane1.setForeground(new java.awt.Color(0, 102, 102));

        changeInfo_btn.setBackground(new java.awt.Color(0, 153, 153));
        changeInfo_btn.setText("change info");
        changeInfo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInfo_btnActionPerformed(evt);
            }
        });

        addPro.setBackground(new java.awt.Color(0, 102, 102));
        addPro.setText("add a product");
        addPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProActionPerformed(evt);
            }
        });

        changePro.setBackground(new java.awt.Color(51, 102, 255));
        changePro.setText("change a pro");
        changePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeProActionPerformed(evt);
            }
        });

        deletePro.setBackground(new java.awt.Color(153, 51, 255));
        deletePro.setText("delete a pro");
        deletePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProActionPerformed(evt);
            }
        });

        sellHistory.setBackground(new java.awt.Color(102, 102, 255));
        sellHistory.setText("selling history");
        sellHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellHistoryActionPerformed(evt);
            }
        });

        logOut.setBackground(new java.awt.Color(153, 51, 255));
        logOut.setText("log out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        ownProducts.setBackground(new java.awt.Color(102, 0, 255));
        ownProducts.setText("own pro list");
        ownProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownProductsActionPerformed(evt);
            }
        });

        discountMake.setBackground(new java.awt.Color(0, 102, 204));
        discountMake.setText("make discount");
        discountMake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountMakeActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(changeInfo_btn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(addPro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(changePro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(deletePro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sellHistory, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(logOut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ownProducts, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(discountMake, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(logOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sellHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deletePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(changePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(changeInfo_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ownProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(discountMake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(changeInfo_btn)
                                .addGap(18, 18, 18)
                                .addComponent(addPro)
                                .addGap(18, 18, 18)
                                .addComponent(changePro)
                                .addGap(18, 18, 18)
                                .addComponent(deletePro)
                                .addGap(18, 18, 18)
                                .addComponent(sellHistory)
                                .addGap(18, 18, 18)
                                .addComponent(ownProducts)
                                .addGap(18, 18, 18)
                                .addComponent(discountMake)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(logOut)
                                .addGap(21, 21, 21))
        );

        jLayeredPane2.setBackground(new java.awt.Color(204, 204, 204));
        jLayeredPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 255), 7, true));

        changeAsk.setBackground(new java.awt.Color(204, 51, 255));
        changeAsk.setText("change a product");
        changeAsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAskActionPerformed(evt);
            }
        });

        AskDelete.setBackground(new java.awt.Color(255, 102, 204));
        AskDelete.setText("delete a product");
        AskDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AskDeleteActionPerformed(evt);
            }
        });

        AskAdd.setBackground(new java.awt.Color(255, 153, 153));
        AskAdd.setText("add a product");
        AskAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AskAddActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(changeAsk, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(AskDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(AskAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                .addComponent(changeAsk)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(AskDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AskAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addComponent(changeAsk)
                                .addGap(18, 18, 18)
                                .addComponent(AskDelete)
                                .addGap(18, 18, 18)
                                .addComponent(AskAdd)
                                .addGap(14, 14, 14))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 51, 204));

        jLabel1.setBackground(new java.awt.Color(0, 153, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("asking for :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(177, 177, 177)
                                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLayeredPane2)
                                                                        .addComponent(jSeparator1)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(56, 56, 56)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(233, 233, 233)
                                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(192, 192, 192)
                                                .addComponent(top_label, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(top_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLayeredPane1)
                                .addGap(12, 12, 12))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void changeInfo_btnActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                changeInfo change=new changeInfo();
            }
        });
    }

    private void addProActionPerformed(java.awt.event.ActionEvent evt) {

        if (useraccount.getSeller().getAdd_product() <= 0) {
            JFrame j=new JFrame();
            JOptionPane.showMessageDialog(j,"you are not allowed to add");
            return;
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                addProduct add_Product=new addProduct();
            }
        });
    }

    private void changeProActionPerformed(java.awt.event.ActionEvent evt) {
        if (useraccount.getSeller().getAdd_product() <= 0) {
            JFrame j=new JFrame();
            JOptionPane.showMessageDialog(j,"you are not allowed to change");
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                changeProduct2 changeProduct=new changeProduct2();
            }
        });
    }

    private void deleteProActionPerformed(java.awt.event.ActionEvent evt) {

        if (useraccount.getSeller().getAdd_product() <= 0) {
            JFrame j=new JFrame();
            JOptionPane.showMessageDialog(j,"you are not allowed to delete");
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                deleteProduct DeleteProduct=new deleteProduct();
            }
        });
    }

    private void sellHistoryActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                showSellits sellits=new showSellits();
            }
        });
    }

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {

        com.formdev.flatlaf.FlatDarkLaf.setup();
        project.saving();
        project.CategoryOrganize();
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
                com.formdev.flatlaf.FlatDarkLaf.setup();
                showINFO showInfo=new showINFO();
            }
        });
    }

    private void discountMakeActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                makeDiscount make_discount=new makeDiscount();
            }
        });
    }

    private void ownProductsActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                com.formdev.flatlaf.FlatDarkLaf.setup();
                sellerProducts seller_Products=new sellerProducts();
            }
        });
    }

    private void AskAddActionPerformed(java.awt.event.ActionEvent evt) {
        AskChange();
        sendingRequests();

    }

    private void AskDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        AskDelete();
        sendingRequests();

    }

    private void changeAskActionPerformed(java.awt.event.ActionEvent evt) {
        AskAdd();
        sendingRequests();
    }


    private void sendingRequests()
    {
        jLabel1.setText("sending");
        try {
            for (int i=0 ;i<3 ;++i) {
                Thread.sleep(200);
                jLabel1.setText(jLabel1.getText()+".");
            }
        }catch (Exception e){}
        jLabel1.setText("sent !");
        jLabel1.setForeground(Color.GREEN);
    }


    // Variables declaration - do not modify
    private javax.swing.JToggleButton AskAdd;
    private javax.swing.JToggleButton AskDelete;
    private javax.swing.JToggleButton addPro;
    private javax.swing.JToggleButton changeAsk;
    private javax.swing.JToggleButton changeInfo_btn;
    private javax.swing.JToggleButton changePro;
    private javax.swing.JToggleButton deletePro;
    private javax.swing.JToggleButton discountMake;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton logOut;
    private javax.swing.JToggleButton ownProducts;
    private javax.swing.JToggleButton sellHistory;
    private javax.swing.JLabel top_label;
    // End of variables declaration
}
