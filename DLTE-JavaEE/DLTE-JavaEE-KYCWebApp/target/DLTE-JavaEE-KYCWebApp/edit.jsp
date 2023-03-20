<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 08-03-2023
  Time: 04:15 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcoming New Customer</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<style>
    #frm{
        box-shadow: 1px 1px 50px skyblue;
    }
    span{
        color: red;
    }
</style>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("banker")!=null){
%>
<%@ taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<db:setDataSource var="connection" user="system" password="admin" url="jdbc:oracle:thin:@localhost:1521:xe" driver="oracle.jdbc.driver.OracleDriver"/>
<db:query var="profiles" dataSource="${connection}" sql="select * from kyc where acc_number=?">
    <db:param value="${param['id']}"/>
</db:query>
<core:set var="records" value="${profiles.rows[0]}"/>
<div class="container text-info mt-2">
    <div class="alert alert-info rounded-5" id="frm">
        <div class="row justify-content-center">
            <h2>${requestScope.information}</h2>
            <h1 class="text-center text-info">New Customer</h1>
            <form action="update" method="post" name="newone" class="col-lg-8 col-sm-12 rounded-5 p-5">
                <input type="hidden" name="acc_number" value="${records.acc_number}">
                <div class="row justify-content-between">
                    <div class="col-lg-6 col-sm-12">
                        <label>Customer Name
                            <span id="errname"></span>
                        </label>
                        <input type="text" name="acc_holder" value="${records.acc_holder}" placeholder="Customer Full Name" class="form-control"/>
                    </div>
                    <div class="col-lg-6 col-sm-12">
                        <label>Customer Balance</label>
                        <input type="text" name="acc_bal" value="${records.acc_bal}" placeholder="Balance" class="form-control"/>
                    </div>
                </div>
                <div class="form group">
                    <label>Customer PIN
                        <span id="errpin"></span>
                    </label>
                    <input type="password" name="passcode"  value="${records.passcode}" placeholder="Customer PIN Number" class="form-control"/>
                </div>
                <div class="row justify-content-between">
                    <div class="col-lg-6 col-sm-12">
                        <label>Mention PAN</label>
                        <input type="text" name="pan" placeholder="PAN Card"  value="${records.pan}" class="form-control"/>
                    </div>
                    <div class="col-lg-6 col-sm-12">
                        <label>Mention Aadhaar</label>
                        <input type="text" name="aadhaar" value="${records.aadhaar}" placeholder="Aadhaar" class="form-control"/>
                    </div>
                </div>
                <div class="row justify-content-between">
                    <div class="col-lg-6 col-sm-12">
                        <label>Mobile Num</label>
                        <input type="text" name="contact"  value="${records.contact}" placeholder="Contact Number" class="form-control"/>
                    </div>
                    <div class="col-lg-6 col-sm-12">
                        <label>Email ID
                            <span id="erremail"></span>
                        </label>
                        <input type="text" name="email"  value="${records.email}" placeholder="Customer Email ID" class="form-control"/>
                    </div>
                </div>
                <div class="for group">
                    <label>Address</label>
                    <textarea name="address" class="form-control" value="${records.address}">

                    </textarea>
                </div>
                <div class="row justify-content-around mt-3">
                    <input class="col-1 btn btn-outline-info" type="submit" value="Update">
                    <input class="col-1 btn btn-outline-dark" type="reset" value="Cancel">
                </div>
            </form>
        </div>
    </div>
</div>
<a href="logout">Logout</a>
<%}
else{
    response.sendRedirect("index.jsp");
}%>
</body>
</html>
