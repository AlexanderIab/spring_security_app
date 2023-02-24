<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
<h2>Update employee</h2>
<br>
<form:form action="save-employee" modelAttribute="employee">

  <form:hidden path="id"/>
  <form:hidden path="bonus"/>

  Name <form:input path="name"/>
  <br>
  <br>
  Surname <form:input path="surname"/>
  <br>
  <br>
  Department <form:input path="department"/>
  <br>
  <br>
  Role <form:input path="role"/>
  <br>
  <br>
  Salary <form:input path="salary"/>
  <br>
  <br>
  <input type="submit" value="OK">

</form:form>

</body>
</html>
