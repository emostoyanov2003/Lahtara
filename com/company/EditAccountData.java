package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAccountData extends JFrame {
    JFrame accountpanel = new JFrame();
    JLabel snimka = new JLabel(new ImageIcon("background2.png"));
    JLabel header = new JLabel();
    JLabel newusertext = new JLabel();
    JLabel usertext = new JLabel();
    JLabel pass = new JLabel();
    JLabel emailtext = new JLabel();
    JTextField userenter = new JTextField();
    JTextField newuserenter = new JTextField();
    JTextField emailenter = new JTextField();
    JPasswordField passenter = new JPasswordField();
    JButton createbtn = new JButton();
    JButton cancelbtn = new JButton();

    EditAccountData(){
        snimka.setBounds(0, 0, 350, 300);

        header.setText("Промени акаунт");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBounds(75, 20, 250, 30);
        header.setForeground(Color.WHITE);

        usertext.setText("Стар username: ");
        usertext.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        usertext.setBounds(25, 60, 250, 30);
        usertext.setForeground(Color.WHITE);

        newusertext.setText("Нов username: ");
        newusertext.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        newusertext.setBounds(25, 100, 250, 30);
        newusertext.setForeground(Color.WHITE);

        pass.setText("Парола: ");
        pass.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        pass.setBounds(25, 145, 250, 30);
        pass.setForeground(Color.WHITE);

        emailtext.setText("e-mail: ");
        emailtext.setFont(new Font("Arial", Font.BOLD, 15)); //Задава фон, тип и размер на надписа
        emailtext.setBounds(25, 185, 250, 30);
        emailtext.setForeground(Color.WHITE);

        userenter.setBounds(135,60, 150, 20);

        newuserenter.setBounds(135,100, 150, 20);

        passenter.setBounds(135,140, 150, 20);

        emailenter.setBounds(135,180, 150, 20);

        createbtn.setBounds(55,220, 100, 30);
        createbtn.setText("Промени");
        createbtn.setFont(new Font("Arial", Font.BOLD, 15));
        createbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(accountpanel.getContentPane(), "Потвърждавате ли промяната на акаунт?", "Потвърждаване",0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
                if (confirm == JOptionPane.YES_OPTION){
                    FileActions.updateAccount(newuserenter.getText(), passenter.getText(), emailenter.getText(), userenter.getText());
                    JOptionPane.showMessageDialog(null, "Успешно променихте акаунт");
                    accountpanel.dispose();
                }
            }
        });

        cancelbtn.setBounds(165,220, 100, 30);
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
        snimka.add(pass);
        snimka.add(emailtext);
        snimka.add(userenter);
        snimka.add(newusertext);
        snimka.add(newuserenter);
        snimka.add(emailenter);
        snimka.add(passenter);
        snimka.add(createbtn);
        snimka.add(cancelbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        accountpanel.setIconImage(icon);
        accountpanel.setLayout(null);
        accountpanel.add(snimka);
        accountpanel.setSize(350, 300);
        accountpanel.setLocationRelativeTo(null);
        accountpanel.setDefaultCloseOperation(0);
        accountpanel.setVisible(true);
    }
}
