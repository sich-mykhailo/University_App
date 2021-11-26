package com.task.university.service;

import com.task.university.model.Lector;

public interface LectorService {

    Lector getById(Long id);

    Lector save(Lector lector);
}
