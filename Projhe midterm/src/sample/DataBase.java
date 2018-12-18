package sample;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    //---------------connect to databse----------
    public Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/user_info", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //---------------end connect to databse----------


    //----------------------insert to data base---------------------
    public void insert(String name, String password) throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");

        String sql = "INSERT INTO user (name1,pass)" +
                "VALUES (?,?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        preparedStatement.executeUpdate();

    }
    //----------------------end insert to data base---------------------

    //----------------------insert to data base---------------------
    public ArrayList<user> getExpenses() {
        Connection myConnection = connect();
        ArrayList<user> expenses = new ArrayList<>();
        try {
            Statement stmt = myConnection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM user");
            while (result.next()) {
                String username = result.getString(1);
                String password = result.getString(2);
                expenses.add(new user(username, password));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return expenses;
    }
    //----------------------end insert to data base---------------------

}