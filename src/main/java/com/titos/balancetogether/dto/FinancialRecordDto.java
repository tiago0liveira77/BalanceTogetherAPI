package com.titos.balancetogether.dto;

import com.titos.balancetogether.enums.RecordType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FinancialRecordDto(
        Long id,
        RecordType type,
        BigDecimal amount,
        LocalDate date,
        String description,
        Long categoryId,
        Long householdId,
        Long payerUserId
) {}

