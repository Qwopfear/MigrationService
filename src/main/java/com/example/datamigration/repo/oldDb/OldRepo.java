package com.example.datamigration.repo.oldDb;

import com.example.datamigration.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OldRepo extends JpaRepository<Apartment, String> {

    List<Apartment> findAllByCreatedAtAfter(LocalDate after);
}
