package com.xun.java.practing.postgres_practice.main_projects;

import com.xun.java.practing.postgres_practice.utility.JdbcUtility;

import java.sql.Connection;

/**
 * Created by cuixun on 10/2/15.
 */
public class ConnectionTest {
    public static void main(String[]args){
        Connection con = JdbcUtility.getConnection();
    }
}
