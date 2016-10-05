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
 * Created by Raul on 10/4/16.
 */
public class TotalBudgetServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // call to get all budgets
            BudgetService bs = new BudgetService();
            List<Budget> allBudgets = bs.getAllBudgets();




            double x = 0;
            double y = 0;
            // loop through budgets
            for (Budget tmp : allBudgets ) {
                x = x + tmp.getBudgetamount();
                y = y + tmp.getActualamount();

                //equation for budget amount
                //equation for sum of actual amount
            }
            req.getSession().setAttribute("totalbudamount", x);
            req.getSession().setAttribute("totalactamount", y);

            BudgetService  ms = new BudgetService() ;

            req.setAttribute("budgettotal", ms.getBudgetTotal() );



            // forward to create page
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/summary.jsp");
            dispatcher.forward(req, resp);
        }catch(Throwable t){
            t.printStackTrace();
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
    }



    }
