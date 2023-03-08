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

@WebServlet(name = "NewCustomerServlet", value = "/newkyc")
public class NewCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("acc_holder");
        String balance=request.getParameter("acc_bal");
        String passcode=request.getParameter("passcode");
        String pan=request.getParameter("pan");
        String aadhaar=request.getParameter("aadhaar");
        String email=request.getParameter("email");
        String contact=request.getParameter("contact");
        String address=request.getParameter("address");

        double myBalance=Double.parseDouble(balance);
        Long aadhaarNum=Long.parseLong(aadhaar);
        Long contactNum=Long.parseLong(contact);
        InputStream inputStream=new ByteArrayInputStream(address.getBytes());

        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String query="insert into kyc values(kyc_seq.nextval,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,passcode);
            preparedStatement.setString(2,name);
            preparedStatement.setLong(3,aadhaarNum);
            preparedStatement.setString(4,pan);
            preparedStatement.setString(5,email);
            preparedStatement.setLong(6,contactNum);
            preparedStatement.setDouble(7,myBalance);
            preparedStatement.setBinaryStream(8,inputStream);
            int acknowledge = preparedStatement.executeUpdate();
            RequestDispatcher dispatcher=request.getRequestDispatcher("newCustomer.jsp");
            if(acknowledge>0){
                logger.log(Level.FINE,"New customer has added");
                request.setAttribute("information","Customer Added");
            }
            else {
                request.setAttribute("information","Customer Not Added");
            }
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
