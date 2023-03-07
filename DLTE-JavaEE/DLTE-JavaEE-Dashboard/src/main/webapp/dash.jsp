<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 07-03-2023
  Time: 03:05 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <style>
        img{
            height: 100vh;
        }
    </style>
</head>
<body class="bg-info">
<!-- <iframe src="nav.html" style="width: 100%;"></iframe> -->
<%out.println(request.getAttribute("banker"));%>
<%@ taglib prefix="loan" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container rounded-4 p-3" style="box-shadow: 5px 5px 20px red;">
    <div class="col-lg-12 col-sm-12">
        <div class="table-responsive">
            <table class="table text-info table-striped p-2 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
                <thead>
                <tr>
                    <th>Account_Number</th><th>Account_Holder</th><th>Account_Passcode</th>
                    <th>Account_Balance</th><th>Aadhaar</th><th>PAN</th>
                    <th>Email</th><th>Contact</th><th>Address</th>
                </tr>
                </thead>
                <tbody>
                    <loan:forEach var="record" items="${qry.rows}">
                        <tr>
                            <td>${record.acc_number}</td>
                            <td>${record.acc_holder}</td>
                            <td>${record.passcode}</td>
                            <td>${record.acc_bal}</td>
                            <td>${record.aadhaar}</td>
                            <td>${record.pan}</td>
                            <td>${record.email}</td>
                            <td>${record.contact}</td>
                            <td>${record.address}</td>
                        </tr>
                    </loan:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>