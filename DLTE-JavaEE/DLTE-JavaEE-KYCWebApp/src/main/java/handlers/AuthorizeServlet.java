package handlers;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AuthorizeServlet", value = "/authenticate")
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String receiveId=request.getParameter("bankerId");
        String receivePin=request.getParameter("bankerPin");
        int bankId=Integer.parseInt(receiveId);
        try {
            Driver driver=new OracleDriver();
            ServletContext obj=request.getServletContext();
            OracleDataSource source=new OracleDataSource();
            source.setUser("system");source.setPassword("admin");
            source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            obj.setAttribute("connection",source);
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String query="select * from bankers where banker_id=? and banker_passcode=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, bankId);
            preparedStatement.setString(2,receivePin);
            logger.log(Level.INFO,""+receiveId+""+receivePin);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher dispatcher=request.getRequestDispatcher("dashBoard.jsp");
                logger.log(Level.INFO,"Authenticated");
                //System.out.println("PAssed "+resultSet.getString("banker_name"));

                HttpSession session=request.getSession();
                session.setAttribute("banker",resultSet.getString("banker_name"));

                dispatcher.forward(request,response);
            }
            else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                logger.log(Level.WARNING,"Not Authenticated");
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}