import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FormServlet", value = "/formserv")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("banker");
        long mobile=Long.parseLong(request.getParameter("contact"));

        response.getWriter().println(name+" Banker request accepted and details will be sent through "+mobile);
    }
}
