package com.titos.balancetogether.repository;


import com.titos.balancetogether.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialRecordRepository
        extends JpaRepository<FinancialRecord, Long> {
}
