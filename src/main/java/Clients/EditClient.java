package Clients;



import com.company.Main;
import com.company.Sklad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditClient extends JFrame {
    JFrame updatepanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JLabel marka = new JLabel();
    JLabel model = new JLabel();

    JLabel addbtn = new JLabel(new ImageIcon("buttons/productchangebtn.png"));
    JLabel editbtn = new JLabel(new ImageIcon("buttons/productchangebtn.png"));
    //Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public static int id;

    public void comboMarka () {
        final DefaultComboBoxModel modelmenu = new DefaultComboBoxModel();
        final JComboBox markachose = new JComboBox(modelmenu);
        background.add(markachose);
        markachose.setBounds(140, 85, 200, 30);


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


        addbtn.setBounds(90, 130, 213, 64);
        addbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String ime = "";
                String tellephone = "";
                String email = "";
                String cardnumber = "";
                String orders = "";
                String element = (String) modelmenu.getSelectedItem();
                if (element==element){
                    new EditClientDATA();
                    updatepanel.dispose();
                    String sql = "SELECT * FROM clients WHERE name = ?";
                    try {
                        String url = "jdbc:mysql://localhost:3306/lahtara";
                        String user = "root";
                        String password = "";

                        Connection conn = DriverManager.getConnection(url, user, password);

                        pst = conn.prepareStatement(sql);
                        pst.setString(1 ,element);
                        rs = pst.executeQuery();
                        while (rs.next()) {
                            if(rs.getString("name").equals(element)){
                                id = rs.getInt("id");
                                ime = rs.getString("name");
                                tellephone = rs.getString("tellephone");
                                email = rs.getString("email");
                                cardnumber = rs.getString("cardnumber");
                                orders = rs.getString("orders");
                                EditClientDATA.fnameenter.setText(ime);
                                EditClientDATA.phoneenter.setText(tellephone);
                                EditClientDATA.emailenter.setText(email);
                                EditClientDATA.nomerenter.setText(cardnumber);
                                EditClientDATA.ordersenter.setText(orders);
                            }
                        }
                    } catch (Exception a) {

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




    public EditClient(){
        comboMarka();
        background.setBounds(0, 0, 400, 200);
        title.setBounds(0, 0, 400, 25);
        x.setBounds(375, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updatepanel.dispose();
                new Sklad();
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

        header.setText("ИЗБЕРИ КЛИЕНТ");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setBounds(0, 30, 400, 40);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        marka.setText("Клиент:");
        marka.setFont(new Font("Arial", Font.BOLD, 18));
        marka.setBounds(50, 80, 150, 40);
        marka.setForeground(Color.WHITE);


        updatepanel.add(title);
        title.add(x);
        updatepanel.add(background);
        background.add(header);
        background.add(marka);
        background.add(model);
        background.add(addbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        updatepanel.setIconImage(icon);
        updatepanel.setLayout(null);
        updatepanel.setTitle("Промени клиент");
        updatepanel.setUndecorated(true);
        updatepanel.setSize(400, 200);
        updatepanel.setLocationRelativeTo(null);
        updatepanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updatepanel.setVisible(true);


    }
    public static void main(String s[]) { Main gui = new Main();}

}
