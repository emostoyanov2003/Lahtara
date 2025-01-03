package Clients;

import com.company.FileActions;
import com.company.Main;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckClient extends JFrame {
    JFrame clientpanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JLabel client = new JLabel();
    JLabel name = new JLabel();
    JLabel phone = new JLabel();
    JLabel email = new JLabel();
    JLabel number = new JLabel();
    JLabel orders = new JLabel();

    JLabel name2 = new JLabel();
    JLabel phone2 = new JLabel();
    JLabel email2= new JLabel();
    JLabel number2 = new JLabel();
    JLabel orders2 = new JLabel();

    JLabel checkbtn = new JLabel(new ImageIcon("buttons/checkclientbtn.png"));


    PreparedStatement pst = null;
    ResultSet rs = null;

    public void comboClient () {
        name2.setText("");
        name2.setFont(new Font("Arial", Font.BOLD, 15));
        name2.setBounds(180, 150, 400, 40);
        name2.setForeground(Color.ORANGE);

        phone2.setText("");
        phone2.setFont(new Font("Arial", Font.BOLD, 15));
        phone2.setBounds(180, 180, 400, 40);
        phone2.setForeground(Color.ORANGE);

        email2.setText("");
        email2.setFont(new Font("Arial", Font.BOLD, 15));
        email2.setBounds(180, 210, 400, 40);
        email2.setForeground(Color.ORANGE);

        number2.setText("");
        number2.setFont(new Font("Arial", Font.BOLD, 15));
        number2.setBounds(180, 240, 400, 40);
        number2.setForeground(Color.ORANGE);

        orders2.setText("");
        orders2.setFont(new Font("Arial", Font.BOLD, 15));
        orders2.setBounds(180, 272, 400, 40);
        orders2.setForeground(Color.ORANGE);

        background.add(name2);
        background.add(phone2);
        background.add(email2);
        background.add(number2);
        background.add(orders2);

        final DefaultComboBoxModel modelmenu = new DefaultComboBoxModel();
        final JComboBox markachose = new JComboBox(modelmenu);
        background.add(markachose);
        markachose.setBounds(130, 75, 200, 30);


        String sql = "SELECT * FROM clients";
        try {
            String url = "jdbc:mysql://localhost:3306/lahtara";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                modelmenu.addElement(rs.getString("name"));

            }
        } catch (Exception a) {

        }


        checkbtn.setBounds(80, 350, 213, 64);
        checkbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String element = (String)modelmenu.getSelectedItem();
                if (FileActions.checkclient(element)){
                    name2.setText(element);
                    phone2.setText(FileActions.clientphone);
                    email2.setText(FileActions.clientmail);
                    number2.setText(FileActions.clientnumber);
                    orders2.setText(FileActions.clientorders);
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
        background.add(checkbtn);

    }

    public CheckClient(){
        comboClient();
        background.setBounds(0, 0, 400, 650);
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


        header.setText("ПРОВЕРИ КЛИЕНТ");
        header.setFont(new Font("Arial", Font.BOLD, 25));
        header.setBounds(0, 30, 400, 40);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        client.setText("Клиент:");
        client.setFont(new Font("Arial", Font.BOLD, 15));
        client.setBounds(50, 70, 400, 40);
        client.setForeground(Color.WHITE);

        name.setText("Име:");
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setBounds(40, 150, 400, 40);
        name.setForeground(Color.WHITE);

        phone.setText("Тел. номер:");
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        phone.setBounds(40, 180, 400, 40);
        phone.setForeground(Color.WHITE);

        email.setText("E-mail:");
        email.setFont(new Font("Arial", Font.BOLD, 15));
        email.setBounds(40, 210, 400, 40);
        email.setForeground(Color.WHITE);

        number.setText("Номер на карта:");
        number.setFont(new Font("Arial", Font.BOLD, 15));
        number.setBounds(40, 240, 400, 40);
        number.setForeground(Color.WHITE);

        orders.setText("Поръчки:");
        orders.setFont(new Font("Arial", Font.BOLD, 15));
        orders.setBounds(40, 270, 400, 40);
        orders.setForeground(Color.WHITE);

        clientpanel.add(title);
        title.add(x);
        clientpanel.add(background);
        background.add(header);
        background.add(client);
        background.add(name);
        background.add(phone);
        background.add(email);
        background.add(number);
        background.add(orders);


        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        clientpanel.setIconImage(icon);
        clientpanel.setLayout(null);
        clientpanel.setTitle("Провери клиент");
        clientpanel.setUndecorated(true);
        clientpanel.setSize(400, 450);
        clientpanel.setLocationRelativeTo(null);
        clientpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clientpanel.setVisible(true);


    }
    public static void main(String s[]) { Main gui = new Main();}
}
