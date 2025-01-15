package com.example.datamigration.repo.newDb;


import com.example.datamigration.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepo extends JpaRepository<Apartment, String> {
}
