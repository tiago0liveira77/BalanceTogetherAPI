package com.titos.balancetogether.service;

import com.titos.balancetogether.dto.CreateFinancialRecordRequest;
import com.titos.balancetogether.dto.FinancialRecordDto;
import com.titos.balancetogether.model.FinancialRecord;
import com.titos.balancetogether.repository.CategoryRepository;
import com.titos.balancetogether.repository.FinancialRecordRepository;
import com.titos.balancetogether.repository.HouseholdRepository;
import com.titos.balancetogether.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialRecordService {

    private final FinancialRecordRepository repository;
    private final CategoryRepository categoryRepository;
    private final HouseholdRepository householdRepository;
    private final UserRepository userRepository;

    /**
     * Equivalent to JS getAll()
     */
    public List<FinancialRecordDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    /**
     * Equivalent to JS create(record)
     */
    public FinancialRecordDto create(CreateFinancialRecordRequest request) {

        FinancialRecord record = FinancialRecord.builder()
                .type(request.type())
                .amount(request.amount())
                .date(request.date())
                .description(request.description())
                .category(categoryRepository.findById(request.categoryId()).get())
                .household(householdRepository.findById(request.householdId()).get())
                .payer(userRepository.findById(request.payerUserId()).get())
                .build();

        FinancialRecord saved = repository.save(record);
        return toDto(saved);
    }

    /**
     * Equivalent to JS delete(id)
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /* =========================
       MAPPERS
       ========================= */

    private FinancialRecordDto toDto(FinancialRecord record) {
        return new FinancialRecordDto(
                record.getId(),
                record.getType(),
                record.getAmount(),
                record.getDate(),
                record.getDescription(),
                record.getCategory().getId(),
                record.getHousehold().getId(),
                record.getPayer().getId()
        );
    }
}
