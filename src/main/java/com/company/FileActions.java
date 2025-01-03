package com.company;

import javax.swing.*;
import java.sql.*;

public class FileActions {

    //Accounts
    public static boolean account(String username, String pass) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM account";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("username").equals(username) && rs.getString("password").equals(pass)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean accuser(String username) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM account";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("fname").equals(username)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean insertAccount(String username, String pass, String fname, String lname, String Email){
        String sql = "INSERT INTO account(username, password, fname, lname, email) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, pass);
            pst.setString(3, fname);
            pst.setString(4, lname);
            pst.setString(5, Email);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    public static boolean updateAccount(String username, String pass, String email, String oldusername){
        String sql = "UPDATE account SET fname = ?, lname = ?, email = ? WHERE fname = ?";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, pass);
            pst.setString(3, email);
            pst.setString(4, oldusername);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    public static boolean deleteAccount(String username){
        String sql = "DELETE FROM account WHERE username = ?";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, username);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    //Sklad
    public static boolean insertProduct(String proizvoditel, String ime, String qty, String dostavnacena, String cenabezdds, String code,  String butilka){
        String sql = "INSERT INTO products(proizvoditel, ime, QTY, dostavnacena, cenabezDDS, code, butilka) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, proizvoditel);
            pst.setString(2, ime);
            pst.setString(3, qty);
            pst.setString(4, dostavnacena);
            pst.setString(5, cenabezdds);
            pst.setString(6, code);
            pst.setString(7, butilka);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    public static boolean checkProductINS(String marka, String model) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM products";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("proizvoditel").equals(marka) && rs.getString("ime").equals(model)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean updateProduct(String proizvoditel, String ime, String QTY, String dostavnacena, String cenabezDDS, String code , String butilka, int id){
        String sql = "UPDATE products SET proizvoditel = ?, ime = ?, QTY = ?, dostavnacena = ?, cenabezDDS = ?, code = ?, butilka = ? WHERE id = ? ";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, proizvoditel);
            pst.setString(2, ime);
            pst.setString(3, QTY);
            pst.setString(4, dostavnacena);
            pst.setString(5, cenabezDDS);
            pst.setString(6, code);
            pst.setString(7, butilka);
            pst.setInt(8, id);


            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }

    public static String imeproduct = "";
    public static String cenaproduct = "";
    public static String qtyproduct = "";
    public static String codeproduct = "";
    public static boolean checkCode(String code) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);//System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM products";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("code").equals(code)){
                    imeproduct = rs.getString("ime");
                    cenaproduct = rs.getString("cenabezdds");
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                //System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean checkQTY(String ime) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM products";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("ime").equals(ime)){
                    qtyproduct = rs.getString("QTY");
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean addStoka(String kolichestvo, String model){
        String sql = "UPDATE products SET QTY = QTY + ? WHERE ime = ?";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, kolichestvo);
            pst.setString(2, model);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }

    //Clients
    public static boolean insertClient(String name, String tellephone, String email, String cardnumber){
        String sql = "INSERT INTO clients(name, tellephone, email, cardnumber) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, tellephone);
            pst.setString(3, email);
            pst.setString(4, cardnumber);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    public static boolean updateClient(String name, String tellephone, String email, String cardnumber, String orders, int id){
        String sql = "UPDATE clients SET name = ?, tellephone = ?, email = ?, cardnumber = ?, orders = ? WHERE id = ?";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, tellephone);
            pst.setString(3, email);
            pst.setString(4, cardnumber);
            pst.setString(5, orders);
            pst.setInt(6,id);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }

    static String clientname = "";
    public static String clientphone = "";
    public static String clientmail = "";
    public static String clientnumber = "";
    public static String clientorders = "";
    public static boolean checkclient(String ime) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM clients";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                String imena = rs.getString("name");
                if(imena.equals(ime)){
                    clientphone = rs.getString("tellephone");
                    clientmail = rs.getString("email");
                    clientnumber = rs.getString("cardnumber");
                    clientorders = rs.getString("orders");
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    static String product = "";
    public static boolean checkQTYAll(String ime) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM clients";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                String imena = rs.getString("fname");
                if(imena.equals(ime)){
                    clientphone = rs.getString("tellephone");
                    clientmail = rs.getString("email");
                    clientnumber = rs.getString("cardnumber");
                    clientorders = rs.getString("orders");
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //salePanel
    public static boolean addOrdersClient(String orders, String name){
        String sql = "UPDATE clients SET orders = orders + ? WHERE name = ?";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, orders);
            pst.setString(2, name);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    public static boolean insertOrder(String date, String cenabezDDS, String discount, String dds, String total, String plateno, String resto, String client, String products){
        String sql = "INSERT INTO orders(date, cenabezDDS, discount, dds, total, plateno, resto, client, products) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, date);
            pst.setString(2, cenabezDDS);
            pst.setString(3, discount);
            pst.setString(4, dds);
            pst.setString(5, total);
            pst.setString(6, plateno);
            pst.setString(7, resto);
            pst.setString(8, client);
            pst.setString(9, products);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    public static boolean updateProductonOrder(String kolichestvo, Object model){
        String sql = "UPDATE products SET QTY = QTY - ? WHERE ime = ?";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setString(1, kolichestvo);
            pst.setObject(2, model);

            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }
    static String qtyproductOrder = "";
    public static boolean checkQTYOrder(String code) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM products";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("code").equals(code)){
                    qtyproductOrder = rs.getString("QTY");
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //Faktura
    public static String zdds = "";
    public static String eik = "";
    public static String adress = "";
    public static String mol = "";
    public static boolean checkcFirma(String ime) {
        String jdbcURL = "jdbc:mysql://localhost:3306/lahtara";
        String user="root";
        String password="";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Nqma driver");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM firmi";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                String imena = rs.getString("ime");
                if(imena.equals(ime)){
                    zdds = rs.getString("zdds");
                    eik = rs.getString("eik");
                    adress = rs.getString("adress");
                    mol = rs.getString("mol");
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return false;
        } finally {
            try {
                if (connection != null)
                    connection.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean insertFaktura(int id, String client, String dostavchik, String date, String plashtane, double suma, double otstypka, double dds, double ddsprocent, double obshto, String products){
        String sql = "INSERT INTO fakturi(id, client, dostavchik, date, plashtane, suma, otstypka, dds, ddsprocent, obshto, products) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/lahtara";
            String user      = "root";
            String password  = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, client);
            pst.setString(3, dostavchik);
            pst.setString(4, date);
            pst.setString(5, plashtane);
            pst.setDouble(6, suma);
            pst.setDouble(7, otstypka);
            pst.setDouble(8, dds);
            pst.setDouble(9, ddsprocent);
            pst.setDouble(10, obshto);
            pst.setString(11, products);


            pst.execute();
            return true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
            return false;
        }
    }



}
