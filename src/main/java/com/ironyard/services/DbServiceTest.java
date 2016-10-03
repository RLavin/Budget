package com.ironyard.services;

import com.ironyard.data.Budget;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 9/29/16.
 */


public class DbServiceTest {
    @org.junit.Test
    public void getConnection() throws Exception {
        DbService dbService = new DbService();
        Connection con = dbService.getConnection();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM financing.budget");

        boolean foundSomething = false;
        while (rs.next()) {
            foundSomething = true;
            System.out.println(rs.getString("bud_id"));
        }
        assertTrue(foundSomething);


    }

}




