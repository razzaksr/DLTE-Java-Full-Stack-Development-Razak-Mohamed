package customfactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreditCardServlet", value = "/card")
public class CreditCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context=new InitialContext();
            Context context1= (Context) context.lookup("java:comp/env");
            CreditCard creditCard= (CreditCard) context1.lookup("dlte/credit");
            PrintWriter printWriter=response.getWriter();
            printWriter.println(creditCard);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
