package com.task.university;

import com.task.university.model.Department;
import com.task.university.service.ConsoleService;
import com.task.university.service.DepartmentService;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    private final DepartmentService departmentService;
    private final ConsoleService consoleService;

    public UniversityApplication(DepartmentService departmentService,
                                 ConsoleService consoleService) {
        this.departmentService = departmentService;
        this.consoleService = consoleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("You can use these commands:");
        System.out.println("Who is head of department {department_name}");
        System.out.println("Show {department_name} statistics");
        System.out.println("Show the average salary for the department {department_name}");
        System.out.println("Show count of employee for {department_name}");
        System.out.println("Global search by {template}");
        System.out.println("Exit");
        System.out.println();

        System.out.println("Our departments:");
        departmentService.getAll().stream()
                .map(Department::getName)
                .forEach(System.out::println);
        
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("exit")) {
            System.out.println("Enter command:");
            input = scanner.nextLine();
            if (input.matches("Who is head of department(.*)")) {
                System.out.println(consoleService.findDepartmentHead(input));
            }
            if (input.matches("(.*)statistics")) {

                System.out.println(consoleService.showStatistics(input));
            }
            if (input.matches("Show the average salary for the department(.*)")) {
                System.out.println(consoleService.showTheAverageSalaryForTheDepartment(input));
            }
            if (input.matches("Show count of employee for(.*)")) {
                System.out.println(consoleService.showCountOfEmployee(input));
            }
            if (input.matches("Global search by(.*)")) {
                consoleService.globalSearch(input).forEach(System.out::println);
            }
        }
    }
}
