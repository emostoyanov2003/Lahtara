package ForgotPass;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotPassword extends JFrame {
    JFrame forgotpass = new JFrame();
    JLabel background = new JLabel(new ImageIcon("background2.png"));
    JLabel title = new JLabel(new ImageIcon("title/title.png"));
    JLabel x = new JLabel(new ImageIcon("title/x.png"));
    JLabel text = new JLabel(new ImageIcon("forgotpasspics/text.png"));
    JTextField userfield = new JTextField();

    public ForgotPassword(){
        background.setBounds(0, 0, 350, 350);
        title.setBounds(0, 0, 350, 25);
        x.setBounds(325, 2, 20, 20);
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(JFrame.EXIT_ON_CLOSE);
            }
        });

        text.setBounds(0, 20, 350, 260);
        background.add(text);

        userfield.setBounds(40, 160, 270, 25);
        userfield.setOpaque(false);
        userfield.setFont(new Font("Arial", Font.BOLD, 15));
        userfield.setForeground(Color.WHITE);
        background.add(userfield);

        forgotpass.add(title);
        title.add(x);
        forgotpass.add(background);
        forgotpass.setTitle("Забравена парола");
        forgotpass.setUndecorated(true);
        forgotpass.setLayout(null);
        forgotpass.setSize(350, 300);
        forgotpass.setLocationRelativeTo(null);
        forgotpass.setVisible(true);
    }
    public static void main(String s[]) { Main gui = new Main();}
}
