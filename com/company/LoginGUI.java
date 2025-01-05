package com.company;

import ForgotPass.ForgotPassword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginGUI extends JFrame {
    JFrame panel = new JFrame();
    JLabel snimka = new JLabel(new ImageIcon("background.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JLabel usertext = new JLabel();
    JLabel pass = new JLabel();
    JPasswordField passenter = new JPasswordField();
    JTextField userenter = new JTextField();
    JLabel forgotpass = new JLabel();

    JLabel loginbtn = new JLabel(new ImageIcon("buttons/login.png"));

    LoginGUI(){
        snimka.setBounds(0, 0, 350, 300);
        title.setBounds(0, 0, 350, 25);
        x.setBounds(325, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(JFrame.EXIT_ON_CLOSE);
            }
        });

        header.setText("Влезте в системата");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBounds(75, 60, 250, 30);
        header.setForeground(Color.WHITE);

        usertext.setText("Username: ");
        usertext.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        usertext.setBounds(25, 100, 250, 30);
        usertext.setForeground(Color.WHITE);

        pass.setText("Парола: ");
        pass.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        pass.setBounds(25, 130, 250, 30);
        pass.setForeground(Color.WHITE);

        passenter = new JPasswordField();
        passenter.setBounds(135,140, 150, 20);

        userenter = new JTextField();
        userenter.setBounds(135,100, 150, 20);

        loginbtn.setBounds(60,170, 213, 64);
        loginbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainWindow mainWindow = new MainWindow();
                /*String us = userenter.getText();
                String pass = String.valueOf(passenter.getPassword());
                if (FileActions.account(us, pass)) {
                    JOptionPane.showMessageDialog(null, "Усшено влязохте в системата, " +us);
                    panel.dispose();
                    MainWindow baseWindow = new MainWindow();
                } else {
                    JOptionPane.showMessageDialog(null, "Грешно име или парола.");
                }*/
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                snimka.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                snimka.setCursor(cursor);
            }
        });

        forgotpass.setText("ЗАБРАВЕНА ПАРОЛА");
        forgotpass.setFont(new Font("Arial", Font.BOLD, 10));
        forgotpass.setBounds(0, 235, 350, 25);
        forgotpass.setForeground(Color.WHITE);
        forgotpass.setHorizontalAlignment(SwingConstants.CENTER);
        forgotpass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ForgotPassword();
                panel.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                forgotpass.setForeground(Color.GREEN);
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                snimka.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgotpass.setForeground(Color.WHITE);
                Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                snimka.setCursor(cursor);
            }
        });
        snimka.add(forgotpass);

        panel.add(title);
        title.add(x);
        panel.add(snimka);
        snimka.add(header);
        snimka.add(userenter);
        snimka.add(passenter);
        snimka.add(pass);
        snimka.add(usertext);
        snimka.add(loginbtn);

        panel.setLayout(null);
        panel.add(snimka);
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        panel.setIconImage(icon);
        panel.setUndecorated(true);
        panel.setTitle("Влезте в системата");
        panel.setSize(350, 260);
        panel.setLocationRelativeTo(null);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setVisible(true);
    }

}
