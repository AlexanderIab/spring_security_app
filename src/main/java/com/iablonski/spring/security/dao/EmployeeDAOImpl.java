package com.iablonski.spring.security.dao;

import com.iablonski.spring.security.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDao{

    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createMutationQuery("delete from Employee where id=:employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
