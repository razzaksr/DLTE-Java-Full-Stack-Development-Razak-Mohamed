<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 08-03-2023
  Time: 03:58 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View All KYC's</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <script src="files/customer.js"></script>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
  if(session.getAttribute("banker")!=null){
  %>
<div class="container mt-3 rounded-4 p-3" style="box-shadow: 5px 5px 20px black;">
  <h1>${requestScope.information}</h1>
  <!-- Split up with two columns -->
  <div class="row justify-content-center">
    <!-- Main column1 - Featured products via Card component -->
    <div class="col-lg-6 col-sm-12">
      <h1 class="text-info text-center bg-info-subtle display-5 rounded-5" >Featured Products</h1>
      <div class="row justify-content-between">
        <div class="col-lg-5 col-sm-12 bg-info-subtle text-center text-info card p-2 rounded-5 shadow-lg">
          <img class="d-block rounded-5 card-img w-100" src="files/savincard-bank.png" />
          <h1 class="card-title">Hassle-free Mobile Banking</h1>
          <div class="card-body">
            <p>Experience hassle free mobile banking offered by Union bank</p>
            <a class="float-start btn btn-outline-info" href="https://www.unionbankofindia.co.in/english/home.aspx">
              Know More
            </a>
          </div>
        </div>
        <div class="col-lg-5 col-sm-12 bg-info-subtle text-center text-info card p-2 rounded-5 shadow-lg">
          <img class="d-block rounded-5 card-img w-100" src="files/seniorcitizen-savincard.png" />
          <h1 class="card-title">Importance to Senior citizen</h1>
          <div class="card-body">
            <p>Complex free banking offered by Union bank to Senior citizen's</p>
            <a class="float-start btn btn-outline-info" href="https://www.unionbankofindia.co.in/english/home.aspx">
              Know More
            </a>
          </div>
        </div>
        <div class="col-lg-12 mt-1 bg-info-subtle text-center text-info card p-2 rounded-5 shadow-lg">
          <img class="d-block rounded-5 card-img w-100" src="files/SavinMiles.png" />
          <h1 class="card-title">Hassle-free Car Loan</h1>
          <div class="card-body">
            <p>Get a Car loan with ease of request offered by Union bank</p>
            <a class="float-start btn btn-outline-info" href="https://www.unionbankofindia.co.in/english/home.aspx">
              Know More
            </a>
          </div>
        </div>
      </div>
    </div>
    <!-- Main column2 - Available KYC's via table -->
    <div class="col-lg-6 col-sm-12 align-self-center">
      <h1 class="text-info bg-info-subtle text-center rounded-5 mt-2">Available KYC's</h1>
      <div class="alert alert-info">
        <h2 class="text-info text-center">Find Customers</h2>
        <div class="row justify-content-between">
          <div class="col-lg-6 col-sm-12"><input type="text" name="cusId" placeholder="Customer ID" class="form-control" /></div>
          <div class="col-lg-6 col-sm-12"><input type="text" onchange="collect(this.value)" name="cusName" placeholder="Customer Name" class="form-control" /></div>
        </div>
      </div>
      <%@ taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
      <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
      <db:setDataSource var="customerDb" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="admin"/>
      <db:query var="profiles" sql="select * from kyc" dataSource="${customerDb}"/>
      <div class="table-responsive">
        <table class="table text-info table-striped p-2 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
          <thead>
          <tr>
            <th>Account_Number</th><th>Account_Holder</th>
            <th>Account_Balance</th><th>Aadhaar</th><th>PAN</th>
            <th>Contact</th><th>Perform</th>
          </tr>
          </thead>
          <tbody>
            <core:forEach var="customer" items="${profiles.rows}">
              <tr>
                <td>${customer.acc_number}</td><td>${customer.acc_holder}</td>
                <td>${customer.acc_bal}</td><td>${customer.aadhaar}</td><td>${customer.pan}</td>
                <td>${customer.contact}</td>
                <td>
                  <a href="edit.jsp?id=${customer.acc_number}" class="btn btn-outline-warning">
                    <i class="bi bi-pencil-square"></i>
                  </a>
                  <a class="btn btn-outline-danger">
                    <i class="bi bi-person-x"></i>
                  </a>
                </td>
              </tr>
            </core:forEach>
          </tbody>
        </table>
      </div>
      <a class="btn btn-outline-success float-end" href="newCustomer.jsp">
        <i class="bi bi-newspaper"></i>New Customer
      </a>
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