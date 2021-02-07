package com.spring.orm.driverClass;

import com.spring.orm.dao.Employee;
import com.spring.orm.dao.EmployeeDAOManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1-> add new record
        // 2-> display all records
        // 3-> single record details
        // 4-> delete record
        // 5-> update record
        // 6-> exit program

        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("ProjectConfig.xml");
        EmployeeDAOManager dao = context.getBean("employeeDAOManager", EmployeeDAOManager.class);
        int choice;
        boolean isExit = false;

        while (!isExit) {
            System.out.println("\n*************** Employee Management System ***************");
            System.out.println("\t1. Add new Employee");
            System.out.println("\t2. Display record of all Employees");
            System.out.println("\t3. Display record of particular Employee");
            System.out.println("\t4. Delete an employee record");
            System.out.println("\t5. Update employee record");
            System.out.println("\t6. Exit program");
            System.out.print("\tEnter your choice of operation: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n********** Add new Employee **********");
                    System.out.print("\tEnter id of new employee: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\tEnter name of new Employee: ");
                    String name = scanner.nextLine();
                    System.out.print("\tEnter branch of new employee: ");
                    String branch = scanner.nextLine();
                    System.out.print("\tEnter project of new employee: ");
                    String project = scanner.nextLine();
                    if (dao.addEmployee(id, name, branch, project) > 0) {
                        System.out.println("Employee added successfully");
                    }
                    break;
                case 2:
                    System.out.println("\n********** Showing all employee record **********");
                    List<Employee> allEmployees = dao.getAllEmployees();
                    int count = 1;
                    System.out.println("Found total " + allEmployees.size() + " employees");
                    for (Employee employee : allEmployees) {
                        System.out.println("\tEmployee " + count++ + " details are: ");
                        System.out.println("\t\tEmployee id is: " + employee.getEmployeeId());
                        System.out.println("\t\tEmployee name is: " + employee.getEmployeeName());
                        System.out.println("\t\tEmployee branch is: " + employee.getEmployeeBranch());
                        System.out.println("\t\tEmployee project is: " + employee.getEmployeeProject() + "\n");
                    }
                    break;
                case 3:
                    System.out.println("\n********** Fetch employee record **********");
                    System.out.print("\tEnter employee id to fetch record: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();
                    Employee employee = dao.getEmployee(employeeId);
                    if (employee.getEmployeeId() == -1) {
                        System.out.println("No employee found with id=" + employeeId);
                        break;
                    }
                    System.out.println("Employee " + employeeId + " details are:");
                    System.out.println("\t\tEmployee id is: " + employee.getEmployeeId());
                    System.out.println("\t\tEmployee name is: " + employee.getEmployeeName());
                    System.out.println("\t\tEmployee branch is: " + employee.getEmployeeBranch());
                    System.out.println("\t\tEmployee project is: " + employee.getEmployeeProject());
                    break;
                case 4:
                    System.out.println("\n********** Delete employee record **********");
                    System.out.print("\tEnter employee id to delete record: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(dao.deleteEmployee(deleteId));
                    break;
                case 5:
                    System.out.println("\n********** Update employee record **********");
                    System.out.print("\tEnter employee id to update record: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    Employee updateEmployee = dao.getEmployee(editId);
                    System.out.println("\tOn what factor you want to update data?" +
                            "\n\t1. Name" +
                            "\n\t2. Branch" +
                            "\n\t3. Project");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (updateChoice) {
                        case 1:
                            System.out.print("\tEnter new name of employee: ");
                            String newName = scanner.nextLine();
                            updateEmployee.setEmployeeName(newName);
                            System.out.println(dao.updateEmployee(updateEmployee));
                            break;
                        case 2:
                            System.out.print("\tEnter new branch of employee: ");
                            String newBranch = scanner.nextLine();
                            updateEmployee.setEmployeeBranch(newBranch);
                            System.out.println(dao.updateEmployee(updateEmployee));
                            break;
                        case 3:
                            System.out.print("\tEnter new project of employee: ");
                            String newProject = scanner.nextLine();
                            updateEmployee.setEmployeeProject(newProject);
                            System.out.println(dao.updateEmployee(updateEmployee));
                            break;
                    }
                    break;
                case 6:
                    isExit = true;
                    scanner.close();
                    break;
            }
        }

        System.out.println("Program will be terminated in 5 seconds");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
