package graphics.user.buyer;

import allof.exceptions.wrongInputType;
import project.first.BuyerAccess;
import random.works.showing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class rateProduct extends javax.swing.JFrame {

    ArrayList<showing> showings ;


    public rateProduct() {
        initComponents();


        setResizable(false);
        setVisible(true);

        showing();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>(model);
        takeEarmrk_lbl = new javax.swing.JLabel();
        jTextField = new javax.swing.JTextField();
        rateLbl = new javax.swing.JLabel();
        jComboBoxRate = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("rate product");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setViewportView(jList1);

        takeEarmrk_lbl.setForeground(new java.awt.Color(153, 255, 153));
        takeEarmrk_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        takeEarmrk_lbl.setText("please enter the earmark of the product : ");

        jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }
        });

        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });


        rateLbl.setForeground(new java.awt.Color(153, 153, 255));
        rateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rateLbl.setText("rate : ");

        jComboBoxRate.setForeground(new java.awt.Color(255, 102, 102));
        jComboBoxRate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5"}));
        jComboBoxRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRateActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 11)); // NOI18N
        submit.setForeground(new java.awt.Color(0, 102, 102));
        submit.setText("Submit");

        jSeparator1.setForeground(new java.awt.Color(255, 153, 153));

        jSeparator3.setForeground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(253, 253, 253)
                                                .addComponent(submit))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGap(68, 68, 68)
                                                                        .addComponent(rateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(54, 54, 54)
                                                                        .addComponent(jComboBoxRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(takeEarmrk_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(211, Short.MAX_VALUE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(takeEarmrk_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jComboBoxRateActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            BuyerAccess.rating(Integer.parseInt(jTextField.getText()) ,
                    Integer.parseInt(jComboBoxRate.getSelectedItem().toString()));
            JFrame j=new JFrame();
            JOptionPane.showMessageDialog(j,"rated !");
            dispose();
        }catch (wrongInputType e)
        {
            takeEarmrk_lbl.setText("wrong earmark !");
            takeEarmrk_lbl.setForeground(Color.red);
        }
    }


    private void showing()
    {
        showings=BuyerAccess.rating_allowed_products();

        if (showings.size()==0)
            jTextField.setText("no products to be rated");

        for (showing Show : showings)
            model.addElement(Show);

    }


    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> jComboBoxRate;
    private javax.swing.JList<showing> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField;
    private javax.swing.JLabel rateLbl;
    private javax.swing.JButton submit;
    private javax.swing.JLabel takeEarmrk_lbl;
    DefaultListModel<showing> model=new DefaultListModel<>();
    // End of variables declaration


    //=============================================================================================

}




