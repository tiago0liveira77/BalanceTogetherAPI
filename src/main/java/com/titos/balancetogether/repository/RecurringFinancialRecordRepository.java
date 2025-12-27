package com.titos.balancetogether.repository;

import com.titos.balancetogether.model.RecurringFinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecurringFinancialRecordRepository
        extends JpaRepository<RecurringFinancialRecord, Long> {
}
