package com.ironyard.services;

import com.ironyard.data.Budget;
import com.ironyard.data.BudgetTotal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Raul on 10/3/16.
 */
public class BudgetServiceTest {
    @Before
    public void setUp() throws Exception {
        DbService  dbUtil = new DbService();
        Connection c = dbUtil.getConnection();
        Statement s = c.createStatement();
        s.executeUpdate("TRUNCATE financing.budget");
        c.close();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllBudgets() throws Exception {
        BudgetService ms = new BudgetService();
        List<Budget> allBudgets = ms.getAllBudgets();
        assertEquals(allBudgets.size(), 1);

    }

    @Test
    public void getBudgetTotal() throws Exception {
        BudgetService  ms = new BudgetService();
        List<BudgetTotal> totals = ms.getBudgetTotal();
        assertTrue(totals.size() > 0);

    }

    @Test
    public void search() throws Exception {
        BudgetService ms = new BudgetService();
        List<Budget> allBudgets= ms.Search("fo");
        assertTrue(allBudgets.size() > 0);

    }

    @Test
    public void createBudget() throws Exception {
        BudgetService ms = new BudgetService();
        Budget m = new Budget();
        m.setCategory("Entertainment") ;
        m.setDescription("Movies") ;
        m.setBudgetamount(100) ;
        m.setActualamount(300) ;

        try {
            ms.createBudget(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Budget> found = ms.Search("Entertainment");
        assertNotNull(found);
        assertTrue(found.size() == 1);
        Budget foundBudget = found.get(0);
        assertEquals(foundBudget.getCategory() , "Entertainment");
        assertEquals(foundBudget.getDescription() , "Movies");
        assertEquals(foundBudget.getBudgetamount(), 100,1);
        assertEquals(foundBudget.getActualamount() , 300,1);
        assertTrue(foundBudget.getId()>0);
    }

    @Test
    public void updateBudget() throws Exception {

        BudgetService myServ = new BudgetService();
        myServ.createBudget(new Budget("Entertainment", "Movies",100,200));

        // go fetch budgets
        List<Budget> found = myServ.Search("Entertainment") ;


        // update field
        Budget budgetfound = null;
        budgetfound = found.get(0);
        budgetfound.setCategory("Outdoors");
        budgetfound.setDescription("racing") ;
        budgetfound.setBudgetamount(50) ;
        budgetfound.setActualamount(175) ;


        // call you new update method
        myServ.update(budgetfound);

        // fetch AGAIN
        found = myServ.Search("Outdoors");



    }
    @org.junit.Test
    public void deleteBudget() throws Exception {
        BudgetService myServ = new BudgetService();
        myServ.createBudget(new Budget("Entertainment", "Movies",100,200));

        // go fetch budgets
        List<Budget> found = myServ.Search("Entertainment") ;


        Budget budgetfound = null;
        budgetfound = found.get(0);
        // call you new delete method
        myServ.delete(budgetfound.getId()) ;

        // fetch AGAIN
        found = myServ.Search("Entertainment");

        //make sure its deleted/null
        assertNull(found);
    }

}