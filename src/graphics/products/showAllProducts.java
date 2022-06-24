package graphics.products;

import account.making.Seller;
import graphics.user.admin.show;
import products.Product;
import project.first.ProductPart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class showAllProducts extends javax.swing.JFrame {

    /**
     * Creates new form showAllProducts
     */
    public showAllProducts() {
        initComponents();


        //jLayeredPane1.getParent().remove(jLayeredPane1);
        //jLayeredPane2.getParent().remove(jLayeredPane2);
        //jLayeredPane3.getParent().remove(jLayeredPane3);
        //jLayeredPane4.getParent().remove(jLayeredPane4);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        reboot();
        jLayeredPane1.setEnabled(false);
        jLayeredPane2.setEnabled(false);
        jLayeredPane3.setEnabled(false);
        jLayeredPane4.setEnabled(false);

        previouse.setEnabled(false);

        this.setLocationRelativeTo(null);

        setResizable(false);
        products=ProductPart.products();

        if (products.length<=4)
            next.setEnabled(false);
        showing();
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        number_lbl = new javax.swing.JLabel();
        productNmae_lbl = new javax.swing.JLabel();
        price_lbl = new javax.swing.JLabel();
        name_txt = new javax.swing.JLabel();
        price_txt = new javax.swing.JLabel();
        moreInfo_btn = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        number_lbl1 = new javax.swing.JLabel();
        productNmae_lbl1 = new javax.swing.JLabel();
        price_lbl1 = new javax.swing.JLabel();
        name_txt1 = new javax.swing.JLabel();
        price_txt1 = new javax.swing.JLabel();
        moreInfo_btn1 = new javax.swing.JToggleButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        number_lbl2 = new javax.swing.JLabel();
        productNmae_lbl2 = new javax.swing.JLabel();
        price_lbl2 = new javax.swing.JLabel();
        name_txt2 = new javax.swing.JLabel();
        price_txt2 = new javax.swing.JLabel();
        moreInfo_btn2 = new javax.swing.JToggleButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        number_lbl3 = new javax.swing.JLabel();
        productNmae_lbl3 = new javax.swing.JLabel();
        price_lbl3 = new javax.swing.JLabel();
        name_txt3 = new javax.swing.JLabel();
        price_txt3 = new javax.swing.JLabel();
        moreInfo_btn3 = new javax.swing.JToggleButton();
        next = new javax.swing.JToggleButton();
        previouse = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 600));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 153), 4));

        number_lbl.setText("jLabel1");

        productNmae_lbl.setForeground(new java.awt.Color(153, 0, 153));
        productNmae_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productNmae_lbl.setText("name :");

        price_lbl.setForeground(new java.awt.Color(255, 0, 204));
        price_lbl.setText("price :");

        name_txt.setForeground(new java.awt.Color(0, 51, 204));
        name_txt.setText("jLabel1");

        price_txt.setForeground(new java.awt.Color(0, 204, 102));
        price_txt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        price_txt.setText("jLabel2");

        moreInfo_btn.setForeground(new java.awt.Color(153, 0, 255));
        moreInfo_btn.setText("more info");
        moreInfo_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        moreInfo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreInfo_btnActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(number_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(productNmae_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(price_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(name_txt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(price_txt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(moreInfo_btn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(number_lbl)
                                                .addGap(49, 49, 49)
                                                .addComponent(moreInfo_btn))
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(productNmae_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                        .addComponent(price_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(47, 47, 47)
                                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                        .addComponent(price_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productNmae_lbl)
                                        .addComponent(name_txt))
                                .addGap(32, 32, 32)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(price_lbl)
                                        .addComponent(price_txt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(number_lbl)
                                        .addComponent(moreInfo_btn))
                                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 153), 4));

        number_lbl1.setText("jLabel1");

        productNmae_lbl1.setForeground(new java.awt.Color(153, 0, 153));
        productNmae_lbl1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productNmae_lbl1.setText("name :");

        price_lbl1.setForeground(new java.awt.Color(255, 0, 204));
        price_lbl1.setText("price :");

        name_txt1.setForeground(new java.awt.Color(0, 51, 204));
        name_txt1.setText("jLabel1");

        price_txt1.setForeground(new java.awt.Color(0, 204, 102));
        price_txt1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        price_txt1.setText("jLabel2");

        moreInfo_btn1.setForeground(new java.awt.Color(153, 0, 255));
        moreInfo_btn1.setText("more info");
        moreInfo_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreInfo_btn1ActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(number_lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(productNmae_lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(price_lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(name_txt1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(price_txt1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(moreInfo_btn1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(number_lbl1)
                                                .addGap(49, 49, 49)
                                                .addComponent(moreInfo_btn1))
                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(productNmae_lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                        .addComponent(price_lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(47, 47, 47)
                                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(name_txt1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                        .addComponent(price_txt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productNmae_lbl1)
                                        .addComponent(name_txt1))
                                .addGap(32, 32, 32)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(price_lbl1)
                                        .addComponent(price_txt1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(number_lbl1)
                                        .addComponent(moreInfo_btn1))
                                .addGap(15, 15, 15))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 153), 4));

        number_lbl2.setText("jLabel1");

        productNmae_lbl2.setForeground(new java.awt.Color(153, 0, 153));
        productNmae_lbl2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productNmae_lbl2.setText("name :");

        price_lbl2.setForeground(new java.awt.Color(255, 0, 204));
        price_lbl2.setText("price :");

        name_txt2.setForeground(new java.awt.Color(0, 51, 204));
        name_txt2.setText("jLabel1");

        price_txt2.setForeground(new java.awt.Color(0, 204, 102));
        price_txt2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        price_txt2.setText("jLabel2");

        moreInfo_btn2.setForeground(new java.awt.Color(153, 0, 255));
        moreInfo_btn2.setText("more info");
        moreInfo_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreInfo_btn2ActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(number_lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(productNmae_lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(price_lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(name_txt2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(price_txt2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(moreInfo_btn2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
                jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(number_lbl2)
                                                .addGap(49, 49, 49)
                                                .addComponent(moreInfo_btn2))
                                        .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(productNmae_lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                        .addComponent(price_lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(47, 47, 47)
                                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(name_txt2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                        .addComponent(price_txt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
                jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productNmae_lbl2)
                                        .addComponent(name_txt2))
                                .addGap(32, 32, 32)
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(price_lbl2)
                                        .addComponent(price_txt2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(number_lbl2)
                                        .addComponent(moreInfo_btn2))
                                .addGap(15, 15, 15))
        );

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 153), 4));

        number_lbl3.setText("jLabel1");

        productNmae_lbl3.setForeground(new java.awt.Color(153, 0, 153));
        productNmae_lbl3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productNmae_lbl3.setText("name :");

        price_lbl3.setForeground(new java.awt.Color(255, 0, 204));
        price_lbl3.setText("price :");

        name_txt3.setForeground(new java.awt.Color(0, 51, 204));
        name_txt3.setText("jLabel1");

        price_txt3.setForeground(new java.awt.Color(0, 204, 102));
        price_txt3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        price_txt3.setText("jLabel2");

        moreInfo_btn3.setForeground(new java.awt.Color(153, 0, 255));
        moreInfo_btn3.setText("more info");
        moreInfo_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreInfo_btn3ActionPerformed(evt);
            }
        });

        jLayeredPane4.setLayer(number_lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(productNmae_lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(price_lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(name_txt3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(price_txt3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(moreInfo_btn3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
                jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(number_lbl3)
                                                .addGap(49, 49, 49)
                                                .addComponent(moreInfo_btn3))
                                        .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(productNmae_lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                        .addComponent(price_lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(47, 47, 47)
                                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(name_txt3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                        .addComponent(price_txt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
                jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productNmae_lbl3)
                                        .addComponent(name_txt3))
                                .addGap(32, 32, 32)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(price_lbl3)
                                        .addComponent(price_txt3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(number_lbl3)
                                        .addComponent(moreInfo_btn3))
                                .addGap(15, 15, 15))
        );

        next.setText("next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        previouse.setText("previouse");
        previouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previouseActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(102, 102, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no filter", "digital products", "house products", "outfits", "snacks", "most expensive", "least expensive" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 51, 153));
        jLabel1.setText("filter : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(48, 48, 48)
                                                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(48, 48, 48)
                                                                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(previouse)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(next)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(next)
                                        .addComponent(previouse))
                                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>

    private void moreInfo_btnActionPerformed(java.awt.event.ActionEvent evt) {
        ProductPart.showEachProduct(products[Integer.parseInt(number_lbl.getText())]);
    }

    private void moreInfo_btn1ActionPerformed(java.awt.event.ActionEvent evt) {
        ProductPart.showEachProduct(products[Integer.parseInt(number_lbl1.getText())]);
    }

    private void moreInfo_btn2ActionPerformed(java.awt.event.ActionEvent evt) {
        ProductPart.showEachProduct(products[Integer.parseInt(number_lbl2.getText())]);
    }

    private void moreInfo_btn3ActionPerformed(java.awt.event.ActionEvent evt) {
        ProductPart.showEachProduct(products[Integer.parseInt(number_lbl3.getText())]);
    }

    private void previouseActionPerformed(java.awt.event.ActionEvent evt) {

        jLayeredPane1.setEnabled(false);
        jLayeredPane2.setEnabled(false);
        jLayeredPane3.setEnabled(false);
        jLayeredPane4.setEnabled(false);

        counter-=8;
        if (counter==0)
            previouse.setEnabled(false);
        next.setEnabled(true);
        showing();
    }

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {
        reboot();


        showing();
        if (counter >= products.length)
            next.setEnabled(false);
        previouse.setEnabled(true);
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        reboot();
        counter=0;
        if (jComboBox1.getSelectedItem().toString().equals("digital products"))
            products=ProductPart.digitalProductFilter();
        else if (jComboBox1.getSelectedItem().toString().equals("house products"))
            products=ProductPart.houseProductsFilter();
        else if (jComboBox1.getSelectedItem().toString().equals("outfits"))
            products=ProductPart.outfitFilter();
        else if (jComboBox1.getSelectedItem().toString().equals("snacks"))
            products=ProductPart.snackFilter();
        else if (jComboBox1.getSelectedItem().toString().equals("most expensive"))
            products=ProductPart.mostExpensiveFilter();
        else if (jComboBox1.getSelectedItem().toString().equals("least expensive"))
            products=ProductPart.lessExpensiveFilter();

        showing();

    }


    public void showing()
    {

        int counter2=counter;
        for (int i=counter2 ;i<counter2+4;++i)
        {
            if (i>=products.length)
                break;
            Product product=products[i];
            if (!jLayeredPane1.isEnabled()) {

                jLayeredPane1.setEnabled(true);
                moreInfo_btn.setEnabled(true);
               // jPanel1.add(jLayeredPane1);

                name_txt.setText(product.getName());
                price_txt.setText(Integer.toString(product.getPrice()));

                number_lbl.setText(Integer.toString(counter));
                number_lbl.setEnabled(false);

            }else if (!jLayeredPane2.isEnabled()) {
                //jPanel1.add(jLayeredPane2);
                jLayeredPane2.setEnabled(true);
                moreInfo_btn1.setEnabled(true);


                name_txt1.setText(product.getName());
                price_txt1.setText(Integer.toString(product.getPrice()));

                number_lbl1.setText(Integer.toString(counter));
                number_lbl1.setEnabled(false);

            }else if (!jLayeredPane3.isEnabled()) {
                //jPanel1.add(jLayeredPane3);
                jLayeredPane3.setEnabled(true);
                moreInfo_btn2.setEnabled(true);

                name_txt2.setText(product.getName());
                price_txt2.setText(Integer.toString(product.getPrice()));

                number_lbl2.setText(Integer.toString(counter));
                number_lbl2.setEnabled(false);

            }else if (!jLayeredPane4.isEnabled()) {
                //jPanel1.add(jLayeredPane4);
                jLayeredPane4.setEnabled(true);
                moreInfo_btn3.setEnabled(true);

                name_txt3.setText(product.getName());
                price_txt3.setText(Integer.toString(product.getPrice()));

                number_lbl3.setText(Integer.toString(counter));
                number_lbl3.setEnabled(false);

            }
            counter++;
            if (counter%4==0)
                break;
        }

        jLayeredPane4.setEnabled(false);
        jLayeredPane3.setEnabled(false);
        jLayeredPane2.setEnabled(false);
        jLayeredPane1.setEnabled(false);
    }

    public void reboot()
    {

        moreInfo_btn.setEnabled(false);
        moreInfo_btn1.setEnabled(false);
        moreInfo_btn2.setEnabled(false);
        moreInfo_btn3.setEnabled(false);

        name_txt.setText("---");
        name_txt1.setText("---");
        name_txt2.setText("---");
        name_txt3.setText("---");

        price_txt.setText("---");
        price_txt1.setText("---");
        price_txt2.setText("---");
        price_txt3.setText("---");

        number_lbl.setText("");
        number_lbl1.setText("");
        number_lbl2.setText("");
        number_lbl3.setText("");

    }



    // Variables declaration - do not modify
    private int counter=0;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton moreInfo_btn;
    private javax.swing.JToggleButton moreInfo_btn1;
    private javax.swing.JToggleButton moreInfo_btn2;
    private javax.swing.JToggleButton moreInfo_btn3;
    private javax.swing.JLabel name_txt;
    private javax.swing.JLabel name_txt1;
    private javax.swing.JLabel name_txt2;
    private javax.swing.JLabel name_txt3;
    private javax.swing.JToggleButton next;
    private javax.swing.JLabel number_lbl;
    private javax.swing.JLabel number_lbl1;
    private javax.swing.JLabel number_lbl2;
    private javax.swing.JLabel number_lbl3;
    private javax.swing.JToggleButton previouse;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JLabel price_lbl1;
    private javax.swing.JLabel price_lbl2;
    private javax.swing.JLabel price_lbl3;
    private javax.swing.JLabel price_txt;
    private javax.swing.JLabel price_txt1;
    private javax.swing.JLabel price_txt2;
    private javax.swing.JLabel price_txt3;
    private javax.swing.JLabel productNmae_lbl;
    private javax.swing.JLabel productNmae_lbl1;
    private javax.swing.JLabel productNmae_lbl2;
    private javax.swing.JLabel productNmae_lbl3;
    private Product [] products ;
    private ArrayList<show>shows=new ArrayList<>();
    // End of variables declaration
}
