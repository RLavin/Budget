package com.ironyard.servlet;

import com.ironyard.data.Budget;
import com.ironyard.services.BudgetService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Raul on 10/5/16.
 */
public class UpdateBudgetServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/list";

        // get the request parameters
        String description = req.getParameter("desc");
        String category = req.getParameter("cat");
        String budamount = req.getParameter("budamount");
        String actamount = req.getParameter("actamount");
        String id = req.getParameter("id");

        double budConv = Double.parseDouble(budamount) ;
        double actConv = Double.parseDouble(actamount);
        long idConv = Long.parseLong(id);

        // create a movie object (with ID!)
        Budget updateMe = new Budget();
        updateMe.setId(idConv);
        updateMe.setBudgetamount(budConv ) ;
        updateMe.setCategory(category);
        updateMe.setDescription(description );
        updateMe.setActualamount(actConv) ;

        // call update on movie service
        BudgetService  ms = new BudgetService();
        try {
            ms.update(updateMe);
        }catch (SQLException e){
            e.printStackTrace();
            destination = "/error.jsp";
        }
        // forward list
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }
}
