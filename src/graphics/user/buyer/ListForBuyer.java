package graphics.user.buyer;

import products.Product;
import project.first.BuyerAccess;
import project.first.project;

import javax.swing.*;

import static project.first.project.*;

public class ListForBuyer extends javax.swing.JFrame {

    /**
     * Creates new form ListForBuyer
     */
    public ListForBuyer() {
        initComponents();
        addingElements();
        setResizable(false);

        this.setLocationRelativeTo(null);//location of the frame

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        myLayer = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        date_lbl = new javax.swing.JLabel();
        transmission_lbl = new javax.swing.JLabel();
        totalPrice_lbl = new javax.swing.JLabel();
        buyer_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_list = new javax.swing.JList<>(model);
        jLabel6 = new javax.swing.JLabel();
        mainMenue_btn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        myLayer.setBackground(new java.awt.Color(153, 255, 153));
        myLayer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 5));
        myLayer.setForeground(new java.awt.Color(0, 51, 51));

        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("process done successfully :your recipe :");

        jSeparator1.setForeground(new java.awt.Color(102, 0, 51));
        jSeparator1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Date");

        jLabel3.setText("Transmission");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total price");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Buyer");

        jSeparator2.setForeground(new java.awt.Color(102, 0, 102));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setViewportView(product_list);

        jLabel6.setText("products: ");

        mainMenue_btn.setBackground(new java.awt.Color(0, 153, 153));
        mainMenue_btn.setText("back to main menu");
        mainMenue_btn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainMenue_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenue_btnActionPerformed(evt);
            }
        });

        myLayer.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(date_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(transmission_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(totalPrice_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(buyer_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        myLayer.setLayer(mainMenue_btn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout myLayerLayout = new javax.swing.GroupLayout(myLayer);
        myLayer.setLayout(myLayerLayout);
        myLayerLayout.setHorizontalGroup(
                myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(myLayerLayout.createSequentialGroup()
                                .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(myLayerLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(myLayerLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(113, 113, 113)
                                                .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(date_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                        .addComponent(transmission_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(totalPrice_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(buyer_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(myLayerLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(myLayerLayout.createSequentialGroup()
                                                .addGap(131, 131, 131)
                                                .addComponent(mainMenue_btn)))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        myLayerLayout.setVerticalGroup(
                myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(myLayerLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                        .addComponent(date_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                        .addComponent(transmission_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                        .addComponent(totalPrice_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(myLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buyer_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mainMenue_btn)
                                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(myLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(myLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void mainMenue_btnActionPerformed(java.awt.event.ActionEvent evt) {
        saving();
        this.dispose();

    }

    private void addingElements()
    {
        date_lbl.setText("Date: "+ useraccount.getBuyer().getBuyList().getDate());
        transmission_lbl.setText("transmission: "+ useraccount.getBuyer().getBuyList().getDelivery());
        totalPrice_lbl.setText("total price: "+ useraccount.getBuyer().getBuyList().getPrice());
        buyer_lbl.setText("buyer: "+ useraccount.getBuyer().getBuyList().getBuyerName());

        int i=1;
        for (Product product: useraccount.getBuyer().getBuyList().products_List)
        {
            if (product.getPrice_with_discount()==-10)
                model.addElement(i+"."+product.getName()+"    price: "+product.getPrice()
                        +"   with discount: "+product.getPrice());
            else
            {
                model.addElement(i+"."+product.getName()+"    price: "+product.getPrice()
                        +"   with discount: "+product.getPrice_with_discount());
                product.setPrice_with_discount(-10);
            }
            ++i;
        }
        BuyerAccess.setNotifying(true);
        BuyerAccess.notifier();
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel buyer_lbl;
    private javax.swing.JLabel date_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton mainMenue_btn;
    private javax.swing.JLayeredPane myLayer;
    private javax.swing.JList<String> product_list;
    private javax.swing.JLabel totalPrice_lbl;
    private javax.swing.JLabel transmission_lbl;
    DefaultListModel<String> model=new DefaultListModel<>();
    // End of variables declaration
}
