package com.keskin.DAO;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class RegisterDAO {

    private static final String DB_NAME = "truckdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public boolean registerUser(String firstname, String lastname, int age) {

        Connection connection = null;
        PreparedStatement psmt = null;

        //start connection
        connection = DBUtils.getConnection(DB_NAME, DB_USER, DB_PASSWORD);


        try {
            //write query
            String query = "INSERT INTO drivers(first_name, last_name, age) VALUES (?,?,?)";

            psmt = connection.prepareStatement(query);

            //set parameters
            psmt.setString(1, firstname);
            psmt.setString(2, lastname);
            psmt.setInt(3, age);

            int affected_rows = psmt.executeUpdate();
            return affected_rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
             try {
                 if (psmt != null && !psmt.isClosed()) psmt.close();
                 if (connection != null && !connection.isClosed()) connection.close();
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
        }


    }

    public boolean doesUserExistOnDB(String firstname){
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        connection = DBUtils.getConnection(DB_NAME, DB_USER, DB_PASSWORD);

        try {
            String query = "SELECT * FROM drivers WHERE first_name = ?";
            psmt = connection.prepareStatement(query);

            psmt.setString(1, firstname);

            rs = psmt.executeQuery();

            //eğer sonuc varsa kullanıcı var demektir
            return rs.next();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rs.close();
                psmt.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
