package com.titos.balancetogether.service;

import com.titos.balancetogether.dto.CreateRecurringFinancialRecordRequest;
import com.titos.balancetogether.dto.RecurringFinancialRecordDto;
import com.titos.balancetogether.model.RecurringFinancialRecord;
import com.titos.balancetogether.repository.CategoryRepository;
import com.titos.balancetogether.repository.HouseholdRepository;
import com.titos.balancetogether.repository.RecurringFinancialRecordRepository;
import com.titos.balancetogether.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecurringFinancialRecordService {

    private final RecurringFinancialRecordRepository repository;
    private final CategoryRepository categoryRepository;
    private final HouseholdRepository householdRepository;
    private final UserRepository userRepository;

    /**
     * Equivalent to JS getAll()
     */
    public List<RecurringFinancialRecordDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    /**
     * Equivalent to JS create(record)
     */
    public RecurringFinancialRecordDto create(CreateRecurringFinancialRecordRequest request) {

        RecurringFinancialRecord record = RecurringFinancialRecord.builder()
                .type(request.type())
                .amount(request.amount())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .frequency(request.frequency())
                .description(request.description())
                .category(categoryRepository.findById(request.categoryId()).get())
                .payer(userRepository.findById(request.payerUserId()).get())
                .build();

        RecurringFinancialRecord saved = repository.save(record);
        return toDto(saved);
    }

    /**
     * Equivalent to JS delete(id)
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /* =========================
       MAPPER
       ========================= */

    private RecurringFinancialRecordDto toDto(RecurringFinancialRecord record) {
        return new RecurringFinancialRecordDto(
                record.getId(),
                record.getType(),
                record.getAmount(),
                record.getStartDate(),
                record.getEndDate(),
                record.getFrequency(),
                record.getDescription(),
                record.getCategory().getId(),
                record.getPayer().getId()

        );
    }
}
