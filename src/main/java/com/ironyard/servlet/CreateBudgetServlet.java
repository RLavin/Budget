package com.ironyard.servlet;

import com.ironyard.data.Budget;
import com.ironyard.services.BudgetService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

/**
 * Created by Raul on 10/3/16.
 */
public class CreateBudgetServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/list";


        // get the data pieces
        String category = req.getParameter("cat");
        String description = req.getParameter("desc");
        String budgetamount = req.getParameter("budamount");
        String actualamount = req.getParameter("actamount");

        // create a new budget object and set values
        Budget  myBudget = new Budget() ;
        myBudget.setCategory(category ) ;
        myBudget.setDescription(description ) ;
        myBudget.setBudgetamount(Double.parseDouble(budgetamount)) ;
        myBudget.setActualamount(Double.parseDouble(actualamount) ) ;

        // then save this budget to database
        try {
            BudgetService  mServ = new BudgetService();
            mServ.createBudget(myBudget);
        }catch (Exception x){
            x.printStackTrace();
            destination = "/error.jsp";
        }

        // forward to result page

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);    }


}
