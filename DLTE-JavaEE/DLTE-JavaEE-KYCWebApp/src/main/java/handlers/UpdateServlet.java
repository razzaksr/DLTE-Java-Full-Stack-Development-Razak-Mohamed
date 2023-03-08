package handlers;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acNumber=request.getParameter("acc_number");
        String name=request.getParameter("acc_holder");
        String balance=request.getParameter("acc_bal");
        String passcode=request.getParameter("passcode");
        String pan=request.getParameter("pan");
        String aadhaar=request.getParameter("aadhaar");
        String email=request.getParameter("email");
        String contact=request.getParameter("contact");
        String address=request.getParameter("address");

        int acc_number=Integer.parseInt(acNumber);
        double myBalance=Double.parseDouble(balance);
        Long aadhaarNum=Long.parseLong(aadhaar);
        Long contactNum=Long.parseLong(contact);
        InputStream inputStream=new ByteArrayInputStream(address.getBytes());

        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String query="update kyc set acc_holder=?, acc_bal=?, aadhaar=?, pan=?, passcode=?, email=?, contact=? where acc_number=? ";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(5,passcode);
            preparedStatement.setString(1,name);
            preparedStatement.setLong(3,aadhaarNum);
            preparedStatement.setString(4,pan);
            preparedStatement.setString(6,email);
            preparedStatement.setLong(7,contactNum);
            preparedStatement.setDouble(2,myBalance);
            preparedStatement.setInt(8,acc_number);
            int acknowledge = preparedStatement.executeUpdate();
            RequestDispatcher dispatcher=request.getRequestDispatcher("dashBoard.jsp");
            if(acknowledge>0){
                logger.log(Level.FINE,"KYC has updated");
                request.setAttribute("information","KYC has updated");
            }
            else {
                request.setAttribute("information","KYC hasn't updated");
            }
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
