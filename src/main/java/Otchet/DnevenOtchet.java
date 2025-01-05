package Otchet;


import com.company.Main;
import com.company.Test;
import com.google.protobuf.Message;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class DnevenOtchet {
    JFrame dnevenpanel = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel header = new JLabel();
    JLabel unheader = new JLabel();

    PreparedStatement pst = null;
    ResultSet rs = null;


    public void TestPane() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(100, 80, 200, 25);
        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        background.add(datePicker);
    }
    public DnevenOtchet(){
        TestPane();
        background.setBounds(0, 0, 400, 180);

        header.setText("ДНЕВЕН ОТЧЕТ");
        header.setFont(new Font("Arial", Font.BOLD, 25));
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        unheader.setText("ИЗБЕРЕТЕ ДАТА:");
        unheader.setFont(new Font("Arial", Font.BOLD, 15));
        unheader.setBounds(0, 50, 400, 30);
        unheader.setHorizontalAlignment(SwingConstants.CENTER);
        unheader.setForeground(Color.WHITE);
        background.add(unheader);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        dnevenpanel.setIconImage(icon);
        dnevenpanel.add(background);
        background.add(header);
        dnevenpanel.setLayout(null);
        dnevenpanel.setSize(400, 180);
        dnevenpanel.setLocationRelativeTo(null);
        dnevenpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dnevenpanel.setVisible(true);
    }
    public static void main(String s[]) {
        Main gui = new Main();
    }
}
