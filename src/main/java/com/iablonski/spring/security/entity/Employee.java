package com.iablonski.spring.security.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String department;
    @Column(name = "role")
    private String role;
    @Column(name = "bonus")
    private int bonus;
    @Column(name = "salary")
    private int salary;

    public Employee(String name, String surname, String department, String role, int bonus, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.role = role;
        this.bonus = bonus;
        this.salary = salary;
    }
}