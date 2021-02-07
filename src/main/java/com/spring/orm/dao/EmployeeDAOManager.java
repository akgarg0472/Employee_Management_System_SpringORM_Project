package com.spring.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOManager {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int addEmployee(Employee employee) {
        int result = (int) this.hibernateTemplate.save(employee);
        return result;
    }

    @Transactional
    public int addEmployee(int employeeId, String employeeName, String employeeBranch, String employeeProject) {
        return addEmployee(new Employee(employeeId, employeeName, employeeBranch, employeeProject));
    }

    public Employee getEmployee(int employeeId) {
        Employee employee = this.hibernateTemplate.get(Employee.class, employeeId);
        if (employee == null) {
            return new Employee(-1, "Not found", "Not found", "Not found");
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = this.hibernateTemplate.loadAll(Employee.class);

        if (allEmployees == null) {
            return new ArrayList<>();
        }
        return allEmployees;
    }

    @Transactional
    public String updateEmployee(Employee employee) {
        try {
            this.hibernateTemplate.update(employee);
            return "Updation done successfully";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Record updation failed");
        }
        return "Updation failed";
    }

    @Transactional
    public String deleteEmployee(Employee employee) {
        try {
            int employeeId = employee.getEmployeeId();
            if (employee == null) {
                return "No employee found with id=" + employeeId;
            }
            this.hibernateTemplate.delete(employee);
            return "Employee " + employee.getEmployeeId() + " successfully deleted";
        } catch (Exception e) {
            System.out.println("error deleting employee record");
            e.printStackTrace();
        }
        return "Employee deletion failed";
    }

    @Transactional
    public String deleteEmployee(int employeeId) {
        Employee employee = this.hibernateTemplate.get(Employee.class, employeeId);
        return this.deleteEmployee(employee);
    }
}
