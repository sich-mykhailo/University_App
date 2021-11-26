package com.task.university.service;

import com.task.university.model.Department;
import java.util.List;

public interface DepartmentService {

    Department getById(Long id);

    List<Department> getAll();

    Department getByName(String name);

    Department save(Department department);

}
