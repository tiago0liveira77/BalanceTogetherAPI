package com.titos.balancetogether.controller;

import com.titos.balancetogether.dto.CreateRecurringFinancialRecordRequest;
import com.titos.balancetogether.dto.RecurringFinancialRecordDto;
import com.titos.balancetogether.service.RecurringFinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recurring-records")
@RequiredArgsConstructor
public class RecurringFinancialRecordController {

    private final RecurringFinancialRecordService recurringService;

    @GetMapping
    public List<RecurringFinancialRecordDto> getAll() {
        return recurringService.getAll();
    }

    @PostMapping
    public RecurringFinancialRecordDto create(
            @RequestBody CreateRecurringFinancialRecordRequest request
    ) {
        return recurringService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recurringService.delete(id);
    }
}
