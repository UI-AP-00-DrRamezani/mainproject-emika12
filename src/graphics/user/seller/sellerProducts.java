package graphics.user.seller;


import products.Product;

import java.awt.*;

import static project.first.ProductPart.showEachProduct;
import static project.first.project.print;
import static project.first.project.useraccount;

public class sellerProducts extends javax.swing.JFrame {

    private static int counter=-0;

    public sellerProducts() {
        initComponents();
        setResizable(false);
        setVisible(true);

        info_txt.setEditable(false);
        monry_txt.setEditable(false);
        price_txt.setEditable(false);
        name_txt.setEditable(false);
        brand_txt.setEditable(false);

        if (useraccount.getSeller().productList.size()==0)
        {
            info_txt.setText("there are no products yet");
            info_txt.setBackground(Color.red);
            next_btn.setEnabled(false);
        }else showEach();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        name_lbl = new javax.swing.JLabel();
        brand_lbl = new javax.swing.JLabel();
        price_lbl = new javax.swing.JLabel();
        money_lbl = new javax.swing.JLabel();
        info_lbl = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        brand_txt = new javax.swing.JTextField();
        monry_txt = new javax.swing.JTextField();
        price_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        info_txt = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        next_btn = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("seller products");

        name_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name_lbl.setText("name");

        brand_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brand_lbl.setText("brand");

        price_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price_lbl.setText("price");

        money_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        money_lbl.setText("in stock");

        info_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info_lbl.setText("more information");

        name_txt.setEditable(false);

        brand_txt.setEditable(false);

        monry_txt.setEditable(false);

        price_txt.setEditable(false);

        info_txt.setEditable(false);
        info_txt.setColumns(20);
        info_txt.setRows(5);
        jScrollPane2.setViewportView(info_txt);

        jSeparator1.setForeground(new java.awt.Color(102, 255, 102));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 5));

        next_btn.setText("next");
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });

        jToggleButton1.setText("out");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(price_lbl)
                                                .addComponent(name_lbl))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(info_lbl)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(240, 240, 240))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(90, 90, 90)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(brand_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(money_lbl))
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(monry_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(brand_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(next_btn)
                                .addGap(122, 122, 122)
                                .addComponent(jToggleButton1)
                                .addGap(166, 166, 166)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(name_lbl)
                                        .addComponent(brand_lbl)
                                        .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(brand_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(price_lbl)
                                        .addComponent(money_lbl)
                                        .addComponent(monry_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(info_lbl)))
                                .addGap(35, 35, 35)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(next_btn)
                                        .addComponent(jToggleButton1))
                                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {

        if (useraccount.getSeller().productList.size()>counter) showEach();
        if (useraccount.getSeller().productList.size() -1==counter)next_btn.setEnabled(false);
    }

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void showEach()
    {
        Product product = useraccount.getSeller().productList.get(counter);
        name_txt.setText(product.getName());
        brand_txt.setText(product.getBrand());
        price_txt.setText(Integer.toString(product.getPrice()));
        monry_txt.setText(Integer.toString(product.getInStock()));
        info_txt.setText(product.getInfo());

        ++counter;
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel brand_lbl;
    private javax.swing.JTextField brand_txt;
    private javax.swing.JLabel info_lbl;
    private javax.swing.JTextArea info_txt;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel money_lbl;
    private javax.swing.JTextField monry_txt;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JTextField name_txt;
    private javax.swing.JToggleButton next_btn;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JTextField price_txt;
    // End of variables declaration
}