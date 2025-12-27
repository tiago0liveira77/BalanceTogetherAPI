package com.titos.balancetogether.dto;

import com.titos.balancetogether.enums.FrequencyType;
import com.titos.balancetogether.enums.RecordType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateRecurringFinancialRecordRequest(
        RecordType type,
        BigDecimal amount,
        LocalDate startDate,
        LocalDate endDate,
        FrequencyType frequency,
        String description,
        Long categoryId,
        Long householdId,
        Long payerUserId
) {}
