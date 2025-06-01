package com.keskin.DAO;

import com.keskin.model.Driver;
import com.keskin.model.Roles;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDAO {

    private static final String DB_NAME = "truckdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public List<Driver> getAllDrivers() {

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<Driver> driverList = new ArrayList<>();

        conn = DBUtils.getConnection(DB_NAME, DB_USER, DB_PASSWORD);

        String query = "SELECT * FROM drivers";

        try {
            //prepare statement
            psmt = conn.prepareStatement(query);

            //execute query
            rs = psmt.executeQuery();

            //write the list
            while (rs.next()){
                Driver driver = new Driver();
                driver.setFirst_name(rs.getString("first_name"));
                driver.setLast_name(rs.getString("last_name"));
                driver.setRoles(Roles.valueOf(rs.getString("roles")));
                driver.setId(rs.getInt("id"));
                driver.setAge(rs.getInt("age"));

                driverList.add(driver);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rs.close();
                psmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return driverList;

    }
}
