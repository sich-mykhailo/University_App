package com.task.university.service;

import com.task.university.model.Lector;
import java.util.List;

public interface ConsoleService {
    Lector findDepartmentHead(String input);

    String showStatistics(String input);

    String showTheAverageSalaryForTheDepartment(String input);

    int showCountOfEmployee(String input);

    List<String> globalSearch(String input);
}
