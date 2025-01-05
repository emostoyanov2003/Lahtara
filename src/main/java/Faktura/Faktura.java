package Faktura;

import Otchet.DateLabelFormatter;
import com.company.FileActions;
import com.company.Main;
import com.company.SalePanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Properties;

public class Faktura extends JFrame {
    public static double tax;
    static double discountset;
    //Frame
    public static JFrame fakturapanel = new JFrame();
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    //Background pic
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    //Strokes
    JLabel dostavchikstroke = new JLabel(new ImageIcon("fakturapics/dostavchikstroke.png"));
    JLabel clientstroke = new JLabel(new ImageIcon("fakturapics/clientstroke.png"));
    JLabel barcodestroke = new JLabel(new ImageIcon("fakturapics/barcodestroke.png"));
    JLabel cenastroke = new JLabel(new ImageIcon("fakturapics/cenastroke.png"));
    //buttons
    JLabel printbtn = new JLabel(new ImageIcon("fakturapics/print.png"));
    JLabel noprintbtn = new JLabel(new ImageIcon("fakturapics/noprint.png"));
    JLabel accept = new JLabel(new ImageIcon("fakturapics/accept.png"));
    JLabel noaccept = new JLabel(new ImageIcon("fakturapics/noaccept.png"));
    JLabel addproduct = new JLabel(new ImageIcon("fakturapics/addproduct.png"));
    JLabel discount = new JLabel(new ImageIcon("pics/otstypka.png"));
    JLabel ddspic = new JLabel(new ImageIcon("pics/dds.png"));
    JLabel moreproduct = new JLabel(new ImageIcon("buttons/moreproducts.png"));
    JLabel clearfaktura = new JLabel(new ImageIcon("fakturapics/clear.png"));
    JLabel backtomain = new JLabel(new ImageIcon("fakturapics/backtomain.png"));
    //Labels
    JLabel header = new JLabel();
    JLabel unheader = new JLabel();
    JLabel unheader2 = new JLabel();
    JLabel clientfirma = new JLabel();
    JLabel clientzddsnomer = new JLabel();
    JLabel clientzddsnomer2 = new JLabel();
    JLabel clienteik = new JLabel();
    JLabel clienteik2 = new JLabel();
    JLabel clientadress = new JLabel();
    JLabel clientadress2 = new JLabel();
    JLabel clientmol = new JLabel();
    JLabel clientmol2 = new JLabel();

    JLabel mefirma = new JLabel();
    JLabel meddsnomer = new JLabel();
    JLabel meeik = new JLabel();
    JLabel meadress = new JLabel();
    JLabel memol = new JLabel();

    JLabel number = new JLabel();
    JLabel plashtane = new JLabel();
    JLabel date = new JLabel();

    JLabel barcodetext = new JLabel();
    JLabel productname = new JLabel();
    JLabel productqty = new JLabel();
    JLabel productprice = new JLabel();

    JLabel suma = new JLabel();
    JLabel suma2 = new JLabel();
    JLabel otstypka = new JLabel();
    JLabel otstypka2 = new JLabel();
    JLabel dds = new JLabel();
    JLabel dds2 = new JLabel();
    JLabel total = new JLabel();
    JLabel total2 = new JLabel();

    //TextFields
    JTextField numberField = new JTextField();
    public static JTextField fakturabarcode = new JTextField();
    JTextField productname1 = new JTextField();
    JTextField productqty1 = new JTextField();

    //Table
    DefaultTableModel tableModel = new DefaultTableModel();
    JTable table = new JTable();

    //FirmaComboBox
    DefaultComboBoxModel modelmenu = new DefaultComboBoxModel();
    JComboBox firmachose = new JComboBox(modelmenu);

    //PlashtaneComboBox
    DefaultComboBoxModel modelmenu1 = new DefaultComboBoxModel();
    JComboBox plashtanechose = new JComboBox(modelmenu1);

    //CenaCombo
    public static final DefaultComboBoxModel modelmenu2 = new DefaultComboBoxModel();
    public static final JComboBox cenachose = new JComboBox(modelmenu2);

    //Calendar
    UtilDateModel dateModel = new UtilDateModel();
    Properties properties = new Properties();


