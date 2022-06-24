package graphics.user.buyer;

import products.Product;
import project.first.BuyerAccess;
import project.first.project;
import allof.exceptions.*;

import javax.swing.*;

import java.awt.*;
import java.util.InputMismatchException;

import static project.first.project.print;
import static project.first.project.useraccount;

public class basket extends javax.swing.JFrame {

    private double payMoney=0;

    /**
     * Creates new form basket
     */
    public basket() {

        initComponents();
        enterbtn.setEnabled(false);
        moneyBtn.setEnabled(false);
        cancel.setEnabled(false);
        showProducts();

        setResizable(true);
        setVisible(true);
    }

    public void showProducts()
    {
        for (Product product : project.useraccount.getBuyer().getBuyList().products_List)
            payMoney += product.getPrice();

        if(useraccount.getBuyer().getBuyList().products_List.size()==0)
        {
            model.addElement("your basket is empty");
            return;
        }

        for (Product product : project.useraccount.getBuyer().getBuyList().products_List)
        {
            model.addElement("name: " + product.getName() + "   earmark: " + product.getEarmark());
            model.addElement("price: "+ product.getPrice());
            model.addElement("=================");
        }
        label.setText("total price:"+payMoney);
    }


            @SuppressWarnings("unchecked")
            // <editor-fold defaultstate="collapsed" desc="Generated Code">
            private void initComponents() {

                jScrollPane2 = new javax.swing.JScrollPane();
                jScrollPane1 = new javax.swing.JScrollPane();
                jList1 = new javax.swing.JList<>(model);
                buyBtn = new javax.swing.JToggleButton();
                backBtn = new javax.swing.JToggleButton();
                label = new javax.swing.JLabel();
                moneyBtn = new javax.swing.JTextField();
                enterbtn = new javax.swing.JToggleButton();
                cancel = new javax.swing.JToggleButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 204)));
                jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

                jList1.setBackground(new java.awt.Color(204, 204, 255));
                jList1.setForeground(new java.awt.Color(0, 102, 102));
                jScrollPane1.setViewportView(jList1);

                jScrollPane2.setViewportView(jScrollPane1);

                buyBtn.setText("BUY");
                buyBtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buyBtnActionPerformed(evt);
                    }
                });

                backBtn.setText("BACK");
                backBtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        backBtnActionPerformed(evt);
                    }
                });

                label.setForeground(new java.awt.Color(102, 255, 102));
                label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label.setText("enter buy or back");

                moneyBtn.setForeground(new java.awt.Color(102, 102, 255));
                moneyBtn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                moneyBtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        moneyBtnActionPerformed(evt);
                    }
                });

                enterbtn.setText("enter");
                enterbtn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        enterbtnActionPerformed(evt);
                    }
                });

                cancel.setText("cancel");
                cancel.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cancelActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2)
                                        .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(buyBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(backBtn)
                                        .addGap(67, 67, 67))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(enterbtn)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 37, Short.MAX_VALUE)
                                                        .addComponent(moneyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap(31, Short.MAX_VALUE))))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(backBtn)
                                                .addComponent(buyBtn))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(moneyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(enterbtn)
                                                .addComponent(cancel))
                                        .addGap(0, 20, Short.MAX_VALUE))
                );

                pack();
                setLocationRelativeTo(null);

            }// </editor-fold>

    private void buyBtnActionPerformed(java.awt.event.ActionEvent evt) {
        check();
    }


    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void enterbtnActionPerformed(java.awt.event.ActionEvent evt) {
        useraccount.setMoneyInStock(Integer.parseInt(moneyBtn.getText()));
       check();
    }
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {
            BuyerAccess.basket(2);
    }

    private void moneyBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void check()
    {
        try {
            BuyerAccess.basket(1);
            this.dispose();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    makeDiscount m=new makeDiscount();
                }
            });


        }catch (outOfMoney e){
            label.setText(e.getMessage());
            label.setForeground(Color.red);
            enterbtn.setEnabled(false);
            moneyBtn.setEnabled(false);
            cancel.setEnabled(true);

            JFrame j=new JFrame();
            String money=JOptionPane.showInputDialog(j,"add money");

            try {
                if (money !=null)
                    useraccount.setMoneyInStock(Double.parseDouble(money));
            }catch (InputMismatchException s){}

        }
    }

    // Variables declaration - do not modify
    DefaultListModel<String> model =new DefaultListModel<>();
    private javax.swing.JToggleButton backBtn;
    private javax.swing.JToggleButton buyBtn;
    private javax.swing.JToggleButton enterbtn;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JTextField moneyBtn;
    private javax.swing.JToggleButton cancel;
    // End of variables declaration
}

