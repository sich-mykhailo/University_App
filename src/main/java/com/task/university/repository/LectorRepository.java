package com.task.university.repository;

import com.task.university.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query(value = "SELECT first_name, last_name "
            + "FROM lectors l"
            + " WHERE first_name"
            + " LIKE %?1% OR last_name LIKE %?1% ", nativeQuery = true)
    List<String> getAllInitialsThatContainSimilarText(String text);
}
