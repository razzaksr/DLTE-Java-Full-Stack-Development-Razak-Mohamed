<%@ page import="ojdbc.KYC" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 07-03-2023
  Time: 11:42 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<KYC> objects=(List<KYC>)pageContext.getAttribute("profiles",PageContext.APPLICATION_SCOPE); %>
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
        <td><%out.print(kyc.getAcc_number()); %></td>
        <td><%out.print(kyc.getAcc_holder());%></td>
        <td><%out.print(kyc.getPasscode());%></td>
        <td><%out.print(kyc.getAcc_bal());%></td>
        <td><%out.print(kyc.getAadhaar());%></td>
        <td><%out.print(kyc.getPan());%></td>
        <td><%out.print(kyc.getEmail());%></td>
        <td><%out.print(kyc.getContact());%></td>
        <td><%out.print(kyc.getAddress());%></td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
