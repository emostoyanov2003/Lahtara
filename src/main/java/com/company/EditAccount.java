package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditAccount extends JFrame {
    JFrame editaccountpanel = new JFrame();
    JLabel snimka = new JLabel(new ImageIcon("background2.png"));
    JLabel header = new JLabel();
    JLabel usertext = new JLabel();
    JTextField userenter = new JTextField();
    JButton chosebtn = new JButton();
    JButton cancelbtn = new JButton();
    JButton deletebtn = new JButton();

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void comboAccount () {
        final DefaultComboBoxModel usermenu = new DefaultComboBoxModel();
        final JComboBox userchose = new JComboBox(usermenu);
        snimka.add(userchose);
        userchose.setBounds(130, 60, 170, 30);

        String sql = "SELECT * FROM account";
        try {
            String url = "jdbc:mysql://localhost:3306/lahtara";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                usermenu.addElement(rs.getString("username"));
            }
        } catch (Exception a) {

        }
        chosebtn.setBounds(25,120, 100, 30);
        chosebtn.setText("Избери");
        chosebtn.setFont(new Font("Arial", Font.BOLD, 15));
        chosebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = (String)usermenu.getSelectedItem();
                if (FileActions.accuser(element)) {
                    editaccountpanel.dispose();
                    EditAccountData editAccountData = new EditAccountData();
                }
            }
        });
        snimka.add(chosebtn);

        deletebtn.setBounds(245,120, 100, 30);
        deletebtn.setText("Изтрий акаунт");
        deletebtn.setFont(new Font("Arial", Font.BOLD, 15));
        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = (String)usermenu.getSelectedItem();
                FileActions.deleteAccount(element);
                if (FileActions.deleteAccount(element)) {
                    String[] options = new String[2];
                    options[0] = new String("Да");
                    options[1] = new String("Не");
                    int confirm = JOptionPane.showOptionDialog(editaccountpanel.getContentPane(), "Желаете ли да изтриете акаунт с username " +element, "Отказ на променяне на акаунта",0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
                    if (confirm == JOptionPane.YES_OPTION){
                        FileActions.deleteAccount(element);
                        editaccountpanel.dispose();

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Не съществува акаунт с такъв username");
                }
            }
        });
        snimka.add(deletebtn);
    }

    EditAccount(){
        comboAccount();

        snimka.setBounds(0, 0, 400, 300);

        header.setText("Променете акаунт");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBounds(80, 20, 250, 30);
        header.setForeground(Color.WHITE);

        usertext.setText("Username: ");
        usertext.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        usertext.setBounds(40, 60, 250, 30);
        usertext.setForeground(Color.WHITE);

        //userenter.setBounds(125,60, 150, 20);


        cancelbtn.setBounds(135,120, 100, 30);
        cancelbtn.setText("Откажи");
        cancelbtn.setFont(new Font("Arial", Font.BOLD, 15));
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(editaccountpanel.getContentPane(), "Желаете ли да откажете променянето на акаунт?", "Отказ на променяне на акаунта",0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
                if (confirm == JOptionPane.YES_OPTION){
                    editaccountpanel.dispose();
                }
            }
        });

        editaccountpanel.add(snimka);
        snimka.add(header);
        snimka.add(usertext);
        //snimka.add(userenter);
        snimka.add(cancelbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        editaccountpanel.setIconImage(icon);
        editaccountpanel.setLayout(null);
        editaccountpanel.add(snimka);
        editaccountpanel.setSize(400, 200);
        editaccountpanel.setLocationRelativeTo(null);
        editaccountpanel.setDefaultCloseOperation(0);
        editaccountpanel.setVisible(true);
    }
}
