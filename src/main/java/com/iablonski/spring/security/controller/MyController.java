package com.iablonski.spring.security.controller;

import com.iablonski.spring.security.entity.Employee;
import com.iablonski.spring.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping ("/")
    public String getInfoForAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", employees);
        return "view-for-all-employees";
    }

    @RequestMapping("add-new-employee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "add-new-employee-hr";
    }

    @RequestMapping ("save-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping("update-bonus-info")
    public String updateBonusEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);
        return "set-bonus-manager";
    }

    @RequestMapping  ("update-info")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);
        return "update-info";
    }

    @RequestMapping("delete-employee")
    public String deleteEmployee(@RequestParam("empId") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
