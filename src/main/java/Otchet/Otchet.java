package Otchet;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.awt.print.*;

public class Otchet extends JFrame {
    JFrame otchet = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel header = new JLabel();
    JButton dnevenbtn = new JButton();


    public Otchet(){
        background.setBounds(0, 0, 500, 300);

        header.setText("ОТЧЕТ");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBounds(200, 20, 250, 30);
        header.setForeground(Color.WHITE);

        dnevenbtn.setText("ДНЕВЕН ОТЧЕТ");
        dnevenbtn.setBounds(200, 50, 250, 30);
        dnevenbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DnevenOtchet dnevenOtchet = new DnevenOtchet();
            }
        });

        otchet.add(background);
        background.add(header);
        background.add(dnevenbtn);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        otchet.setIconImage(icon);
        otchet.setLayout(null);
        otchet.setSize(500, 300);
        otchet.setLocationRelativeTo(null);
        otchet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        otchet.setVisible(true);
    }
    public static void main(String s[]) {
        Main gui = new Main();
    }
}
