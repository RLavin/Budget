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
public class SelectBudgetServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/editbudget.jsp";
        // get id from the request
        String id = req.getParameter("id");
        long idConv = Long.parseLong(id);

        // fetch movie by id
        BudgetService  ms = new BudgetService();
        Budget found = null;
        try {
            found = ms.getBudgetById(idConv);
        }catch(SQLException e){
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // put movie into request
        req.setAttribute("myEdit", found);

        // forward
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }
}
