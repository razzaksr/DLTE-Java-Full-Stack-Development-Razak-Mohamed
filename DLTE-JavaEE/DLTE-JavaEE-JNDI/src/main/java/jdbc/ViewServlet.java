package jdbc;

import bean.Banker;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ViewServlet", value = "/view")
public class ViewServlet extends HttpServlet {

    @Resource(name="dlte/source")
    private DataSource dataSource;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Context context=new InitialContext();
            Context context1= (Context) context.lookup("java:comp/env");
            Connection connection=dataSource.getConnection();
            String qry="select banker_name, banker_id from bankers";
            PreparedStatement preparedStatement= connection.prepareStatement(qry);
            ResultSet resultSet=preparedStatement.executeQuery();
            PrintWriter printWriter=response.getWriter();
            while(resultSet.next()){
                //printWriter.println(resultSet.getString("banker_name")+" "+resultSet.getInt("banker_id"));
                Banker banker= (Banker) context1.lookup("dlte/banker");
                banker.setBanker_name(resultSet.getString("banker_name"));
                banker.setBanker_id(resultSet.getInt("banker_id"));

                printWriter.println(banker.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
