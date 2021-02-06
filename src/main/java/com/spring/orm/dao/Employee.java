package com.spring.orm.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_record")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_branch")
    private String employeeBranch;

    @Column(name = "employee_project")
    private String employeeProject;

    public Employee() {
        super();
    }

    public Employee(int employeeId, String employeeName, String employeeBranch, String employeeProject) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBranch = employeeBranch;
        this.employeeProject = employeeProject;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBranch() {
        return employeeBranch;
    }

    public void setEmployeeBranch(String employeeBranch) {
        this.employeeBranch = employeeBranch;
    }

    public String getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(String employeeProject) {
        this.employeeProject = employeeProject;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeBranch='" + employeeBranch + '\'' +
                ", employeeProject='" + employeeProject + '\'' +
                " }";
    }
}
