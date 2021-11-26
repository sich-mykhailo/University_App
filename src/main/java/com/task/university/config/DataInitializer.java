package com.task.university.config;

import com.task.university.model.Degree;
import com.task.university.model.Department;
import com.task.university.model.Lector;
import com.task.university.service.DepartmentService;
import com.task.university.service.LectorService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public DataInitializer(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    @PostConstruct
    public void inject() {
        Lector misha = new Lector("Misha", "Sich",
                100, Degree.PROFESSOR);
        lectorService.save(misha);
        Lector pasha = new Lector("pasha", "Ivanov",
                10000, Degree.ASSOCIATE_PROFESSOR);
        lectorService.save(pasha);
        Department biology = new Department("Biology", 1L);
        List<Lector> biologyLectors = new ArrayList<>();
        biologyLectors.add(misha);
        biology.setLectors(biologyLectors);
        Department astronomy = new Department("Astronomy", 2L);
        List<Lector> astronomyLectors = new ArrayList<>();
        astronomyLectors.add(pasha);
        astronomyLectors.add(misha);
        astronomy.setLectors(astronomyLectors);
        departmentService.save(biology);
        departmentService.save(astronomy);
    }
}
