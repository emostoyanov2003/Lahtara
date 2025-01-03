package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Settings extends JFrame {
    JFrame settingspanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();

    JLabel createaccbtn = new JLabel(new ImageIcon("buttons/addaccbtn.png"));
    JLabel editaccbtn = new JLabel(new ImageIcon("buttons/editaccbtn.png"));

    Settings(){
        background.setBounds(0, 0, 400, 400);
        title.setBounds(0, 0, 400, 25);
        x.setBounds(375, 2, 20, 20);
        x.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                settingspanel.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        header.setText("НАСТРОЙКИ");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setBounds(110, 40, 400, 40);
        header.setForeground(Color.WHITE);

        createaccbtn.setBounds(85, 120, 213, 64);
        createaccbtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CreateAccount createAccount = new CreateAccount();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        editaccbtn.setBounds(85, 180, 213, 64);
        editaccbtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditAccount editAccount = new EditAccount();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        settingspanel.add(title);
        title.add(x);
        settingspanel.add(background);
        background.add(header);
        background.add(createaccbtn);
        background.add(editaccbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        settingspanel.setIconImage(icon);
        settingspanel.setLayout(null);
        settingspanel.setTitle("Склад");
        settingspanel.setUndecorated(true);
        settingspanel.setSize(400, 400);
        settingspanel.setLocationRelativeTo(null);
        settingspanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingspanel.setVisible(true);
    }
}
