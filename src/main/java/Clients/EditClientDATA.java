package Clients;

import com.company.FileActions;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditClientDATA extends JFrame {
    JFrame addclientpanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JLabel fname = new JLabel();
    JLabel phone = new JLabel();
    JLabel email = new JLabel();
    JLabel nomer = new JLabel();
    JLabel orders = new JLabel();
    public static JTextField fnameenter = new JTextField();
    public static JTextField phoneenter = new JTextField();
    public static JTextField emailenter = new JTextField();
    public static JTextField nomerenter = new JTextField();
    public static JTextField ordersenter = new JTextField();

    JLabel addbtn = new JLabel(new ImageIcon("buttons/addclient.png"));

    EditClientDATA(){
        background.setBounds(0, 0, 350, 350);
        title.setBounds(0, 0, 350, 25);
        x.setBounds(325, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addclientpanel.dispose();
                new Clients();
            }
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


        header.setText("ПРОМЕНИ КЛИЕНТ");
        header.setFont(new Font("Arial", Font.BOLD, 25));
        header.setBounds(0, 30, 350, 40);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        fname.setText("Име:");
        fname.setFont(new Font("Arial", Font.BOLD, 15));
        fname.setBounds(25, 80, 250, 30);
        fname.setForeground(Color.WHITE);

        phone.setText("Телефон:");
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        phone.setBounds(25, 110, 250, 30);
        phone.setForeground(Color.WHITE);

        email.setText("E-mail:");
        email.setFont(new Font("Arial", Font.BOLD, 15));
        email.setBounds(25, 140, 250, 30);
        email.setForeground(Color.WHITE);

        nomer.setText("Номер на карта:");
        nomer.setFont(new Font("Arial", Font.BOLD, 12));
        nomer.setBounds(25, 170, 250, 30);
        nomer.setForeground(Color.WHITE);

        orders.setText("Поръчки:");
        orders.setFont(new Font("Arial", Font.BOLD, 12));
        orders.setBounds(25, 200, 250, 30);
        orders.setForeground(Color.WHITE);

        fnameenter.setBounds(135,80, 150, 20);

        phoneenter.setBounds(135,110, 150, 20);

        emailenter.setBounds(135,140, 150, 20);

        nomerenter.setBounds(135,170, 150, 20);

        ordersenter.setBounds(135,200, 150, 20);

        addbtn.setBounds(70, 250, 213, 64);
        addbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (fnameenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведено име.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (phoneenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведен телефон.", "Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (phoneenter.getText().matches("^[1-9]")){
                    JOptionPane.showMessageDialog(null, "Телефонният номер трябва да съдържа числа", "Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (emailenter.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Няма въведен имейл.", "Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (nomerenter.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Номерът на картата трябва да съдържа числа.", "Грешка", JOptionPane.ERROR_MESSAGE);
                } else {
                    String[] options = new String[2];
                    options[0] = new String("Потвърди");
                    options[1] = new String("Откажи");
                    int confirm = JOptionPane.showOptionDialog(addclientpanel.getContentPane(), "Потвърдете промяната на клиент?", "Промяна на клиент", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                    if (confirm == JOptionPane.YES_OPTION) {
                        addclientpanel.dispose();
                        JOptionPane.showMessageDialog(null, "Успешно променихте клиент.", "Успешна промяна на клиент", JOptionPane.INFORMATION_MESSAGE);
                        FileActions.updateClient(fnameenter.getText(), phoneenter.getText(), emailenter.getText(), nomerenter.getText(), ordersenter.getText(), EditClient.id);
                        new Clients();

                    }

                }
            }
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

        addclientpanel.add(title);
        title.add(x);
        addclientpanel.add(background);
        background.add(header);
        background.add(fname);
        background.add(phone);
        background.add(email);
        background.add(nomer);
        background.add(orders);
        background.add(fnameenter);
        background.add(ordersenter);
        background.add(phoneenter);
        background.add(emailenter);
        background.add(nomerenter);
        background.add(addbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        addclientpanel.setIconImage(icon);
        addclientpanel.setLayout(null);
        addclientpanel.setTitle("Промени клиент");
        addclientpanel.setUndecorated(true);
        addclientpanel.setSize(350, 350);
        addclientpanel.setLocationRelativeTo(null);
        addclientpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addclientpanel.setVisible(true);
    }
    public static void main(String s[]) { Main gui = new Main();}
}