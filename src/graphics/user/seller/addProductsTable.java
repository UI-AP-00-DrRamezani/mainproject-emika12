package graphics.user.seller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addProductsTable {

    String [] columnNames;
    String [] newData;
    //String [][] data;
    // frame
    JFrame frame;
    // Table
    JTable table;

    // Constructor
    addProductsTable(String [] columnNames )
    {
        this.columnNames=columnNames;
        initComponents();

    }

    public void initComponents()
    {

        String [][]data=new String[1][columnNames.length];
        // Frame initialization
        frame = new JFrame();

        frame.setLocationRelativeTo(null); //make it center
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        // Frame Title
        frame.setTitle("JTable Example");


        // Initializing the JTable
        table = new JTable(data ,columnNames );
        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);

        JButton submit=new JButton("submit");
        submit.setBounds(60, 60, 120, 50);
        submit.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         try {
                                             getTheValues();
                                             frame.dispose();
                                         }catch (Exception a)
                                         {
                                             submit.setText("fill all blanks");
                                             submit.setBackground(Color.red);
                                         }

                                     }
                                 });

        frame.add(submit);
        frame.add(sp);
        // Frame Size
        frame.setSize(500, 200);

        // Frame Visible = true
        frame.setVisible(true);
    }

    private void getTheValues()
    {
        newData=new String[columnNames.length];
        for (int i=0 ; i<columnNames.length ;++i)
        {
            newData[i]=table.getValueAt(0, i).toString();
        }
        addProduct.data=newData;
    }

    // Driver method
    public static void main(String[] args)
    {
        String[] data = {
                 "Kundan Kumar Jha", "4031", "CSE" ,
                 "Anand Jha", "6014", "IT"
        };
        new addProductsTable(data);
    }


}

