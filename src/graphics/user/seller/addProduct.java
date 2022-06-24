package graphics.user.seller;


import allof.exceptions.AccessAllowance;
import project.first.SellerAccess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class addProduct extends javax.swing.JFrame {

    String order;
    String change;
    public static String [] data;
    private ArrayList<String> tableData=new ArrayList<>();
    private static int i=0;
    /**
     * Creates new form addProduct
     */
    public addProduct() {
        initComponents();

        setResizable(false);
        setVisible(true);

        jTable1.getParent().remove(jTable1);
        type.getParent().remove(type);

        jScrollPane1.getParent().remove(jScrollPane1);
        jScrollPane2.getParent().remove(jScrollPane2);


    }


    @SuppressWarnings("unchecked")


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
        category_type = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        info_txt = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        submit_btn = new javax.swing.JToggleButton();
        error_txt = new javax.swing.JLabel();
        category_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(tableModel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("adding product");

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

        category_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "digital products", "house products", "outfits", "snacks" }));
        category_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category_typeActionPerformed(evt);
            }
        });

        info_txt.setColumns(20);
        info_txt.setRows(5);
        jScrollPane2.setViewportView(info_txt);

        jSeparator1.setForeground(new java.awt.Color(102, 255, 102));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 5));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("type");

        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        submit_btn.setText("submit");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });

        error_txt.setForeground(new java.awt.Color(255, 0, 51));
        error_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error_txt.setText("error box");

        category_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        category_lbl.setText("category");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(money_lbl)
                                                                .addGap(8, 8, 8))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(category_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(category_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(monry_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(brand_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)
                                                .addComponent(brand_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(88, 88, 88))
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(49, 49, 49)
                                                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(125, 125, 125)
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(267, 267, 267)
                                                .addComponent(submit_btn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(error_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(category_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(info_lbl)
                                                        .addComponent(category_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(42, 42, 42))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(submit_btn)
                                .addGap(32, 32, 32)
                                .addComponent(error_txt)
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>



    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (category_type.getSelectedItem()==null || type.getSelectedItem()==null) {
            error_txt.setText("please choose the types as well");
            name_txt.setText("");
            brand_txt.setText("");
            price_txt.setText("");
            monry_txt.setText("");
        }
        else {

            try {
                SellerAccess.addProduct(name_txt.getText(), brand_txt.getText(),
                        price_txt.getText(), monry_txt.getText(), info_txt.getText()
                        , category_type.getSelectedItem().toString(), type.getSelectedItem().toString(),data);

                JFrame j=new JFrame();
                JOptionPane.showMessageDialog(j,"added successfully");
            } catch (InputMismatchException e) {
                error_txt.setText("wrong input type !");
            } catch (IllegalArgumentException error) {
                IllegalArgumentException error2 = new IllegalArgumentException("wrong input");
                error_txt.setText(error2.getMessage());
            } catch (AccessAllowance ac) {
            }
            finally {
                this.dispose();
                data=null;
                i=0;
            }
        }
    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {

        if (type.getSelectedItem().toString().equals("laptop"))
        {
            String[]names={"proessor Model","for gaming"};
            tableData.addAll(List.of(names));
           // addingColumns(2,names);

        }else if (type.getSelectedItem().toString().equals("mobile"))
        {
            String[]names={"SIM numbers","camera quality"};
            tableData.addAll(List.of(names));
        }else if (type.getSelectedItem().toString().equals("television"))
        {
            String[]names={"picture quality","windows size"};
            tableData.addAll(List.of(names));
        }else if (type.getSelectedItem().toString().equals("refrigerator"))
        {
            String[]names={"storage", "model","having freezer"};
            tableData.addAll(List.of(names));
        }else if (type.getSelectedItem().toString().equals("dressing") ||
                type.getSelectedItem().toString().equals("shoes"))
        {
            String[]names={"size","model"};
            tableData.addAll(List.of(names));
        }else
        {
            String[]names={"producing date","expiring date"};
            tableData.addAll(List.of(names));
        }
        addingColumns(tableData);
    }

    private void category_typeActionPerformed(java.awt.event.ActionEvent evt) {

        tableData=new ArrayList<>();

        if (category_type.getSelectedItem().toString().equals("digital products"))
        {
            type.addItem("laptop");
            type.addItem("mobile");

            String[]names={"ram space","memory","operating system","resolution"};
            tableData.addAll(List.of(names));


        }else if (category_type.getSelectedItem().toString().equals("house products"))
        {

            type.addItem("refrigerator");
            type.addItem("television");


            String[]names={"energy usage","guarantee"};
            tableData.addAll(List.of(names));

            //jTable1.removeColumn(jTable1.getColumnModel().getColumn(3));
            //jTable1.removeColumn(jTable1.getColumnModel().getColumn(2));
        }else if (category_type.getSelectedItem().toString().equals("outfits"))
        {
            type.addItem("shoes");
            type.addItem("dressing");



            String[]names={"produced","material"};
            tableData.addAll(List.of(names));



            //jTable1.removeColumn(jTable1.getColumnModel().getColumn(3));
            //jTable1.removeColumn(jTable1.getColumnModel().getColumn(2));
        }else
        {
            type.addItem("snacks");
           // jTable1.removeColumn(jTable1.getColumnModel().getColumn(3));
            //jTable1.removeColumn(jTable1.getColumnModel().getColumn(2));
            //jTable1.removeColumn(jTable1.getColumnModel().getColumn(1));
            //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
        }


        type.setEnabled(true);
        //jTable1.setEnabled(true);
        this.add(jTable1);
        this.add(type);
        this.add(jScrollPane1);
        this.add(jScrollPane2);
    }


    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void changeHeader(int number, String value)
    {
        JTableHeader th = jTable1.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(number);
        tc.setHeaderValue( value );
    }
    private void addingColumns( ArrayList<String> names)
    {
       /* tableModel = new DefaultTableModel(new Object[] { "Initial Column" }, number);
        for (int i=1 ;i<number;++i) {
            TableColumn c1 = new TableColumn();
            tableModel.addColumn(c1);
            changeHeader(jTable1.getColumnCount()-1,names[i]);
        }

        */
        String [] tableData2=new String[tableData.size()];
        for (int i=0 ; i<tableData2.length ;++i)
            tableData2[i]=tableData.get(i);

        if (i==0)
        {
            ++i;
            tableData.removeAll(tableData);
            return;
        }
        addProductsTable table=new addProductsTable(tableData2);
        tableData.removeAll(tableData);

    }
    // Variables declaration - do not modify

    private javax.swing.JTextField brand_txt;
    private javax.swing.JLabel category_lbl;
    private javax.swing.JComboBox<String> category_type;
    private javax.swing.JLabel error_txt;
    private javax.swing.JLabel info_lbl;
    private javax.swing.JTextArea info_txt;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel money_lbl;
    private javax.swing.JTextField monry_txt;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JTextField name_txt;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JTextField price_txt;
    private javax.swing.JToggleButton submit_btn;
    private javax.swing.JLabel brand_lbl;
    DefaultTableModel tableModel;
    // End of variables declaration
}
