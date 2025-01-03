package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import SkladPackage.ProductUpdate;
import com.company.*;
import static com.company.MainWindow.basepanel;

public class Sklad extends JFrame {
    JFrame skladpanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();

    JLabel add = new JLabel(new ImageIcon("buttons/productaddbtn.png"));
    JLabel update = new JLabel(new ImageIcon("buttons/productchangebtn.png"));
    JLabel check = new JLabel(new ImageIcon("buttons/checkqtybtn.png"));
    JLabel addStoka = new JLabel(new ImageIcon("buttons/stokaadd.png"));

    public Sklad(){
        background.setBounds(0, 0, 400, 400);
        title.setBounds(0, 0, 400, 25);
        x.setBounds(375, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skladpanel.dispose();
                basepanel.setState(JFrame.NORMAL);
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

        header.setText("СКЛАД ЛАХТАРА");
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setBounds(0, 40, 400, 40);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        add.setBounds(85, 120, 213, 64);
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skladpanel.dispose();
                basepanel.setState(JFrame.ICONIFIED);
                ProductAdd productAdd = new ProductAdd();
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

        check.setBounds(85, 180, 213, 64);
        check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CheckQTY checkQTY = new CheckQTY();
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

        update.setBounds(85, 240, 213, 64);
        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skladpanel.dispose();
                ProductUpdate productUpdate = new ProductUpdate();
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

        addStoka.setBounds(85, 300, 213, 64);
        addStoka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skladpanel.dispose();
                AddStoka addStoka = new AddStoka();
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


        skladpanel.add(title);
        title.add(x);
        skladpanel.add(background);
        background.add(header);
        background.add(add);
        background.add(check);
        background.add(update);
        background.add(addStoka);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        skladpanel.setIconImage(icon);
        skladpanel.setLayout(null);
        skladpanel.setTitle("Склад");
        skladpanel.setUndecorated(true);
        skladpanel.setSize(400, 400);
        skladpanel.setLocationRelativeTo(null);
        skladpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        skladpanel.setVisible(true);
    }
    public static void main(String s[]) { Main gui = new Main();}
}
