# Spring_security_app

This small, simple project is designed to practice and use skills.
The program supports all CRUD operations. Employee data is received and written to a local database.
<br><br>
Users have 3 roles: Manager, Employee, HR.<br>
Usernames, passwords and roles are stored in the database tables: authorities and users. The password is stored in the database in encrypted form (Bcrypt).

Technology stack:
- Spring MVC
- Spring Security
- JSTL
- Hibernate 
- MySQL
- Lombok
- Tomcat
<br>
- Service Layer, DAO
<br>
- Java Based Configuration
- Spring Security Form Based Authentication

<br>
<br>

If an Employee signs in, the following columns are available to him:
- Name, Surname, Department, Role
<br>

![2023-02-24_22-38-59](https://user-images.githubusercontent.com/100590447/221275365-0be00867-584b-424b-9f67-648b02dc357a.png)

If a HR employee signs in, the following columns are available to him:
- Name, Surname, Department, Role, Salary
- Ability to add, update or remove any employee
<br>

![2023-02-24_22-42-01](https://user-images.githubusercontent.com/100590447/221277032-439fb98f-9285-49d4-ac5e-27f260417933.png)
<br>
![2023-02-24_22-45-15](https://user-images.githubusercontent.com/100590447/221277063-dd390101-74b4-4d5f-9a30-97b5d0340293.png)
<br>
![2023-02-24_22-45-42](https://user-images.githubusercontent.com/100590447/221277089-f3259f24-c568-4b0b-8285-edc8c61d5bef.png)
<br>

If a Manager signs in, the following columns are available to him:
- Name, Surname, Department, Role, Bonus, Salary
- Ability to set a bonus for any employee
<br>

![2023-02-24_22-53-19](https://user-images.githubusercontent.com/100590447/221278003-59caf1f2-bd84-4919-909f-3fc148427a41.png)
<br>
![2023-02-24_22-54-05](https://user-images.githubusercontent.com/100590447/221278045-8a275462-2ea0-4724-b13d-3b73955d8f0e.png)

