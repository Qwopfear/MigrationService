package com.example.datamigration.repo.oldDb;

import com.example.datamigration.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OldRepo extends JpaRepository<Apartment, String> {

    List<Apartment> findAllByCreatedAtAfter(LocalDate after);
}
