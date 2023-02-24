<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <style>
        table {
            border: 4px solid #333;
            border-collapse: separate;
            width: 50%;
            border-spacing: 7px 11px;
            margin: auto;
        }

        td {
            padding: 10px;
            border: 1px solid #2d2626;
        }
    </style>
</head>
<style>
    .button {
        font-weight: 700;
        color: white;
        text-decoration: none;
        padding: .8em 1em calc(.8em + 3px);
        border-radius: 3px;
        background: rgb(40, 58, 49);
        box-shadow: 0 -3px rgb(47, 58, 52) inset;
        transition: 0.2s;
    }

    .button:hover {
        background: rgb(59, 70, 64);
    }

    .button:active {
        background: rgb(91, 115, 102);
        box-shadow: 0 3px rgb(174, 213, 194) inset;
    }
</style>
<body>
<div style="text-align: center">
    <h2>Information for all employees</h2>
    <br><br>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Role</th>
            <security:authorize access="hasAnyRole('MANAGER')">
                <th>Bonus</th>
            </security:authorize>
            <security:authorize access="hasAnyRole('HR','MANAGER')">
                <th>Salary</th>
                <th>Operations</th>
            </security:authorize>
        </tr>
        <c:forEach var="employee" items="${allEmployees}">
            <c:url var="updateButton" value="update-info">
                <c:param name="empId" value="${employee.id}"/>
                <c:param name="empBonus" value="${employee.bonus}"/>
            </c:url>
            <c:url var="updateBonusButton" value="update-bonus-info">
                <c:param name="empId" value="${employee.id}"/>
                <c:param name="empName" value="${employee.name}"/>
                <c:param name="empSurname" value="${employee.surname}"/>
                <c:param name="empDepartment" value="${employee.department}"/>
                <c:param name="empRole" value="${employee.role}"/>
                <c:param name="empSalary" value="${employee.salary}"/>

            </c:url>
            <c:url var="deleteButton" value="delete-employee">
                <c:param name="empId" value="${employee.id}"/>
            </c:url>
            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.department}</td>
                <td>${employee.role}</td>
                <security:authorize access="hasAnyRole('MANAGER')">
                    <td>${employee.bonus}</td>
                </security:authorize>
                <security:authorize access="hasAnyRole('HR','MANAGER')">
                    <td>${employee.salary}</td>
                </security:authorize>
                <security:authorize access="hasAnyRole('MANAGER')">
                    <td>
                        <input type="button" value="Set bonus" onclick="window.location.href='${updateBonusButton}'"/>
                    </td>
                </security:authorize>
                <security:authorize access="hasAnyRole('HR')">
                    <td>
                        <input type="button" value="Update" onclick="window.location.href='${updateButton}'"/>
                        <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
                    </td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <security:authorize access="hasRole('HR')">
    <input type="button" value="Add" onclick="window.location.href='add-new-employee'" class="button"/>
    </security:authorize>
    <input type="button" value="Logout" onclick="window.location.href='logout'" class="button">
</body>
</html>