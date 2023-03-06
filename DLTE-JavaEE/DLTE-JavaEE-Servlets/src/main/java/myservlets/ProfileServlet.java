package myservlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String fullName=request.getParameter("fullname");
        String contactString=request.getParameter("contact");
        String info="Welcome user "+fullName+" from";
        if(contactString.startsWith("+91")){
            info+=" India";
        }
        else if(contactString.startsWith("+968")){
            info+=" Oman";
        }
        else if(contactString.startsWith("+971")){
            info+=" UAE";
        }
        else if(contactString.startsWith("+1")){
            info+=" US";
        }
//        PrintWriter printWriter=response.getWriter();
//        printWriter.println(info);
        RequestDispatcher dispatcher=request.getRequestDispatcher("acknowledge.jsp");
        request.setAttribute("general",info);
        dispatcher.forward(request,response);
    }
}
