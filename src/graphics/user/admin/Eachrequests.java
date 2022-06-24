package graphics.user.admin;

import project.first.AdminAccess;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Eachrequests extends javax.swing.JFrame {


    public Eachrequests(ArrayList<show>list) {
        this.list=list;
        initComponents();

        setResizable(false);
        setVisible(true);
        if (list.size()==0)
        {
            extraInfo.setText("there are no requests");
            JFrame j=new JFrame();
            JOptionPane.showMessageDialog(j,"there are no requests");
            this.dispose();
        }
        EachShow();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        extraInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        acceptBtn = new javax.swing.JToggleButton();
        passBtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("request managing ");

        extraInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        extraInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        extraInfo.setText("extra info");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 7));
        jScrollPane1.setViewportView(jTextArea1);

        acceptBtn.setText("accept");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        passBtn.setText("pass");
        passBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(extraInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 133, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(acceptBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passBtn)
                                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(extraInfo)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(acceptBtn)
                                        .addComponent(passBtn))
                                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void passBtnActionPerformed(java.awt.event.ActionEvent evt) {
        AdminAccess.setRequestState(false);
        AdminAccess.setRequestState(false);
        AdminAccess.setNotifying(true);
        AdminAccess.mySuspend();
        EachShow();
    }

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {
        AdminAccess.setRequestState(true);
        AdminAccess.setRequestState(true);
        AdminAccess.setNotifying(true);
        AdminAccess.mySuspend();
        EachShow();
    }

    private void EachShow()
    {
        if (list.size()>counter) {
            jTextArea1.setText(list.get(counter).toString());
            ++counter;
        }else this.dispose();
    }


    // Variables declaration - do not modify
    private ArrayList<show>list;
    private int counter=0;
    private javax.swing.JToggleButton acceptBtn;
    private javax.swing.JLabel extraInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton passBtn;
    // End of variables declaration
}
