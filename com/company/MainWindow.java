package com.company;

import Faktura.Faktura;
import Otchet.Otchet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Clients.*;


public class MainWindow extends JFrame {
    public static JFrame basepanel = new JFrame();
    JLabel snimka = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JLabel unheader = new JLabel();

    JLabel salebutton = new JLabel(new ImageIcon("buttons/Sale.png"));
    JLabel skladbtn = new JLabel(new ImageIcon("buttons/skladbtn.png"));
    JLabel otchetbtn = new JLabel(new ImageIcon("buttons/otchetbtn.png"));
    JLabel logoffbtn = new JLabel(new ImageIcon("buttons/accexit.png"));
    JLabel clientsbtn = new JLabel(new ImageIcon("buttons/clients.png"));
    JLabel settingsbtn = new JLabel(new ImageIcon("buttons/settings.png"));
    JLabel fakturabtn = new JLabel(new ImageIcon("buttons/faktura.png"));



    MainWindow(){
        snimka.setBounds(0, 0, 750, 500);
        title.setBounds(0, 0, 750, 25);

        x.setBounds(725, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(JFrame.EXIT_ON_CLOSE);
            }
        });

        header.setText("МАГАЗИН ЛАХТАРА");
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setBounds(30, 40, 900, 40);
        header.setForeground(Color.WHITE);

        unheader.setText("Добре дошли в системата");
        unheader.setFont(new Font("Arial", Font.BOLD, 20));
        unheader.setBounds(30, 70, 900, 40);
        unheader.setForeground(Color.WHITE);

        logoffbtn.setBounds(520, 30, 213, 64 );
        logoffbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(basepanel.getContentPane(), "Желаете ли да излезете от акаунта?", "Излизане от акаунта",0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
                if (confirm == JOptionPane.YES_OPTION){
                    basepanel.dispose();
                    LoginGUI loginGUI = new LoginGUI();
                }
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


        settingsbtn.setBounds(520, 430, 213, 64 );
        settingsbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Settings settings = new Settings();
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

        clientsbtn.setBounds(20, 430, 213, 64);
        clientsbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                basepanel.setState(JFrame.ICONIFIED);
                Clients clients = new Clients();
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

        otchetbtn.setBounds(20, 300, 213, 64 );
        otchetbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Otchet otchet = new Otchet();
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


        salebutton.setBounds(20, 120, 213, 64);
        salebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SalePanel salePanel = new SalePanel();
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

        fakturabtn.setBounds(20, 180, 213, 64);
        fakturabtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Faktura faktura = new Faktura();
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
        snimka.add(fakturabtn);

        skladbtn.setBounds(20, 240, 213, 64);
        skladbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sklad sklad = new Sklad();
                basepanel.setState(JFrame.ICONIFIED);
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


        basepanel.add(title);
        title.add(x);
        basepanel.add(snimka);
        snimka.add(header);
        snimka.add(unheader);
        snimka.add(logoffbtn);
        snimka.add(settingsbtn);
        snimka.add(salebutton);
        snimka.add(skladbtn);
        snimka.add(otchetbtn);
        snimka.add(clientsbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        basepanel.setIconImage(icon);
        basepanel.setLayout(null);
        basepanel.setTitle("Начален прозорец");
        basepanel.setUndecorated(true);
        basepanel.setSize(750, 500);
        basepanel.setLocationRelativeTo(null);
        basepanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        basepanel.setVisible(true);
    }
    public static void main(String s[]) {
        Main gui = new Main();
    }
}
