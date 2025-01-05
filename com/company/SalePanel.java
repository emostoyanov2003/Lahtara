package com.company;

import Sale.CheckProductsALL;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalePanel extends JFrame{
    public static int a = 1;
    public static double tax;
    public static JFrame salepanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JTable table = new JTable();
    JLabel header = new JLabel();
    JLabel code = new JLabel();
    JLabel client = new JLabel();
    JLabel clienttellephone = new JLabel();
    JLabel clienttellephone1 = new JLabel();
    JLabel clientemail = new JLabel();
    JLabel clientemail1 = new JLabel();
    JLabel clientcardnumber = new JLabel();
    JLabel clientcardnumber1 = new JLabel();
    JLabel clientorders = new JLabel();
    JLabel clientorders1 = new JLabel();
    JLabel addproductheader = new JLabel();
    public static JTextField barcode = new JTextField();
    JLabel productname = new JLabel();
    public static JTextField productname1 = new JTextField();
    JLabel productqty = new JLabel();
    public static JTextField productqty1 = new JTextField();
    JLabel productprice = new JLabel();
    JLabel suma = new JLabel();
    JLabel obshto = new JLabel();
    JLabel obshto2 = new JLabel();
    JLabel resto = new JLabel();
    JLabel resto2 = new JLabel();
    JLabel suma2 = new JLabel();
    JLabel plashtane = new JLabel();
    JTextField plashtane2 = new JTextField();
    JLabel otstypka = new JLabel();
    JLabel otstypka2 = new JLabel();
    JLabel dds = new JLabel();
    JLabel dds2 = new JLabel();

    JTextField ddsfield = new JTextField();

    JLabel biri = new JLabel(new ImageIcon("buttons/biri.png"));
    JLabel biri2 = new JLabel(new ImageIcon("buttons/biri2.png"));
    JLabel bezalk = new JLabel(new ImageIcon("buttons/bezalk.png"));
    JLabel bezalk2 = new JLabel(new ImageIcon("buttons/bezalk2.png"));
    JLabel razni = new JLabel(new ImageIcon("buttons/razni.png"));
    JLabel razni2 = new JLabel(new ImageIcon("buttons/razni2.png"));
    JLabel endsale = new JLabel(new ImageIcon("buttons/endsale.png"));
    JLabel printsale = new JLabel(new ImageIcon("buttons/printsale.png"));
    JLabel removeproduct = new JLabel(new ImageIcon("buttons/removeproduct.png"));
    JLabel moreproduct = new JLabel(new ImageIcon("buttons/moreproducts.png"));
    JLabel addproduct = new JLabel(new ImageIcon("buttons/addproduct.png"));

    JLabel beer1 = new JLabel(new ImageIcon("pics/beer1.png"));
    JLabel beer2 = new JLabel(new ImageIcon("pics/beer2.png"));
    JLabel blackhead = new JLabel(new ImageIcon("pics/blackhead.png"));
    JLabel chaymalko = new JLabel(new ImageIcon("pics/chaymalko.png"));
    JLabel chipa = new JLabel(new ImageIcon("pics/chipa.png"));
    JLabel gingersucker = new JLabel(new ImageIcon("pics/gingersucker.png"));
    JLabel unlackee = new JLabel(new ImageIcon("pics/unlackee.png"));
    JLabel qnka = new JLabel(new ImageIcon("pics/qnka.png"));
    JLabel pumkin = new JLabel(new ImageIcon("pics/pumpkin.png"));


    JLabel colazero = new JLabel(new ImageIcon("pics/colazero.png"));
    JLabel cola = new JLabel(new ImageIcon("pics/cola.png"));
    JLabel fanta = new JLabel(new ImageIcon("pics/fanta.png"));
    JLabel sprite = new JLabel(new ImageIcon("pics/sprite.png"));
    JLabel water = new JLabel(new ImageIcon("pics/water.png"));

    JLabel petlv = new JLabel(new ImageIcon("pics/5lv.png"));
    JLabel desetlv = new JLabel(new ImageIcon("pics/10lv.png"));
    JLabel dvalv = new JLabel(new ImageIcon("pics/20lv.png"));
    JLabel petdesetlv = new JLabel(new ImageIcon("pics/50lv.png"));
    JLabel stolv = new JLabel(new ImageIcon("pics/100lv.png"));
    JLabel discount = new JLabel(new ImageIcon("pics/otstypka.png"));
    JLabel ddspic = new JLabel(new ImageIcon("pics/dds.png"));

    JLabel kran1 = new JLabel(new ImageIcon("pics/kran1.png"));
    JLabel kran2 = new JLabel(new ImageIcon("pics/kran2.png"));
    JLabel kran3 = new JLabel(new ImageIcon("pics/kran3.png"));
    JLabel kran4 = new JLabel(new ImageIcon("pics/kran4.png"));
    JLabel kran5 = new JLabel(new ImageIcon("pics/kran5.png"));
    JLabel kran6 = new JLabel(new ImageIcon("pics/kran6.png"));
    JLabel kran7 = new JLabel(new ImageIcon("pics/kran7.png"));
    JLabel kran8 = new JLabel(new ImageIcon("pics/kran8.png"));

    JLabel cenastroke = new JLabel(new ImageIcon("pics/cenastroke.png"));
    JLabel clientstroke = new JLabel(new ImageIcon("pics/clientstroke.png"));
    JLabel barcodestroke = new JLabel(new ImageIcon("pics/barcodestroke.png"));

    public static final DefaultComboBoxModel modelmenu1 = new DefaultComboBoxModel();
    public static final JComboBox cenachose = new JComboBox(modelmenu1);

    static String clientphone = "";
    public void comboClient(){
        PreparedStatement pst;
        ResultSet rs;

        final DefaultComboBoxModel modelmenu = new DefaultComboBoxModel();
        final JComboBox markachose = new JComboBox(modelmenu);
        background.add(markachose);
        markachose.setBounds(900, 25, 300, 30);
        modelmenu.addElement("Няма");

        String element = (String) modelmenu.getSelectedItem();
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

        markachose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = (String) modelmenu.getSelectedItem();
                if (FileActions.checkclient(element)) {
                    clienttellephone1.setText(FileActions.clientphone);
                    clientemail1.setText(FileActions.clientmail);
                    clientcardnumber1.setText(FileActions.clientnumber);
                    clientorders1.setText(FileActions.clientorders);
                } else if (element == "Няма"){
                    clienttellephone1.setText("-");
                    clientemail1.setText("-");
                    clientcardnumber1.setText("-");
                    clientorders1.setText("-");
                }
            }
        });
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();

        endsale.setBounds(1010, 845, 213, 64);
        endsale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String sum = "";
                for(int i = 0; i<table.getRowCount(); i++){
                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                    //sum = sum + Double.parseDouble(table.getValueAt(i, 0).toString());
                    sum = sum + table.getValueAt(i, 2) + " x" +table.getValueAt(i, 3) + "\n";
                }
                String [] options = new String[2];
                options[0] = new String("Потвърди");
                options[1] = new String("Откажи");
                int confirm = JOptionPane.showOptionDialog(salepanel.getContentPane(), "Потвърдете приключването на продажбата",
                        "Приключи продажба", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    String element = (String) modelmenu.getSelectedItem();
                    //FileActions.addOrdersClient("1", element); TO DO
                    FileActions.insertOrder(dtf.format(now), suma2.getText(), otstypka2.getText(), dds2.getText(), obshto2.getText(), plashtane2.getText(), resto2.getText(), element, sum);
                    JOptionPane.showMessageDialog(null, "Успешно приключихте продажба");

                }
            }
        });
        background.add(endsale);
    }

    public SalePanel() {
        comboClient();
        background.setBounds(0, 0, 1280, 950);

        cenastroke.setBounds(790, 625, 319, 220);
        clientstroke.setBounds(790, -10, 440, 255);
        barcodestroke.setBounds(790, 300, 440, 220);

        Object[] columns = {"", "Баркод", "Име", "Кол", "Цена", "Общо"};
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(new java.awt.Color(153, 214, 0));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));

        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(30, 530, 750, 300);
        pane.setFont(new Font("Arial", Font.BOLD, 30));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT );

        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(400);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);


        header.setText("ПРОДАЖБА");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setBounds(30, 20, 900, 40);
        header.setForeground(Color.WHITE);

        client.setText("Клиент:");
        client.setFont(new Font("Arial", Font.BOLD, 25));
        client.setBounds(790, 20, 900, 40);
        client.setForeground(Color.WHITE);

        clienttellephone.setText("Тел номер:");
        clienttellephone.setFont(new Font("Arial", Font.PLAIN, 15));
        clienttellephone.setBounds(810, 80, 900, 40);
        clienttellephone.setForeground(Color.WHITE);

        clienttellephone1.setText("-");
        clienttellephone1.setFont(new Font("Arial", Font.BOLD, 15));
        clienttellephone1.setBounds(890, 80, 900, 40);
        clienttellephone1.setForeground(Color.WHITE);

        clientemail.setText("E-mail:");
        clientemail.setFont(new Font("Arial", Font.PLAIN, 15));
        clientemail.setBounds(810, 120, 900, 40);
        clientemail.setForeground(Color.WHITE);

        clientemail1.setText("-");
        clientemail1.setFont(new Font("Arial", Font.BOLD, 15));
        clientemail1.setBounds(860, 120, 900, 40);
        clientemail1.setForeground(Color.WHITE);

        clientcardnumber.setText("№ карта:");
        clientcardnumber.setFont(new Font("Arial", Font.PLAIN, 15));
        clientcardnumber.setBounds(1000, 80, 900, 40);
        clientcardnumber.setForeground(Color.WHITE);

        clientcardnumber1.setText("-");
        clientcardnumber1.setFont(new Font("Arial", Font.BOLD, 15));
        clientcardnumber1.setBounds(1080, 80, 900, 40);
        clientcardnumber1.setForeground(Color.WHITE);

        clientorders.setText("Поръчки:");
        clientorders.setFont(new Font("Arial", Font.PLAIN, 15));
        clientorders.setBounds(1100, 120, 900, 40);
        clientorders.setForeground(Color.WHITE);

        clientorders1.setText("-");
        clientorders1.setFont(new Font("Arial", Font.BOLD, 15));
        clientorders1.setBounds(1180, 120, 900, 40);
        clientorders1.setForeground(Color.WHITE);

        suma.setText("Сума:");
        suma.setFont(new Font("Arial", Font.BOLD, 18));
        suma.setBounds(800, 645, 900, 40);
        suma.setForeground(Color.WHITE);

        suma2.setText("0.00");
        suma2.setFont(new Font("Arial", Font.BOLD, 18));
        suma2.setBounds(890, 645, 200, 40);
        suma2.setHorizontalAlignment(SwingConstants.RIGHT);
        suma2.setForeground(Color.WHITE);

        otstypka.setText("Отстъпка:");
        otstypka.setFont(new Font("Arial", Font.BOLD, 18));
        otstypka.setBounds(800, 670, 900, 40);
        otstypka.setForeground(new java.awt.Color(46, 169, 192));

        otstypka2.setText("0");
        otstypka2.setFont(new Font("Arial", Font.BOLD, 18));
        otstypka2.setBounds(892, 670, 200, 40);
        otstypka2.setHorizontalAlignment(SwingConstants.RIGHT);
        otstypka2.setForeground(new java.awt.Color(46, 169, 192));

        dds.setText("ДДС:");
        dds.setFont(new Font("Arial", Font.BOLD, 18));
        dds.setBounds(800, 695, 900, 40);
        dds.setForeground(Color.WHITE);

        dds2.setText("0.00");
        dds2.setFont(new Font("Arial", Font.BOLD, 18));
        dds2.setBounds(892, 695, 200, 40);
        dds2.setHorizontalAlignment(SwingConstants.RIGHT);
        dds2.setForeground(Color.WHITE);

        obshto.setText("ОБЩО:");
        obshto.setFont(new Font("Arial", Font.BOLD, 22));
        obshto.setBounds(800, 730, 900, 40);
        obshto.setForeground(Color.ORANGE);

        obshto2.setText("0.00");
        obshto2.setFont(new Font("Arial", Font.BOLD, 22));
        obshto2.setBounds(890, 730, 200, 40);
        obshto2.setHorizontalAlignment(SwingConstants.RIGHT);
        obshto2.setForeground(Color.ORANGE);

        plashtane.setText("Плащане:");
        plashtane.setFont(new Font("Arial", Font.BOLD, 18));
        plashtane.setBounds(800, 760, 300, 50);
        plashtane.setForeground(Color.WHITE);

        Action action1 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double suma = Double.parseDouble(obshto2.getText());
                double plashtane = Double.parseDouble(plashtane2.getText());
                double resto = plashtane - suma;
                if (suma <= plashtane) {
                    resto2.setText(""+resto);
                } else {
                    JOptionPane.showMessageDialog(null, "Крайната сума е по-голяма от плащането.","Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        plashtane2.setText("0.00");
        plashtane2.setFont(new Font("Arial", Font.BOLD, 18));
        plashtane2.setBounds(892, 775, 200, 20);
        plashtane2.setHorizontalAlignment(SwingConstants.RIGHT);
        plashtane2.setForeground(Color.BLACK);
        plashtane2.addActionListener(action1);

        resto.setText("Ресто:");
        resto.setFont(new Font("Arial", Font.BOLD, 18));
        resto.setBounds(800, 790, 900, 40);
        resto.setForeground(Color.WHITE);

        resto2.setText("0.00");
        resto2.setFont(new Font("Arial", Font.BOLD, 18));
        resto2.setBounds(890, 790, 200, 40);
        resto2.setHorizontalAlignment(SwingConstants.RIGHT);
        resto2.setForeground(Color.WHITE);

        /*Action action = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (FileActions.checkCode(barcode.getText())) {
                    String cena = FileActions.cenaproduct;
                    String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                    double kolichestvo = Double.parseDouble(qty);
                    double cena1 = Double.parseDouble(cena);
                    double cenaf = kolichestvo * cena1;
                    if(qty==qty){
                        model.addRow(new Object[]{"", barcode.getText(),FileActions.imeproduct, qty, cena, cenaf});
                        double sum = 0;
                        for(int i = 0; i<table.getRowCount(); i++){
                            //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                            sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                        }
                        suma2.setText(""+sum);
                        obshto2.setText(Double.toString(sum));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                }
            }

        };*/
        addproductheader.setText("ДОБАВИ ПРОДУКТ");
        addproductheader.setFont(new Font("Arial", Font.BOLD, 17));
        addproductheader.setBounds(795, 320, 435, 20);
        addproductheader.setHorizontalAlignment(SwingConstants.CENTER);
        addproductheader.setForeground(Color.WHITE);
        background.add(addproductheader);



        background.add(cenachose);
        cenachose.setBounds(910, 440, 80, 30);

        code.setText("БАРКОД:");
        code.setFont(new Font("Arial", Font.BOLD, 15));
        code.setBounds(810, 340, 90, 40);
        code.setForeground(Color.WHITE);
        code.setHorizontalAlignment(SwingConstants.RIGHT);

        barcode.setBounds(910, 350, 200, 22);
        barcode.setFont(new Font("Arial", Font.BOLD, 15));
        barcode.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (FileActions.checkCode(barcode.getText())){
                    productname1.setText(FileActions.imeproduct);
                    modelmenu1.removeAllElements();
                    modelmenu1.addElement(FileActions.cenaproduct);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (barcode.getText().isEmpty()){
                    productname1.setText("");
                    modelmenu1.removeAllElements();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        barcode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                barcode.selectAll();
            }
        });


        productname.setText("Име:");
        productname.setFont(new Font("Arial", Font.BOLD, 15));
        productname.setBounds(810, 370, 90, 40);
        productname.setForeground(Color.WHITE);
        productname.setHorizontalAlignment(SwingConstants.RIGHT);

        productname1.setBounds(910, 380, 200, 22);
        productname1.setFont(new Font("Arial", Font.BOLD, 15));

        productqty.setText("Количество:");
        productqty.setFont(new Font("Arial", Font.BOLD, 15));
        productqty.setBounds(780, 400, 120, 40);
        productqty.setForeground(Color.WHITE);
        productqty.setHorizontalAlignment(SwingConstants.RIGHT);

        productqty1.setText("1");
        productqty1.setBounds(910, 410, 40, 22);
        productqty1.setFont(new Font("Arial", Font.BOLD, 15));
        productqty1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                productqty1.selectAll();
            }
        });
        background.add(productqty1);

        productprice.setText("Цена:");
        productprice.setBounds(780, 435, 120, 40);
        productprice.setFont(new Font("Arial", Font.BOLD, 15));
        productprice.setForeground(Color.WHITE);
        productprice.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(productprice);

        moreproduct.setBounds(1120, 382, 20, 20);
        moreproduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CheckProductsALL checkProductsALL = new CheckProductsALL();
                salepanel.setState(JFrame.ICONIFIED);
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
        background.add(moreproduct);

        addproduct.setBounds(1058, 457, 160, 64);
        addproduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (FileActions.checkCode(barcode.getText())) {
                    String cena = (String)cenachose.getSelectedItem();
                    String qty = productqty1.getText();
                    double kolichestvo = Double.parseDouble(qty);
                    double cena1 = Double.parseDouble(cena);
                    double cenaf = kolichestvo * cena1;
                    model.addRow(new Object[]{SalePanel.a, barcode.getText(),productname1.getText(), qty, cena, cenaf});
                    SalePanel.a++;
                    double sum = 0;
                    for(int i = 0; i<table.getRowCount(); i++){
                        //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                        sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                    }
                    double sumatax = sum * (tax/100);
                    double sumawithtax = sum + sumatax;
                    suma2.setText(Double.toString(sum));
                    dds2.setText(Double.toString(sumatax));
                    obshto2.setText(Double.toString(sumawithtax));
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
        background.add(addproduct);



        beer1.setBounds(30, 100, 80, 80);
        beer1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String code = "800232340588";
                if (FileActions.checkCode(code)) {
                    String cena = FileActions.cenaproduct;
                    String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                    double kolichestvo = Double.parseDouble(qty);
                    double cena1 = Double.parseDouble(cena);
                    double cenaf = kolichestvo * cena1;
                    if(qty==qty){
                        model.addRow(new Object[]{FileActions.imeproduct, qty, cenaf});
                        double sum = 0;
                        for(int i = 0; i<table.getRowCount(); i++){
                            //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                            sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
                        }
                        suma2.setText(""+sum);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
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

        beer2.setBounds(120, 100, 80, 80);
        beer2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String code = "800232340595";
                if (FileActions.checkCode(code)) {
                    String cena = FileActions.cenaproduct;
                    String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                    double kolichestvo = Double.parseDouble(qty);
                    double cena1 = Double.parseDouble(cena);
                    double cenaf = kolichestvo * cena1;
                    if(qty==qty){
                        model.addRow(new Object[]{FileActions.imeproduct, qty, cenaf, code});
                        double sum = 0;
                        for(int i = 0; i<table.getRowCount(); i++){
                            //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                            sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
                        }
                        suma2.setText(""+sum);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
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


        blackhead.setBounds(210, 100, 80, 80);
        gingersucker.setBounds(300, 100, 80, 80);
        chaymalko.setBounds(390, 100, 80, 80);
        pumkin.setBounds(480, 100, 80, 80);
        unlackee.setBounds(30, 185, 80, 80);
        chipa.setBounds(120, 185, 80, 80);
        qnka.setBounds(210, 185, 80, 80);


        cola.setBounds(30, 100, 80, 80);
        colazero.setBounds(120, 100, 80, 80);
        fanta.setBounds(210, 100, 80, 80);
        sprite.setBounds(300, 100, 80, 80);
        water.setBounds(390, 100, 80, 80);

        petlv.setBounds(790, 530, 80, 80);
        petlv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double suma = Double.parseDouble(obshto2.getText());
                double plashtane = 5.00;
                double resto = plashtane - suma;
                if (suma <= plashtane) {
                    plashtane2.setText("5");
                    resto2.setText(""+resto);
                } else {
                    JOptionPane.showMessageDialog(null, "Крайната сума е по-голяма от плащането.","Грешка", JOptionPane.ERROR_MESSAGE);
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

        desetlv.setBounds(880, 530, 80, 80);
        desetlv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double suma = Double.parseDouble(obshto2.getText());
                double plashtane = 10.00;
                double resto = plashtane - suma;
                if (suma <= plashtane) {
                    plashtane2.setText("10");
                    resto2.setText(""+resto);
                } else {
                    JOptionPane.showMessageDialog(null, "Крайната сума е по-голяма от плащането.","Грешка", JOptionPane.ERROR_MESSAGE);
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

        dvalv.setBounds(970, 530, 80, 80);
        dvalv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double suma = Double.parseDouble(obshto2.getText());
                double plashtane = 20.00;
                double resto = plashtane - suma;
                if (suma <= plashtane) {
                    plashtane2.setText("20");
                    resto2.setText(""+resto);
                } else {
                    JOptionPane.showMessageDialog(null, "Крайната сума е по-голяма от плащането.","Грешка", JOptionPane.ERROR_MESSAGE);
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

        petdesetlv.setBounds(1060, 530, 80, 80);
        petdesetlv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double suma = Double.parseDouble(obshto2.getText());
                double plashtane = 50.00;
                double resto = plashtane - suma;
                if (suma <= plashtane) {
                    plashtane2.setText("50");
                    resto2.setText(""+resto);
                } else {
                    JOptionPane.showMessageDialog(null, "Крайната сума е по-голяма от плащането.","Грешка", JOptionPane.ERROR_MESSAGE);
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

        stolv.setBounds(1150, 530, 80, 80);
        stolv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double suma = Double.parseDouble(obshto2.getText());
                double plashtane = 100.00;
                double resto = plashtane - suma;
                if (suma <= plashtane) {
                    plashtane2.setText("100");
                    resto2.setText(""+resto);
                } else {
                    JOptionPane.showMessageDialog(null, "Крайната сума е по-голяма от плащането.","Грешка", JOptionPane.ERROR_MESSAGE);
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

        discount.setBounds(1150, 650, 80, 80);
        discount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String procent = JOptionPane.showInputDialog(null, "Въведете процент отстъпка.");
                double procent1 = Double.parseDouble(procent);
                if (procent == procent) {
                    double sum = 0;
                    for(int i = 0; i<table.getRowCount(); i++){
                        //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                        sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                    }
                    obshto2.setText(""+sum);
                    otstypka2.setText(procent + "%");
                    double suma = Double.parseDouble(suma2.getText());
                    double otstypka = (suma * procent1) / 100;
                    double cenaf = suma - otstypka;
                    obshto2.setText("" + cenaf);
                } if (procent1 == 0){
                    double sum = 0;
                    for(int i = 0; i<table.getRowCount(); i++){
                        //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                        sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                    }
                    suma2.setText(""+sum);
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

        ddspic.setBounds(1150, 740, 80, 80);
        ddspic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double input = Double.parseDouble(JOptionPane.showInputDialog(null, "Въвдете процент ДДС", 20));
                tax = input;
                System.out.println(tax);
                double totalget = Double.parseDouble(suma2.getText());
                double taxfinal = totalget * (tax/100);
                double totalcena = totalget + taxfinal;
                dds2.setText(Double.toString(taxfinal));
                obshto2.setText(Double.toString(totalcena));
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

        kran1.setBounds(30, 440, 80, 80);
        kran1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1001";
                    String code2 = "10011";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(Boolean.parseBoolean(qty)){
                                model.addRow(new Object[]{"", code2,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        kran2.setBounds(120, 440, 80, 80);
        kran2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1002";
                    String code2 = "10021";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{a, code2,FileActions.imeproduct, qty, cena, cenaf});
                                a++;
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        kran3.setBounds(210, 440, 80, 80);
        kran3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1003";
                    String code2 = "10031";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code2,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        kran4.setBounds(300, 440, 80, 80);
        kran4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1004";
                    String code2 = "10041";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code2,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        kran5.setBounds(390, 440, 80, 80);
        kran5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1005";
                    String code2 = "10051";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code2,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        kran6.setBounds(390, 440, 80, 80);
        kran6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1006";
                    String code2 = "10061";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code2,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        kran7.setBounds(480, 440, 80, 80);
        kran7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1007";
                    String code2 = "10071";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code2,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        kran8.setBounds(570, 440, 80, 80);
        kran8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] vidove = {"330 мл.", "500 мл."};
                JComboBox butilka = new JComboBox(vidove);

                int input;
                input = JOptionPane.showConfirmDialog(null, butilka, "Изберете вид", JOptionPane.DEFAULT_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    String element = (String) butilka.getSelectedItem();
                    String code = "1008";
                    String code2 = "10081";
                    if (element == "330 мл."){
                        if (FileActions.checkCode(code2)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code2,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
                    } else if (element == "500 мл."){
                        if (FileActions.checkCode(code)) {
                            String cena = FileActions.cenaproduct;
                            String qty = JOptionPane.showInputDialog(null, "Въведете количество", 1);
                            double kolichestvo = Double.parseDouble(qty);
                            double cena1 = Double.parseDouble(cena);
                            double cenaf = kolichestvo * cena1;
                            if(qty==qty){
                                model.addRow(new Object[]{"", code,FileActions.imeproduct, qty, cena, cenaf});
                                double sum = 0;
                                for(int i = 0; i<table.getRowCount(); i++){
                                    //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                                    sum = sum + Double.parseDouble(table.getValueAt(i, 5).toString());
                                }
                                suma2.setText(""+sum);
                                obshto2.setText(Double.toString(sum));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Не съществува продукт с такъв код");
                        }
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

        printsale.setBounds(780, 845, 213, 64);
        printsale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
        background.add(printsale);


        salepanel.add(background);
        background.add(pane);
        background.add(cenastroke);
        background.add(clientstroke);
        background.add(barcodestroke);
        background.add(header);
        background.add(client);
        background.add(clienttellephone);
        background.add(clienttellephone1);
        background.add(clientemail);
        background.add(clientemail1);
        background.add(clientcardnumber);
        background.add(clientcardnumber1);
        background.add(clientorders);
        background.add(clientorders1);
        background.add(code);
        background.add(barcode);
        background.add(productname);
        background.add(productname1);
        background.add(productqty);
        background.add(suma);
        background.add(suma2);
        background.add(otstypka);
        background.add(otstypka2);
        background.add(dds);
        background.add(dds2);
        background.add(obshto);
        background.add(obshto2);
        background.add(resto);
        background.add(resto2);
        background.add(plashtane);
        background.add(plashtane2);
        background.add(petlv);
        background.add(desetlv);
        background.add(dvalv);
        background.add(petdesetlv);
        background.add(stolv);
        background.add(discount);
        background.add(ddspic);
        background.add(kran1);
        background.add(kran2);
        background.add(kran3);
        background.add(kran4);
        background.add(kran5);
        background.add(kran6);
        background.add(kran7);
        background.add(kran8);


        background.add(biri);
        biri.setBounds(534, 20, 213, 64);
        biri.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                background.remove(biri);
                background.remove(razni2);
                background.add(razni);
                biri2.setBounds(534, 20, 213, 64);
                //snimki add:
                background.add(biri2);
                background.add(beer1);
                background.add(beer2);
                background.add(blackhead);
                background.add(gingersucker);
                background.add(chaymalko);
                background.add(chipa);
                background.add(unlackee);
                background.add(qnka);
                //snimki remove:
                background.remove(bezalk2);
                background.remove(colazero);
                background.remove(cola);
                background.remove(fanta);
                background.remove(sprite);
                background.remove(water);
                //buton:
                background.add(bezalk);
                background.revalidate();
                background.repaint();
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

        background.add(bezalk);
        bezalk.setBounds(534, 70, 213, 64);
        bezalk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                background.remove(biri2);
                background.add(biri);
                background.remove(razni2);
                background.add(razni);
                //snimki remove:
                background.remove(beer1);
                background.remove(beer2);
                background.remove(blackhead);
                background.remove(gingersucker);
                background.remove(chaymalko);
                background.remove(chipa);
                background.remove(unlackee);
                background.remove(qnka);
                bezalk2.setBounds(534, 70, 213, 64);
                background.remove(bezalk);
                background.add(bezalk2);
                //snimki add:
                background.add(colazero);
                background.add(cola);
                background.add(fanta);
                background.add(sprite);
                background.add(water);
                background.revalidate();
                background.repaint();
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

        background.add(razni);
        razni.setBounds(534, 120, 213, 64);
        razni.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                razni2.setBounds(534, 120, 213, 64);
                background.add(razni2);
                background.add(razni);
                background.remove(biri2);
                background.add(biri);
                background.remove(bezalk2);
                background.add(bezalk);
                //remove snimki biri
                background.remove(beer1);
                background.remove(beer2);
                background.remove(blackhead);
                background.remove(gingersucker);
                background.remove(chaymalko);
                background.remove(chipa);
                background.remove(unlackee);
                background.remove(qnka);
                //remove snimki bezalk
                background.remove(bezalk2);
                background.remove(colazero);
                background.remove(cola);
                background.remove(fanta);
                background.remove(sprite);
                background.remove(water);

                background.revalidate();
                background.repaint();
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

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        salepanel.setIconImage(icon);
        salepanel.setLayout(null);
        salepanel.setSize(1280, 950);
        salepanel.setLocationRelativeTo(null);
        salepanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        salepanel.setVisible(true);
    }
    public static void main(String s[]) { Main gui = new Main(); }
}
