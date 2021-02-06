package com.spring.orm.dao;

import java.util.List;

public interface EmployeeInterface {
    int addEmployee(Employee employee);

    int addEmployee(int employeeId, String employeeName, String employeeBranch, String employeeProject);

    Employee getEmployee(Employee employee);

    Employee getEmployee(int employeeId);

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee);

    void updateEmployeeName(int id, String oldName, String newName);

    void updateEmployeeBranch(int id, String oldBranch, String newBranch);

    void updateEmployeeProject(int id, String oldProject, String newProject);

    void deleteEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
