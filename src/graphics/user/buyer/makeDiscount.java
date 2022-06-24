package graphics.user.buyer;


import project.first.BuyerAccess;
import allof.exceptions.*;

import javax.swing.*;
import java.awt.*;

public class makeDiscount extends javax.swing.JFrame {

    /**
     * Creates new form makeDiscount
     */
    public makeDiscount() {
        initComponents();
        jLabel1.setEnabled(false);
        wrongCode.getParent().remove(wrongCode);
        wrongCode.setEnabled(false);
        labelCodeEnter.setEnabled(false);
        jTextField1.setEnabled(false);

        this.setLocationRelativeTo(null);

        setResizable(false);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        label = new javax.swing.JLabel();
        yesBtn = new javax.swing.JToggleButton();
        noBTN = new javax.swing.JToggleButton();
        wrongCode = new javax.swing.JLabel();
        labelCodeEnter = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600,400 ));

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("do you have dicount code? ");

        yesBtn.setText("yes");
        yesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesBtnActionPerformed(evt);
            }
        });

        noBTN.setText("no");
        noBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noBTNActionPerformed(evt);
            }
        });

        wrongCode.setForeground(new java.awt.Color(255, 0, 51));
        wrongCode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wrongCode.setPreferredSize(new java.awt.Dimension(4, 200));

        labelCodeEnter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCodeEnter.setText("please enter the code");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ES\\Pictures\\project\\55.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(72, 72, 72)
                                                                .addComponent(yesBtn)
                                                                .addGap(41, 41, 41)
                                                                .addComponent(noBTN))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(wrongCode, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGap(16, 16, 16)
                                                        .addComponent(labelCodeEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yesBtn)
                                        .addComponent(noBTN))
                                .addGap(31, 31, 31)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelCodeEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wrongCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            BuyerAccess.takeDiscountCodes("yes" , jTextField1.getText());
            jTextField1.setBackground(Color.CYAN);
            jLabel1.setForeground(Color.WHITE);
            jLabel1.setText("if you dont have any other code press no");
        }catch (notFound e){
            Myaction(e);
        }catch (timeExpired e){
           Myaction(e);
        }catch (capacityFinish e)
        {Myaction(e);}
    }

    private void yesBtnActionPerformed(java.awt.event.ActionEvent evt) {
        labelCodeEnter.setEnabled(true);
        jTextField1.setEnabled(true);
    }

    private void noBTNActionPerformed(java.awt.event.ActionEvent evt) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                BuyerAccess.lastDiscount();
            }
        }).start();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               ListForBuyer l=new ListForBuyer();
            }
        });
        this.dispose();

    }


    public void Myaction( Exception e)
    {
        jLabel1.setForeground(Color.red);
        jLabel1.setText(e.getMessage());
        jLabel1.setEnabled(true);
        wrongCode.setEnabled(true);
        this.add(wrongCode);
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelCodeEnter;
    private javax.swing.JToggleButton noBTN;
    private javax.swing.JLabel wrongCode;
    private javax.swing.JToggleButton yesBtn;
    // End of variables declaration
}