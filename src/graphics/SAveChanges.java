package graphics;

import graphics.user.changeInfo;

public class SAveChanges extends javax.swing.JFrame {

    /**
     * Creates new form SAveChanges
     */
    public SAveChanges() {
        initComponents();
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

        picture = new javax.swing.JLabel();
        Save_lbl = new javax.swing.JLabel();
        submit_b = new javax.swing.JButton();
        cancel_b = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        picture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picture.setIcon(new javax.swing.ImageIcon("C:\\Users\\ES\\Pictures\\project\\3.png")); // NOI18N

        Save_lbl.setForeground(new java.awt.Color(102, 51, 255));
        Save_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Save_lbl.setText("Save changes ?");

        submit_b.setBackground(new java.awt.Color(255, 153, 153));
        submit_b.setText("submit");
        submit_b.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submit_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_bActionPerformed(evt);
            }
        });

        cancel_b.setBackground(new java.awt.Color(153, 153, 255));
        cancel_b.setText("cancel");
        cancel_b.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancel_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_bActionPerformed(evt);
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
                                                .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(Save_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(submit_b, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                                .addComponent(cancel_b, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Save_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(submit_b, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancel_b, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void submit_bActionPerformed(java.awt.event.ActionEvent evt) {
        changeInfo.setSubmitChecked(true);
        this.dispose();
    }

    private void cancel_bActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }


    private javax.swing.JLabel Save_lbl;
    private javax.swing.JButton cancel_b;
    private javax.swing.JLabel picture;
    private javax.swing.JButton submit_b;
    // End of variables declaration
}