package com.spring.orm.dao;

import java.util.List;

public interface EmployeeDAO {

    int addEmployee(Employee employee);

    int addEmployee(int employeeId, String employeeName, String employeeBranch, String employeeProject);

    Employee getEmployee(int employeeId);

    List<Employee> getAllEmployees();

    String updateEmployee(Employee employee);

    String deleteEmployee(Employee employee);

    String deleteEmployee(int employeeId);
}
