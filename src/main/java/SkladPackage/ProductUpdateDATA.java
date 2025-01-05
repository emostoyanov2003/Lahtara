package SkladPackage;


import com.company.FileActions;
import com.company.Main;
import com.company.ProductAdd;
import com.company.Sklad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductUpdateDATA extends JFrame {
    JFrame addpanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JLabel marka = new JLabel();
    JLabel model = new JLabel();
    JLabel QTY = new JLabel();
    JLabel code = new JLabel();
    JLabel dostcena = new JLabel();
    JLabel bezdds = new JLabel();
    //JLabel ddsgroup = new JLabel();
    public static JTextField markaenter = new JTextField();
    public static JTextField modelenter = new JTextField();
    public static JTextField QTYenter = new JTextField();
    public static JTextField codeenter = new JTextField();
    public static JTextField dostcenaenter = new JTextField();
    public static JTextField bezddsenter = new JTextField();

    String [] vidove = {"330 мл.", "500 мл."};
    JComboBox butilka = new JComboBox(vidove);

    JLabel addbtn = new JLabel(new ImageIcon("buttons/productchangebtn.png"));


    ProductUpdateDATA(){
        /*final DefaultComboBoxModel modelmenu = new DefaultComboBoxModel();
        final JComboBox ddschose = new JComboBox(modelmenu);
        background.add(ddschose);
        ddschose.setBounds(140, 325, 50, 30);
        modelmenu.addElement("9%");
        modelmenu.addElement("20%");*/

        background.setBounds(0, 0, 700, 450);
        title.setBounds(0, 0, 700, 25);
        x.setBounds(675, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addpanel.dispose();
                Sklad sklad = new Sklad();
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

        header.setText("ПРОМЕНИ ПРОДУКТ");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setBounds(0, 45, 700, 25);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        marka.setText("Производител/Марка:");
        marka.setFont(new Font("Arial", Font.BOLD, 15));
        marka.setBounds(80, 90, 400, 40);
        marka.setForeground(Color.WHITE);

        model.setText("Модел:");
        model.setFont(new Font("Arial", Font.BOLD, 15));
        model.setBounds(80, 130, 400, 40);
        model.setForeground(Color.WHITE);

        QTY.setText("Количество:");
        QTY.setFont(new Font("Arial", Font.BOLD, 15));
        QTY.setBounds(80, 170, 400, 40);
        QTY.setForeground(Color.WHITE);

        butilka.setBounds(325, 175, 90, 25);
        butilka.setFont(new Font("Arial", Font.BOLD, 15));

        code.setText("Баркод:");
        code.setFont(new Font("Arial", Font.BOLD, 15));
        code.setBounds(80, 210, 400, 40);
        code.setForeground(Color.WHITE);

        dostcena.setText("Доставна цена:");
        dostcena.setFont(new Font("Arial", Font.BOLD, 15));
        dostcena.setBounds(80, 250, 400, 40);
        dostcena.setForeground(Color.WHITE);

        bezdds.setText("Цена (БЕЗ ДДС):");
        bezdds.setFont(new Font("Arial", Font.BOLD, 15));
        bezdds.setBounds(80, 290, 400, 40);
        bezdds.setForeground(Color.WHITE);

        /*ddsgroup.setText("ДДС група");
        ddsgroup.setFont(new Font("Arial", Font.BOLD, 15));
        ddsgroup.setBounds(20, 320, 400, 40);
        ddsgroup.setForeground(Color.WHITE);*/

        markaenter.setBounds(260, 95, 300, 25);
        markaenter.setFont(new Font("Arial", Font.BOLD, 20));

        modelenter.setBounds(260, 135, 300, 25);
        modelenter.setFont(new Font("Arial", Font.BOLD, 20));

        QTYenter.setBounds(260, 175, 50, 25);
        QTYenter.setFont(new Font("Arial", Font.BOLD, 20));

        codeenter.setBounds(260, 215, 300, 25);
        codeenter.setFont(new Font("Arial", Font.BOLD, 20));

        dostcenaenter.setBounds(260, 255, 70, 25);
        dostcenaenter.setFont(new Font("Arial", Font.BOLD, 20));

        bezddsenter.setBounds(260, 295, 70, 25);
        bezddsenter.setFont(new Font("Arial", Font.BOLD, 20));

        addbtn.setBounds(230, 360, 213, 64);
        addbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (markaenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведена марка.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (modelenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведен модел.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (QTYenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведено количество.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (codeenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведен код.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (dostcenaenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведена доставна цена.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else if (bezddsenter.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Няма въведена цена.","Грешка", JOptionPane.ERROR_MESSAGE);
                } else {
                    String marka = markaenter.getText();
                    String model = modelenter.getText();
                    String[] options = new String[2];
                    options[0] = new String("Потвърди");
                    options[1] = new String("Откажи");
                    int confirm = JOptionPane.showOptionDialog(addpanel.getContentPane(), "Потвърдете промяната на продукта", "Промяна на продукт", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                    if (confirm == JOptionPane.YES_OPTION) {
                        int id = Integer.parseInt(ProductUpdate.id2.getText());
                        String element = (String) butilka.getSelectedItem();
                        FileActions.updateProduct(markaenter.getText(), modelenter.getText(), QTYenter.getText(), dostcenaenter.getText(), bezddsenter.getText(), codeenter.getText(), element, id);
                        JOptionPane.showMessageDialog(null, "Успешно променихте продукт.");
                        addpanel.dispose();
                        new Sklad();

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

        addpanel.add(title);
        title.add(x);
        addpanel.add(background);
        background.add(header);
        background.add(marka);
        background.add(model);
        background.add(QTY);
        background.add(code);
        background.add(dostcena);
        background.add(bezdds);
        //background.add(ddsgroup);
        background.add(markaenter);
        background.add(modelenter);
        background.add(QTYenter);
        background.add(codeenter);
        background.add(dostcenaenter);
        background.add(bezddsenter);
        background.add(addbtn);
        background.add(butilka);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        addpanel.setIconImage(icon);
        addpanel.setLayout(null);
        addpanel.setTitle("Нов продукт");
        addpanel.setUndecorated(true);
        addpanel.setSize(700, 450);
        addpanel.setLocationRelativeTo(null);
        addpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addpanel.setVisible(true);
    }
    public static void main(String s[]) { Main gui = new Main();}
}
