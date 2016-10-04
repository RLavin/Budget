package com.ironyard.services;

import com.ironyard.data.Budget;
import com.ironyard.data.BudgetTotal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raul on 9/29/16.
 */
public class BudgetService {

    public List<Budget> getAllBudgets() throws SQLException {
        Budget found = null;
        List<Budget> allOfThem = new ArrayList<Budget>();
        DbService myDba = new DbService();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareCall("SELECT * FROM financing.budget");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            found = new Budget();
            found.setDescription(rs.getString("bud_description"));
            found.setCategory(rs.getString("bud_category"));
            found.setBudgetamount(rs.getDouble("bud_budamount"));
            found.setActualamount(rs.getDouble("bud_actamount"));
            found.setId(rs.getLong("bud_id"));
            allOfThem.add(found);
        }
        return allOfThem;
    }

    public List<BudgetTotal> getBudgetTotal() throws SQLException {
        List<BudgetTotal> found = new ArrayList<>();
        DbService  dbUtil = new DbService() ;
        Connection c = dbUtil.getConnection();
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("select bud_category, sum(bud_budamount) as bud_total, sum (bud_actamount) as act_total from financing.budget group by bud_category;");
        while (rs.next()) {
            BudgetTotal tmp = new BudgetTotal();
            tmp.setCat(rs.getString("bud_category"));
            tmp.setBudtotal(rs.getLong("bud_total")) ;
            tmp.setActtotal(rs.getLong("act_total")) ;
            found.add(tmp);
        }

        return found;
    }
    public List<Budget> Search(String search) throws SQLException {
        List<Budget> found = new ArrayList<>();
        DbService dbUtil = new DbService();
        Connection c = dbUtil.getConnection();
        try {
            c = dbUtil.getConnection() ;
            // do a starts with search
            search = search + "%";
            PreparedStatement ps = c.prepareStatement("select * from financing.budget WHERE (bud_category ILIKE ?) OR (bud_description ILIKE ?);");
            ps.setString(1, search);
            ps.setString(2, search);
            ResultSet rs = ps.executeQuery();
            found = convertResultsToList(rs);
        } catch(SQLException  t) {
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();
        }
        return found;
    }

    private List<Budget> convertResultsToList(ResultSet rs) throws SQLException {
        List<Budget> found = new ArrayList<>();
        while(rs.next()){
            Budget tmp = new Budget();
            tmp.setCategory(rs.getString("bud_category")) ;
            tmp.setId(rs.getLong("bud_id"));
            tmp.setDescription(rs.getString("bud_description")) ;
            tmp.setActualamount(rs.getInt("bud_actamount")) ;
            tmp.setBudgetamount(rs.getInt("bud_budamount")) ;
            found.add(tmp);
        }
        return found;
    }


    public void createBudget(Budget aBudget) throws SQLException {
        DbService myDba = new DbService();
        Connection c = null;
        try {
            c = myDba.getConnection();
            PreparedStatement stmt = c.prepareCall("INSERT into financing.budget (bud_id,bud_category,bud_description,bud_budamount, bud_actamount)VALUES (nextval('financing.budget_SEQ'),?,?,?,?)");
            stmt.setString(1, aBudget.getCategory());
            stmt.setString(2, aBudget.getDescription());
            stmt.setDouble(3, aBudget.getBudgetamount());
            stmt.setDouble(4, aBudget.getActualamount());
            stmt .executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            c.rollback();
            throw e;
        }finally {
            c.close();
        }

        }

}


