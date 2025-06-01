package com.keskin.DAO;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class LetterDAO {
    private static final String DB_NAME = "truckdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public boolean saveLetterToDB(String letter) {
        Connection connection = null;
        PreparedStatement psmt = null;

        try {
            connection = DBUtils.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            String query = "INSERT INTO letters (letterdesc) VALUES (?)";

            psmt = connection.prepareStatement(query);
            psmt.setString(1, letter);

            int affected_rows = psmt.executeUpdate();
            return affected_rows > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (psmt != null && !psmt.isClosed()) psmt.close();
                if (connection != null && !connection.isClosed()) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
