package Firmi;

import com.company.Main;

import javax.swing.*;

public class FirmaAdd extends JFrame {
    JFrame firmadd = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    public FirmaAdd(){
        background.setBounds(0, 0, 700, 450);

        firmadd.add(background);

        firmadd.setLayout(null);
        firmadd.setTitle("Добави фирма");
        firmadd.setSize(700, 450);
        firmadd.setLocationRelativeTo(null);
        firmadd.setDefaultCloseOperation(EXIT_ON_CLOSE);
        firmadd.setVisible(true);
    }
    public static void main(String s[]) {
        Main gui = new Main();
    }
}
