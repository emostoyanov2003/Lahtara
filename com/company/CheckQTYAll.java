package com.company;
import com.google.protobuf.Message;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.text.MessageFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CheckQTYAll {
    JFrame qtyall = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JTable table = new JTable();
    JButton test = new JButton();
    DefaultTableModel model = new DefaultTableModel();
    JLabel printbtn = new JLabel(new ImageIcon("buttons/print.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel header = new JLabel();
    JTextField search = new JTextField();
    JLabel filter = new JLabel();

    public void tablerec() {
        Object[] columns = {"Производител", "Модел", "Количество", "Дост цена", "Цена без ДДС", "Баркод", "Бутилка"};
        model.setColumnIdentifiers(columns);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(new java.awt.Color(153, 214, 0));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));

        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setModel(model);

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        search.setBounds(600, 100, 270, 30);
        search.setFont(new Font("Arial", Font.BOLD, 15));
        background.add(search);
        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = search.getText();
                if (text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = search.getText();

                if (text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        background.add(search);


        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(30, 150, 1200, 480);
        pane.setFont(new Font("Arial", Font.BOLD, 30));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tableHeader.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tableHeader.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tableHeader.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tableHeader.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tableHeader.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);




        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM products";
        try {
            String url = "jdbc:mysql://localhost:3306/lahtara";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("proizvoditel"),
                        rs.getString("ime"), rs.getString("QTY"),
                        rs.getString("dostavnacena") + " лв.",
                        rs.getString("cenabezdds") + " лв.",
                        rs.getString("code"),
                        rs.getString("butilka")});

            }
        } catch (Exception a) {

        }
        background.add(pane);
    }

    public CheckQTYAll() {
        tablerec();
        background.setBounds(0,0,1280,720);

        title.setBounds(0, 0, 1280, 25);

        x.setBounds(1255, 2, 20, 20);
        x.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                qtyall.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        header.setText("КОЛИЧЕСТВЕНА ТАБЛИЦА");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setBounds(0, 30, 1280, 40);
        header.setForeground(Color.WHITE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        background.add(header);

        filter.setText("ФИЛТРИРАЙ:");
        filter.setFont(new Font("Arial", Font.BOLD, 17));
        filter.setBounds(475, 95, 900, 40);
        filter.setForeground(Color.WHITE);
        background.add(filter);

        printbtn.setBounds(533, 650, 213, 64);
        printbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
                set.add(OrientationRequested.LANDSCAPE);

                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                MessageFormat header = new MessageFormat("Количествена таблица - Дата: "+java.time.LocalDate.now());

                try {
                    boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, null, false, set, false);
                    if (complete){

                    }
                } catch (PrinterException pe) {

                }
            }
        });
        background.add(printbtn);

        qtyall.add(title);
        title.add(x);
        qtyall.add(background);
        qtyall.setLayout(null);
        qtyall.setSize(1280, 720);
        qtyall.setUndecorated(true);
        qtyall.setLocationRelativeTo(null);
        qtyall.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qtyall.setVisible(true);
    }
    public static void main(String s[]) {
        Main gui = new Main();
    }
}