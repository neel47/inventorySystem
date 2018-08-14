<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name: <font color="red"> *</font></td>
                <td><form:input path="name" required="required" placeholder=" Enter Name" /></td>
            </tr>
            <tr>
                <td>Email: <font color="red"> *</font></td>
                <td><form:input path="email" required="required" placeholder=" Enter Email"/></td>
            </tr>
            <tr>
                <td>Address: <font color="red"> *</font></td>
                <td><form:input path="address" required="required" placeholder=" Enter Address" /></td>
            </tr>
            <tr>
                <td>Telephone: <font color="red"> *</font></td>
                <td><form:input path="telephone" required="required" placeholder=" Enter Telephone" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>