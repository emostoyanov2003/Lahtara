package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount extends JFrame {
    JFrame accountpanel = new JFrame();
    JLabel snimka = new JLabel(new ImageIcon("background2.png"));
    JLabel header = new JLabel();
    JLabel usertext = new JLabel();
    JLabel ime = new JLabel();
    JLabel familiq = new JLabel();
    JLabel pass = new JLabel();
    JLabel emailtext = new JLabel();
    JTextField userenter = new JTextField();
    JTextField fnameenter = new JTextField();
    JTextField lnameenter = new JTextField();
    JTextField emailenter = new JTextField();
    JPasswordField passenter = new JPasswordField();
    JButton createbtn = new JButton();
    JButton cancelbtn = new JButton();

    CreateAccount(){
        snimka.setBounds(0, 0, 350, 300);

        header.setText("Създайте акаунт");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBounds(75, 20, 250, 30);
        header.setForeground(Color.WHITE);

        usertext.setText("Username: ");
        usertext.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        usertext.setBounds(25, 60, 250, 30);
        usertext.setForeground(Color.WHITE);

        ime.setText("Име: ");
        ime.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        ime.setBounds(25, 90, 250, 30);
        ime.setForeground(Color.WHITE);

        familiq.setText("Фамилия: ");
        familiq.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        familiq.setBounds(25, 120, 250, 30);
        familiq.setForeground(Color.WHITE);

        pass.setText("Парола: ");
        pass.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        pass.setBounds(25, 150, 250, 30);
        pass.setForeground(Color.WHITE);

        emailtext.setText("e-mail: ");
        emailtext.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        emailtext.setBounds(25, 180, 250, 30);
        emailtext.setForeground(Color.WHITE);

        userenter = new JTextField();
        userenter.setBounds(135,60, 150, 20);

        passenter = new JPasswordField();
        passenter.setBounds(135,150, 150, 20);

        fnameenter = new JTextField();
        fnameenter.setBounds(135,90, 150, 20);

        lnameenter = new JTextField();
        lnameenter.setBounds(135,120, 150, 20);

        emailenter = new JTextField();
        emailenter.setBounds(135,180, 150, 20);

        createbtn.setBounds(55,210, 100, 30);
        createbtn.setText("Създай");
        createbtn.setFont(new Font("Arial", Font.BOLD, 15));
        createbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(accountpanel.getContentPane(), "Потвърждавате ли създаването на акаунт?", "Потвърждаване",0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
                if (confirm == JOptionPane.YES_OPTION){
                    FileActions.insertAccount(userenter.getText(), passenter.getText(),fnameenter.getText(), lnameenter.getText(), emailenter.getText());
                    JOptionPane.showMessageDialog(null, "Успешно създадохте акаунт");
                    accountpanel.dispose();
                }
            }
        });

        cancelbtn.setBounds(165,210, 100, 30);
        cancelbtn.setText("Откажи");
        cancelbtn.setFont(new Font("Arial", Font.BOLD, 15));
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(accountpanel.getContentPane(), "Желаете ли да откажете създаването на акаунт?", "Отказ на създаване на акаунта",0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
                if (confirm == JOptionPane.YES_OPTION){
                    accountpanel.dispose();
                }
            }
        });




        accountpanel.add(snimka);
        snimka.add(header);
        snimka.add(usertext);
        snimka.add(ime);
        snimka.add(familiq);
        snimka.add(pass);
        snimka.add(emailtext);
        snimka.add(userenter);
        snimka.add(emailenter);
        snimka.add(passenter);
        snimka.add(createbtn);
        snimka.add(cancelbtn);
        snimka.add(fnameenter);
        snimka.add(lnameenter);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        accountpanel.setIconImage(icon);
        accountpanel.setLayout(null);
        accountpanel.add(snimka);
        accountpanel.setTitle("Създайте акаунт");
        accountpanel.setSize(350, 300);
        accountpanel.setLocationRelativeTo(null);
        accountpanel.setDefaultCloseOperation(0);
        accountpanel.setVisible(true);
    }
}
