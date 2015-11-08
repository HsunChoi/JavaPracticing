package com.xun.java.practing.postgres_practice.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by cuixun on 10/2/15.
 */
public class JdbcUtility {
    public static Connection getConnection(){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String pass = "postsql";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;

    }
}
