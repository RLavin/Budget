package com.ironyard.services;

import com.ironyard.data.Budget;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Raul on 10/3/16.
 */
public class BudgetServiceTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllBudgets() throws Exception {

    }

    @Test
    public void getBudgetTotal() throws Exception {

    }

    @Test
    public void search() throws Exception {

    }

    @Test
    public void createBudget() throws Exception {
        BudgetService myServ = new BudgetService();
        myServ.createBudget(new Budget("entertainmet","movies",345, 543));
    }

}