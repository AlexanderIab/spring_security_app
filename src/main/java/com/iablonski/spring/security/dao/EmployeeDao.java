package com.iablonski.spring.security.dao;

import com.iablonski.spring.security.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
