package com.example.datamigration.schedule;

import com.example.datamigration.repo.newDb.NewRepo;
import com.example.datamigration.repo.oldDb.OldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class WebMigration {

    private final OldRepo oldRepo;
    private final NewRepo newRepo;

    @Scheduled(cron = "#{@schedulingCron}")
    void dataMigration() {
        newRepo.saveAll(oldRepo.findAllByCreatedAtAfter(LocalDate.now().minusDays(1)));
    }
}
