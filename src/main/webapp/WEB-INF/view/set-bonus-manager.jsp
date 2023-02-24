<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
<h2>Add new employee</h2>
<br>
<form:form action="save-employee" modelAttribute="employee">

    <form:hidden path="id"/>
    <form:hidden path="name"/>
    <form:hidden path="surname"/>
    <form:hidden path="department"/>
    <form:hidden path="salary"/>
    <form:hidden path="role"/>

    Bonus: <form:input path="bonus"/>
    <br>
    <br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
