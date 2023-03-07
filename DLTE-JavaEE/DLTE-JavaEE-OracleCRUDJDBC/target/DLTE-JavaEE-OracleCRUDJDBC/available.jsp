<%@ page import="java.util.List" %>
<%@ page import="ojdbc.KYC" %>
<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 07-03-2023
  Time: 11:19 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <% List<KYC> objects=(List<KYC>)request.getAttribute("dbData"); %>--%>
    <%
        List<KYC> objects=(List<KYC>)request.getAttribute("dbData");
        pageContext.setAttribute("profiles",objects,PageContext.APPLICATION_SCOPE);
    %>
    <table>
        <thead>
            <tr>
                <th>Account_Number</th><th>Account_Holder</th><th>Account_Passcode</th>
                <th>Account_Balance</th><th>Aadhaar</th><th>PAN</th>
                <th>Email</th><th>Contact</th><th>Address</th>
            </tr>
        </thead>
        <tbody>
            <% for(KYC kyc:objects){ %>
            <tr>
                <td><%=kyc.getAcc_number()%></td>
                <td><%=kyc.getAcc_holder()%></td>
                <td><%=kyc.getPasscode()%></td>
                <td><%=kyc.getAcc_bal()%></td>
                <td><%=kyc.getAadhaar()%></td>
                <td><%=kyc.getPan()%></td>
                <td><%=kyc.getEmail()%></td>
                <td><%=kyc.getContact()%></td>
                <td><%=kyc.getAddress()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <a href="view_profiles.jsp">View Profiles once again</a>
</body>
</html>
