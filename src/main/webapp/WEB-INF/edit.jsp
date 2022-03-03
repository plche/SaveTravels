<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Expense <c:out value="${expense.id}" /></title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="row justify-content-center">
            <div class="col-4">
                <h1 class="text-success text-center mb-3">Edit Expense</h1>
	            <form:form class="rounded border border-5 border-success" action="/expenses/${expense.id}" method="post" modelAttribute="expense">
	            	<input type="hidden" name="_method" value="put">
                    <div class="row justify-content-center">
                        <div class="col-9">
                            <form:label for="name" path="name" class="form-label mt-3">Expense Name:</form:label>
                            <form:errors path="name" cssClass="text-danger" />
                            <form:input type="text" class="form-control mb-3" id="name" path="name" aria-label="Expense's name" />
                            <form:label for="vendor" path="vendor" class="form-label">Vendor:</form:label>
                            <form:errors path="vendor" cssClass="text-danger" />
                            <div class="col-5">
                                <form:input type="text" class="form-control mb-3" id="vendor" path="vendor" aria-label="Expense's vendor"/>
                            </div>
                            <form:label for="amount" path="amount" class="form-label">Amount:</form:label>
                            <form:errors path="amount" cssClass="text-danger" />
                            <div class="col-3">
                                <form:input type="number" step="0.01" class="form-control mb-3" id="amount" path="amount" aria-label="Expense's amount"/>
                            </div>
                            <form:label for="description" path="description" class="form-label">Description</form:label>
                            <form:errors path="description" cssClass="text-danger" />
                            <form:textarea class="form-control mb-3" rows="3" id="description" path="description" aria-label="Expense's description" />
                            <div class="d-flex justify-content-end">
                                <button type="submit" class="btn btn-primary mb-3">Submit</button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
	</body>
</html>