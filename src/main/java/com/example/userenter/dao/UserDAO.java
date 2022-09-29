package com.example.userenter.dao;

import com.example.userenter.entity.User;

import java.sql.*;

public class UserDAO {
    private static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/userdb";
    private  static final String DB_USER="root";
    private static final String DB_PASSWORD="thuong";

    public User checkLogin(String email, String password)throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASSWORD);
        String sql = "SELECT *FROM user where email=? and password=?";
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setName(rs.getString("name"));
            user.getEmail();

        }
        connection.close();
        return user;
    }
    public boolean registerUser(User user) throws SQLException, ClassNotFoundException{
        boolean f= false;
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASSWORD);
        String INSERT_USER= "INSERT INTO user " +
                "( `name`, email,password, phone, address) VALUES " +
                "(?,?,?,?,?);";

        PreparedStatement ps=connection.prepareStatement(INSERT_USER);
        ps.setString(1, user.getName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getPhone());
        ps.setString(5,user.getAddress());
        int result=ps.executeUpdate();
        if (result==1){
            f=true;
        }
        return f;
    }
    public boolean checkUser(String email){
        boolean f= true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASSWORD);
            String sql = "Select * from user where email=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                f=false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return f;
    }
}
