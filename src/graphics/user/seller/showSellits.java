package graphics.user.seller;

import account.making.SellList;
import products.Product;
import random.works.showing;

import javax.swing.*;

import static project.first.project.print;
import static project.first.project.useraccount;

public class showSellits extends javax.swing.JFrame {

    /**
     * Creates new form showSellits
     */
    public showSellits() {
        initComponents();

        setResizable(false);
        setVisible(true);

        back_btn.setEnabled(false);
        if (useraccount.getSeller().list.size()==0)
        {
            next_btn.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        factor_lbl = new javax.swing.JLabel();
        date_lbl = new javax.swing.JLabel();
        transmission_lbl = new javax.swing.JLabel();
        buyer_lbl = new javax.swing.JLabel();
        price_lbl = new javax.swing.JLabel();
        factor_txt = new javax.swing.JLabel();
        date_txt = new javax.swing.JLabel();
        transmission_txt = new javax.swing.JLabel();
        buyer_txt = new javax.swing.JLabel();
        price_txt = new javax.swing.JLabel();
        back_btn = new javax.swing.JToggleButton();
        next_btn = new javax.swing.JToggleButton();
        out_btn = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<showings>(model);
        product_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("sellists");

        factor_lbl.setText("factor number :");

        date_lbl.setText("date:");

        transmission_lbl.setText("transmission : ");

        buyer_lbl.setText("buyer : ");

        price_lbl.setText("price :");

        factor_txt.setText("jLabel9");

        date_txt.setText("jLabel10");

        transmission_txt.setText("jLabel11");

        buyer_txt.setText("jLabel12");

        price_txt.setText("jLabel13");

        back_btn.setText("back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        next_btn.setText("next");
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });

        out_btn.setText("out");
        out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                out_btnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        product_lbl.setText("products :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(transmission_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(factor_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(price_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(factor_txt)
                                                        .addComponent(transmission_txt))
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(date_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buyer_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(buyer_txt)
                                                        .addComponent(date_txt)))
                                        .addComponent(price_txt))
                                .addGap(74, 74, 74))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(next_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(out_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(product_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(factor_lbl)
                                        .addComponent(date_lbl)
                                        .addComponent(factor_txt)
                                        .addComponent(date_txt))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(transmission_lbl)
                                        .addComponent(buyer_lbl)
                                        .addComponent(transmission_txt)
                                        .addComponent(buyer_txt))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(price_lbl)
                                        .addComponent(price_txt))
                                .addGap(24, 24, 24)
                                .addComponent(product_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(back_btn)
                                        .addComponent(next_btn)
                                        .addComponent(out_btn))
                                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>

    private void out_btnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {
        back_btn.setEnabled(true);
        if (useraccount.getSeller().list.size() >counter)
            showPro();
        if (useraccount.getSeller().list.size()-1 == counter) next_btn.setEnabled(false);
    }

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {
        counter--;
        showPro();
    }


    private void showPro()
    {
        SellList sellList= useraccount.getSeller().list.get(counter);
        buyer_txt.setText(sellList.getBuyerName());
        transmission_txt.setText(sellList.getTransmission());
        date_txt.setText(sellList.getDate());
        price_txt.setText(Double.toString(sellList.getPrice()));
        factor_txt.setText(Integer.toString(sellList.getFactorNum()));

        for (Product product:sellList.products_list)
        {
            showings showings=new showings(product.getName() ,Integer.toString(product.getEarmark()));
            model.addElement(showings);
        }

        counter++;
    }

    // Variables declaration - do not modify
    private int counter=0;
    private javax.swing.JToggleButton back_btn;
    private javax.swing.JLabel buyer_lbl;
    private javax.swing.JLabel buyer_txt;
    private javax.swing.JLabel date_lbl;
    private javax.swing.JLabel date_txt;
    private javax.swing.JLabel factor_lbl;
    private javax.swing.JLabel factor_txt;
    private javax.swing.JList<showings> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton next_btn;
    private javax.swing.JToggleButton out_btn;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JLabel price_txt;
    private javax.swing.JLabel product_lbl;
    private javax.swing.JLabel transmission_lbl;
    private javax.swing.JLabel transmission_txt;
    DefaultListModel<showings> model;
    // End of variables declaration


    class showings
    {
        private String name;
        private String earmark;

        public showings(String name, String earmark) {
            this.name = name;
            this.earmark = earmark;
        }

        @Override
        public String toString() {
            return "showings{" +
                    "name='" + name + '\'' +
                    ", earmark='" + earmark + '\'' +
                    '}';
        }
    }
}
