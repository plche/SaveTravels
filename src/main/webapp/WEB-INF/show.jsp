<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 2/03/22
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Show Expense</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
       <div class="container ms-4 mt-4">
           <div class="row">
               <div class="col-4">
                   <h1 class="text-primary">Expense Details</h1>
               </div>
               <div class="col-2">
                   <form action="/expenses">
                       <button class="btn btn-sm btn-outline-warning">Go back</button>
                   </form>
               </div>
           </div>
           <div class="col-4">
               <table class="table">
                   <tbody>
                   <tr>
                       <td>Expense Name:</td>
                       <td><c:out value="${expense.getName()}" /></td>
                   </tr>
                   <tr>
                       <td>Expense Description:</td>
                       <td><c:out value="${expense.getDescription()}"/></td>
                   </tr>
                   <tr>
                       <td>Vendor:</td>
                       <td><c:out value="${expense.getVendor()}"/></td>
                   </tr>
                   <tr>
                       <td>Amount Spent:</td>
                       <td>$<c:out value="${expense.getAmount()}"/></td>
                   </tr>
                   </tbody>
               </table>
           </div>
       </div>
    </body>
</html>
