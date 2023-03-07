package ojdbc;

import oracle.jdbc.OracleDriver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IterateServlet", value = "/iterate")
public class IterateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String query="select * from kyc";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            //connection.close();
            KYC kyc=null;
            List<KYC> profiles=new ArrayList<KYC>();
            while(resultSet.next()){
                kyc=new KYC();
                kyc.setAcc_number(resultSet.getInt("acc_number"));
                kyc.setPasscode(resultSet.getString("passcode"));
                kyc.setAcc_holder(resultSet.getString("acc_holder"));
                kyc.setAadhaar(resultSet.getLong("aadhaar"));
                kyc.setPan(resultSet.getString("pan"));
                kyc.setEmail(resultSet.getString("email"));
                kyc.setContact(resultSet.getLong("contact"));
                kyc.setAcc_bal(resultSet.getDouble("acc_bal"));
                InputStream inputStream=resultSet.getBinaryStream("address");
                byte[] tempBinary=new byte[inputStream.available()];
                inputStream.read(tempBinary);
                String address=new String(tempBinary);
                kyc.setAddress(address);
                profiles.add(kyc);
            }
            RequestDispatcher dispatcher=request.getRequestDispatcher("available.jsp");
            request.setAttribute("dbData",profiles);
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
