package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckQTY extends JFrame {
    JFrame checkqtypanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel header = new JLabel();
    JLabel marka = new JLabel();
    JLabel model = new JLabel();
    JLabel QTY = new JLabel();
    JTextField markaenter = new JTextField();
    JTextField modelenter = new JTextField();
    JTextField QTYenter = new JTextField();
    JButton addbtn = new JButton();
    JButton allbtn = new JButton();

    //Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void comboMarka () {
        final DefaultComboBoxModel modelmenu = new DefaultComboBoxModel();
        final JComboBox markachose = new JComboBox(modelmenu);
        background.add(markachose);
        markachose.setBounds(120, 75, 200, 30);

        String sql = "SELECT * FROM products";
        try {
            String url = "jdbc:mysql://localhost:3306/lahtara";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                modelmenu.addElement(rs.getString("ime"));
            }
        } catch (Exception a) {

        }
        addbtn.setText("За избрания продукт");
        addbtn.setBounds(70, 120, 250, 30);
        addbtn.setFont(new Font("Arial", Font.BOLD, 15));
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = (String)modelmenu.getSelectedItem();
                FileActions.checkQTY(element);
                JOptionPane.showMessageDialog(null, "Продукт: **"+element+"**\nНаличност: **"+FileActions.qtyproduct+"**");

            }
        });
        background.add(addbtn);

        allbtn.setText("За всички продукти");
        allbtn.setBounds(70, 160, 250, 30);
        allbtn.setFont(new Font("Arial", Font.BOLD, 15));
        allbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckQTYAll checkQTYAll = new CheckQTYAll();
            }
        });
        background.add(allbtn);
    }




    public CheckQTY(){
        comboMarka();
        background.setBounds(0, 0, 400, 250);

        header.setText("ПРОВЕРИ НАЛИЧНОСТ");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBounds(80, 20, 400, 40);
        header.setForeground(Color.WHITE);

        marka.setText("Модел:");
        marka.setFont(new Font("Arial", Font.BOLD, 18));
        marka.setBounds(20, 70, 400, 40);
        marka.setForeground(Color.WHITE);


        checkqtypanel.add(background);
        background.add(header);
        background.add(marka);
        background.add(model);
        background.add(QTY);
        //background.add(markaenter);
        background.add(modelenter);
        background.add(QTYenter);
        background.add(addbtn);

        checkqtypanel.setLayout(null);
        checkqtypanel.setTitle("Провери наличност");
        checkqtypanel.setSize(400, 250);
        checkqtypanel.setLocationRelativeTo(null);
        checkqtypanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkqtypanel.setVisible(true);


    }
    public static void main(String s[]) { Main gui = new Main();}


}
