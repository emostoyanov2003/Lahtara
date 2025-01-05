package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddStoka extends JFrame {

    JFrame stokapanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JLabel marka = new JLabel();
    JLabel QTY = new JLabel();
    JTextField QTYenter = new JTextField();

    JLabel addbtn = new JLabel(new ImageIcon("buttons/stokaadd.png"));


    PreparedStatement pst = null;
    ResultSet rs = null;

    public void comboMarka () {
        final DefaultComboBoxModel modelmenu = new DefaultComboBoxModel();
        final JComboBox markachose = new JComboBox(modelmenu);
        background.add(markachose);
        markachose.setBounds(135, 85, 200, 30);

        String sql = "SELECT * FROM products";
        try {
            String url = "jdbc:mysql://localhost:3306/lahtara";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String ime = rs.getString("ime");
                modelmenu.addElement(ime);
            }
        } catch (Exception a) {

        }
        addbtn.setBounds(90, 170, 213, 64);
        addbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (QTYenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведено количество.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else {
                    String[] options = new String[2];
                    options[0] = new String("Потвърди");
                    options[1] = new String("Откажи");
                    int confirm = JOptionPane.showOptionDialog(stokapanel.getContentPane(), "Потвърдете добавянето на стока.", "Добавяне на стока.", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                    if (confirm == JOptionPane.YES_OPTION) {
                        String element = (String)modelmenu.getSelectedItem();
                        FileActions.addStoka(QTYenter.getText(), element);
                        JOptionPane.showMessageDialog(null, "Успешно добавихте стока.", "Успешно добавяне на стока.", JOptionPane.INFORMATION_MESSAGE);
                        stokapanel.dispose();
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                background.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                background.setCursor(cursor);
            }
        });
        background.add(addbtn);
    }
    public AddStoka(){
        comboMarka();
        background.setBounds(0, 0, 400, 250);
        title.setBounds(0, 0, 400, 25);
        x.setBounds(375, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stokapanel.dispose();
                Sklad sklad = new Sklad();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                title.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                title.setCursor(cursor);
            }
        });

        header.setText("ЗАРЕДИ СТОКА");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setBounds(0, 30, 400, 40);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        marka.setText("Модел:");
        marka.setFont(new Font("Arial", Font.BOLD, 18));
        marka.setBounds(50, 80, 400, 40);
        marka.setForeground(Color.WHITE);

        QTY.setText("Количество:");
        QTY.setFont(new Font("Arial", Font.BOLD, 15));
        QTY.setBounds(50, 120, 400, 40);
        QTY.setForeground(Color.WHITE);

        QTYenter.setBounds(150, 125, 45, 25);


        stokapanel.add(title);
        title.add(x);
        stokapanel.add(background);
        background.add(header);
        background.add(marka);
        background.add(QTY);
        background.add(QTYenter);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        stokapanel.setIconImage(icon);
        stokapanel.setLayout(null);
        stokapanel.setTitle("Промени продукт");
        stokapanel.setUndecorated(true);
        stokapanel.setSize(400, 250);
        stokapanel.setLocationRelativeTo(null);
        stokapanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stokapanel.setVisible(true);


    }
    public static void main(String s[]) { Main gui = new Main();}
}
