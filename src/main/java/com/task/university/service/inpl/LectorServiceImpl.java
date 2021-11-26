package com.task.university.service.inpl;

import com.task.university.model.Lector;
import com.task.university.repository.LectorRepository;
import com.task.university.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector getById(Long id) {
        return lectorRepository.getById(id);
    }

    @Override
    public Lector save(Lector lector) {
        return lectorRepository.save(lector);
    }
}
