package com.ironyard.servlet;


import com.ironyard.data.Budget;
import com.ironyard.services.BudgetService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Raul on 9/29/16.
 */
public class BudgetListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // call to get all budgets
            BudgetService bs = new BudgetService();
            List<Budget> allBudgets = bs.getAllBudgets();
            // put that list of budgets in the session
            req.getSession().setAttribute("thebudgetlist",allBudgets);




            // forward to create page
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/budgetlist.jsp");
            dispatcher.forward(req, resp);
        }catch(Throwable t){
            t.printStackTrace();
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
