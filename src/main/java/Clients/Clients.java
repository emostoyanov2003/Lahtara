package Clients;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Clients extends JFrame {
    JFrame clientpanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();

    JLabel addclientbtn = new JLabel(new ImageIcon("buttons/addclient.png"));
    JLabel checkclientbtn = new JLabel(new ImageIcon("buttons/checkclientbtn.png"));
    JButton editclientbtn = new JButton();



    public Clients(){
        background.setBounds(0, 0, 400, 400);
        title.setBounds(0, 0, 400, 25);

        x.setBounds(375, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientpanel.dispose();
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

        header.setText("КЛИЕНТИ");
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setBounds(0, 40, 400, 40);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        addclientbtn.setBounds(85, 120, 213, 64);
        addclientbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddClient addClient = new AddClient();
                clientpanel.dispose();
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

        checkclientbtn.setBounds(85, 180, 213, 64);
        checkclientbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CheckClient checkClient = new CheckClient();
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

        editclientbtn.setBounds(85, 240, 213, 64);
        editclientbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new EditClient();
                clientpanel.dispose();
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
        background.add(editclientbtn);


        clientpanel.add(title);
        title.add(x);
        clientpanel.add(background);
        background.add(header);
        background.add(addclientbtn);
        background.add(checkclientbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        clientpanel.setIconImage(icon);
        clientpanel.setLayout(null);
        clientpanel.setTitle("Клиенти");
        clientpanel.setUndecorated(true);
        clientpanel.setSize(400, 400);
        clientpanel.setLocationRelativeTo(null);
        clientpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientpanel.setVisible(true);
    }
    public static void main(String s[]) {
        Main gui = new Main();
    }
}