    public void ComboFirma(){
        PreparedStatement pst;
        ResultSet rs;
        modelmenu.addElement("Няма");
        String element = (String)modelmenu.getSelectedItem();

        String sql = "SELECT * FROM firmi";
        try {
            String url = "jdbc:mysql://localhost:3306/lahtara";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                modelmenu.addElement(rs.getString("ime"));
            }

        } catch (Exception e) {

        }
        firmachose.setBounds(120, 70, 150, 20);
        firmachose.setEditable(true);
        firmachose.addActionListener(e -> {
            if (FileActions.checkcFirma((String) modelmenu.getSelectedItem())){
                clientzddsnomer2.setText(FileActions.zdds);
                clienteik2.setText(FileActions.eik);
                clientadress2.setText(FileActions.adress);
                clientmol2.setText(FileActions.mol);
            } else if (modelmenu.getSelectedItem() == "Няма"){
                clientzddsnomer2.setText("-");
                clienteik2.setText("-");
                clientadress2.setText("-");
                clientmol2.setText("-");
            }
        });
        background.add(firmachose);
    }

    public Faktura(){
        ComboFirma();
        background.setBounds(0, 0, 900, 750);

        title.setBounds(0, 0, 900, 25);

        x.setBounds(875, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(fakturapanel.getContentPane(), "Желаете ли да откажете създаването на фактура?", "Отказ", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                if (confirm == JOptionPane.YES_OPTION){
                    fakturapanel.dispose();
                }
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

        clientstroke.setBounds(20, 35, 280, 198);
        background.add(clientstroke);
        dostavchikstroke.setBounds(600, 35, 280, 196);
        background.add(dostavchikstroke);
        barcodestroke.setBounds(20, 250, 860, 50);
        background.add(barcodestroke);

        cenastroke.setBounds(561, 520, 319, 170);
        background.add(cenastroke);

        header.setText("ФАКТУРА");
        header.setBounds(0,40, 900, 35);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 40));
        background.add(header);

        unheader.setText("Оригинал");
        unheader.setBounds(0, 70, 900, 35);
        unheader.setHorizontalAlignment(SwingConstants.CENTER);
        unheader.setForeground(new java.awt.Color(153, 214, 0));
        unheader.setFont(new Font("Arial", Font.BOLD, 18));
        unheader.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                background.remove(unheader);
                background.add(unheader2);
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
        background.add(unheader);

        unheader2.setText("Копие");
        unheader2.setBounds(0, 70, 900, 35);
        unheader2.setHorizontalAlignment(SwingConstants.CENTER);
        unheader2.setForeground(new java.awt.Color(153, 214, 0));
        unheader2.setFont(new Font("Arial", Font.BOLD, 18));
        unheader2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                background.remove(unheader2);
                background.add(unheader);
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

        //client
        clientfirma.setText("Фирма:");
        clientfirma.setBounds(0, 60, 110, 35);
        clientfirma.setForeground(Color.WHITE);
        clientfirma.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(clientfirma);

        clientzddsnomer.setText("№ по ЗДДС:");
        clientzddsnomer.setBounds(0, 90, 110, 35);
        clientzddsnomer.setForeground(Color.WHITE);
        clientzddsnomer.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(clientzddsnomer);

        clientzddsnomer2.setText("-");
        clientzddsnomer2.setBounds(120, 90, 110, 35);
        clientzddsnomer2.setForeground(Color.WHITE);
        background.add(clientzddsnomer2);

        clienteik.setText("ЕИК:");
        clienteik.setBounds(0, 120, 110, 35);
        clienteik.setForeground(Color.WHITE);
        clienteik.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(clienteik);

        clienteik2.setText("-");
        clienteik2.setBounds(120, 120, 110, 35);
        clienteik2.setForeground(Color.WHITE);
        background.add(clienteik2);

        clientadress.setText("Адрес:");
        clientadress.setBounds(0, 150, 110, 35);
        clientadress.setForeground(Color.WHITE);
        clientadress.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(clientadress);

        clientadress2.setText("-");
        clientadress2.setBounds(120, 150, 110, 35);
        clientadress2.setForeground(Color.WHITE);
        background.add(clientadress2);

        clientmol.setText("МОЛ:");
        clientmol.setBounds(0, 180, 110, 35);
        clientmol.setForeground(Color.WHITE);
        clientmol.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(clientmol);

        clientmol2.setText("-");
        clientmol2.setBounds(120, 180, 110, 35);
        clientmol2.setForeground(Color.WHITE);
        background.add(clientmol2);

        //dostavchik
        mefirma.setText("Фирма:");
        mefirma.setBounds(0, 60, 685, 35);
        mefirma.setForeground(Color.WHITE);
        mefirma.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(mefirma);

        meddsnomer.setText("№ по ЗДДС:");
        meddsnomer.setBounds(0, 90, 685, 35);
        meddsnomer.setForeground(Color.WHITE);
        meddsnomer.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(meddsnomer);

        meeik.setText("ЕИК:");
        meeik.setBounds(0, 120, 685, 35);
        meeik.setForeground(Color.WHITE);
        meeik.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(meeik);

        meadress.setText("Адрес:");
        meadress.setBounds(0, 150, 685, 35);
        meadress.setForeground(Color.WHITE);
        meadress.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(meadress);

        memol.setText("МОЛ:");
        memol.setBounds(0, 180, 685, 35);
        memol.setForeground(Color.WHITE);
        memol.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(memol);

        number.setText("№:");
        number.setBounds(0, 110, 365, 20);
        number.setForeground(Color.WHITE);
        number.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(number);

        numberField.setText("0000000001");
        numberField.setBounds(375, 110, 170, 20);
        background.add(numberField);

        plashtane.setText("Плащане:");
        plashtane.setBounds(0, 140, 365, 20);
        plashtane.setForeground(Color.WHITE);
        plashtane.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(plashtane);

        modelmenu1.addElement("брой");
        modelmenu1.addElement("банков превод");
        plashtanechose.setBounds(375, 140, 170, 20);
        background.add(plashtanechose);

        date.setText("Дата:");
        date.setBounds(0, 170, 365, 20);
        date.setForeground(Color.WHITE);
        date.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(date);

        properties.put("text.today", "Днес");
        properties.put("text.month", "Месец");
        properties.put("text.year", "Година");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(375, 170, 170, 25);
        background.add(datePicker);

        //Barcode
        barcodetext.setText("Баркод:");
        barcodetext.setBounds(45, 262, 150, 25);
        barcodetext.setForeground(Color.WHITE);
        barcodetext.setFont(new Font("", Font.BOLD, 15));
        background.add(barcodetext);

        fakturabarcode.setBounds(110, 262, 120, 25);
        fakturabarcode.setFont(new Font("Arial", Font.BOLD, 13));
        fakturabarcode.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (FileActions.checkCode(fakturabarcode.getText())){
                    productname1.setText(FileActions.imeproduct);
                    modelmenu2.removeAllElements();
                    modelmenu2.addElement(FileActions.cenaproduct);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (fakturabarcode.getText().isEmpty()){
                    productname1.setText("");
                    modelmenu2.removeAllElements();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        fakturabarcode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fakturabarcode.selectAll();
            }

        });
        background.add(fakturabarcode);

        productname.setText("Име:");
        productname.setBounds(240, 262, 150, 25);
        productname.setForeground(Color.WHITE);
        productname.setFont(new Font("", Font.BOLD, 15));
        background.add(productname);

        productname1.setBounds(280, 262, 170, 25);
        productname1.setFont(new Font("Arial", Font.BOLD, 13));
        background.add(productname1);

        moreproduct.setBounds(462, 265, 20, 20);
        moreproduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fakturapanel.setState(JFrame.ICONIFIED);
                new CheckProductsALLFaktura();
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

        productqty.setText("Количество:");
        productqty.setFont(new Font("", Font.BOLD, 15));
        productqty.setBounds(495, 262, 120, 25);
        productqty.setForeground(Color.WHITE);
        background.add(productqty);

        productqty1.setText("1");
        productqty1.setBounds(590, 262, 40, 25);
        productqty1.setFont(new Font("Arial", Font.BOLD, 15));
        productqty1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                productqty1.selectAll();
            }
        });
        background.add(productqty1);

        productprice.setText("Цена:");
        productprice.setBounds(645, 262, 120, 25);
        productprice.setFont(new Font("", Font.BOLD, 15));
        productprice.setForeground(Color.WHITE);
        background.add(productprice);

        cenachose.setBounds(705, 260, 80, 30);
        cenachose.setEditable(true);
        background.add(cenachose);

        addproduct.setBounds(800, 260, 65, 30);
        addproduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (FileActions.checkCode(fakturabarcode.getText())) {
                    String cena = (String)cenachose.getSelectedItem();
                    String qty = productqty1.getText();
                    double kolichestvo = Double.parseDouble(qty);
                    double cena1 = Double.parseDouble(cena);
                    double cenaf = kolichestvo * cena1;
                    tableModel.addRow(new Object[]{SalePanel.a, fakturabarcode.getText(),productname1.getText(), qty, cena, cenaf});
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
                    total2.setText(Double.toString(sumawithtax));
                }
                if (table.getModel().getRowCount() >= 1) {
                    background.remove(noprintbtn);
                    background.add(printbtn);
                    background.remove(noaccept);
                    background.add(accept);
                    background.revalidate();
                    background.repaint();
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

        //Table
        Object[] columns = {"", "Баркод", "Име", "Кол", "Цена", "Общо"};
        tableModel.setColumnIdentifiers(columns);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(new java.awt.Color(153, 214, 0));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));

        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setModel(tableModel);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20, 320, 860, 200);
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

        background.add(pane);

        discount.setBounds(470, 535, 80, 80);
        discount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
        background.add(discount);

        ddspic.setBounds(470, 625, 80, 80);
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
                total2.setText(Double.toString(totalcena));
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
        background.add(ddspic);

        suma.setText("Сума:");
        suma.setFont(new Font("", Font.BOLD, 18));
        suma.setForeground(Color.WHITE);
        suma.setBounds(575, 545, 150, 25);
        background.add(suma);

        suma2.setText("0.00");
        suma2.setFont(new Font("Arial", Font.BOLD, 18));
        suma2.setBounds(575, 545, 290, 40);
        suma2.setHorizontalAlignment(SwingConstants.RIGHT);
        suma2.setForeground(Color.WHITE);
        background.add(suma2);

        otstypka.setText("Отстъпка:");
        otstypka.setFont(new Font("", Font.BOLD, 18));
        otstypka.setForeground(new java.awt.Color(46, 169, 192));
        otstypka.setBounds(575, 570, 150, 25);
        background.add(otstypka);

        otstypka2.setText("0");
        otstypka2.setFont(new Font("Arial", Font.BOLD, 18));
        otstypka2.setBounds(575, 570, 290, 40);
        otstypka2.setHorizontalAlignment(SwingConstants.RIGHT);
        otstypka2.setForeground(new java.awt.Color(46, 169, 192));
        background.add(otstypka2);

        dds.setText("ДДС:");
        dds.setFont(new Font("", Font.BOLD, 18));
        dds.setBounds(575, 595, 150, 25);
        dds.setForeground(Color.WHITE);
        background.add(dds);

        dds2.setText("0.00");
        dds2.setFont(new Font("Arial", Font.BOLD, 18));
        dds2.setBounds(575, 595, 290, 40);
        dds2.setHorizontalAlignment(SwingConstants.RIGHT);
        dds2.setForeground(Color.WHITE);
        background.add(dds2);

        total.setText("ОБЩО:");
        total.setFont(new Font("", Font.BOLD, 22));
        total.setBounds(575, 630, 900, 40);
        total.setForeground(Color.ORANGE);
        background.add(total);

        total2.setText("0.00");
        total2.setFont(new Font("Arial", Font.BOLD, 22));
        total2.setBounds(575, 630, 290, 40);
        total2.setHorizontalAlignment(SwingConstants.RIGHT);
        total2.setForeground(Color.ORANGE);
        background.add(total2);

        printbtn.setBounds(830, 685, 50, 50);
        noprintbtn.setBounds(830, 685, 50, 50);
        noprintbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        background.add(noprintbtn);

        accept.setBounds(770, 685, 50, 50);
        accept.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(fakturapanel.getContentPane(), "Желаете ли да потвърдите фактурата?", "Потвърждение", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                if (confirm == JOptionPane.YES_OPTION){
                    String sum = "";
                    for(int i = 0; i<table.getRowCount(); i++){
                        //sum = sum + Integer.parseInt(table.getValueAt(i, 2).toString());
                        //sum = sum + Double.parseDouble(table.getValueAt(i, 0).toString());
                        sum = sum + table.getValueAt(i, 2) + " x" +table.getValueAt(i, 3) + "\n";
                    };
                    FileActions.insertFaktura(Integer.parseInt(numberField.getText()),
                            (String) modelmenu.getSelectedItem(),
                            "",
                            "",
                            (String) plashtanechose.getSelectedItem(),
                            Double.parseDouble(suma2.getText()),
                            Double.parseDouble(otstypka2.getText()),
                            Double.parseDouble(dds2.getText()),
                            tax,
                            Double.parseDouble(total2.getText()),
                            sum);
                }
            }
        });
        noaccept.setBounds(770, 685, 50, 50);
        background.add(noaccept);

        clearfaktura.setBounds(710, 685, 50, 50);
        clearfaktura.addMouseListener(new MouseAdapter() {
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
        background.add(clearfaktura);

        backtomain.setBounds(650, 685, 50, 50);
        backtomain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] options = new String[2];
                options[0] = new String("Да");
                options[1] = new String("Не");
                int confirm = JOptionPane.showOptionDialog(fakturapanel.getContentPane(), "Желаете ли да откажете създаването на фактура?", "Отказ", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                if (confirm == JOptionPane.YES_OPTION){
                    fakturapanel.dispose();
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
        background.add(backtomain);



        fakturapanel.add(title);
        title.add(x);
        fakturapanel.add(background);
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        fakturapanel.setTitle("Фактура");
        fakturapanel.setUndecorated(true);
        fakturapanel.setIconImage(icon);
        fakturapanel.setLayout(null);
        fakturapanel.setSize(900, 750);
        fakturapanel.setLocationRelativeTo(null);
        fakturapanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fakturapanel.setVisible(true);
    }
    public static void main(String s[]){
        new Main();
    }
}
