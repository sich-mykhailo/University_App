package com.task.university.service.inpl;

import com.task.university.model.Degree;
import com.task.university.model.Department;
import com.task.university.model.Lector;
import com.task.university.repository.LectorRepository;
import com.task.university.service.ConsoleService;
import com.task.university.service.DepartmentService;
import com.task.university.service.LectorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ConsoleServiceImpl implements ConsoleService {
    public static final int DEPARTMENT_NAME_INDEX = 5;
    public static final int DEPARTMENT_NAME_FOR_STATISTIC = 1;
    public static final int DEPARTMENT_NAME_FOR_AVG_SALARY = 7;
    public static final int TEXT_INDEX = 3;

    private final DepartmentService departmentService;
    private final LectorService lectorService;
    private final LectorRepository lectorRepository;

    public ConsoleServiceImpl(DepartmentService departmentService,
                              LectorService lectorService,
                              LectorRepository lectorRepository) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector findDepartmentHead(String input) {
        return lectorService.getById(findDepartmentByInputQuery(input)
                .getLectorHeadId());
    }

    @Override
    public String showStatistics(String input) {
        Department department = departmentService.getByName(
                input.split(" ")[DEPARTMENT_NAME_FOR_STATISTIC]);
        long assistants = department.getLectors().stream()
                .filter(l -> l.getDegree().equals(Degree.ASSISTANT))
                .count();
        long associateProfessor = department.getLectors().stream()
                .filter(l -> l.getDegree().equals(Degree.ASSOCIATE_PROFESSOR))
                .count();
        long professors = department.getLectors().stream()
                .filter(l -> l.getDegree().equals(Degree.PROFESSOR))
                .count();

        return "assistants - "
                + assistants
                + System.lineSeparator()
                + "associate professors - "
                + associateProfessor
                + System.lineSeparator()
                + "profesors - "
                + professors;
    }

    @Override
    public String showTheAverageSalaryForTheDepartment(String input) {
        Department department = departmentService.getByName(
                input.split(" ")[DEPARTMENT_NAME_FOR_AVG_SALARY]);
        double averageSalary = department.getLectors().stream()
                .mapToDouble(Lector::getSalary)
                .average().orElseThrow(() ->
                        new RuntimeException("Can't get average salary from department "
                                + department.getName()));
        return " The average salary of "
                + department.getName()
                + " is "
                + averageSalary;
    }

    @Override
    public int showCountOfEmployee(String input) {
        return findDepartmentByInputQuery(input).getLectors().size();
    }

    @Override
    public List<String> globalSearch(String input) {
        return lectorRepository.getAllInitialsThatContainSimilarText(
                input.split(" ")[TEXT_INDEX]);
    }

    private Department findDepartmentByInputQuery(String input) {
        return departmentService.getByName(
                input.split(" ")[DEPARTMENT_NAME_INDEX]);
    }
}
