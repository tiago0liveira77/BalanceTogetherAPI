package com.titos.balancetogether.controller;

import com.titos.balancetogether.dto.CreateFinancialRecordRequest;
import com.titos.balancetogether.dto.FinancialRecordDto;
import com.titos.balancetogether.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial-records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService financialRecordService;

    /**
     * Equivalent to:
     * financialRecordService.getAll()
     */
    @GetMapping
    public List<FinancialRecordDto> getAll() {
        return financialRecordService.getAll();
    }

    /**
     * Equivalent to:
     * financialRecordService.create(record)
     */
    @PostMapping
    public FinancialRecordDto create(
            @RequestBody CreateFinancialRecordRequest request
    ) {
        return financialRecordService.create(request);
    }

    /**
     * Equivalent to:
     * financialRecordService.delete(id)
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        financialRecordService.delete(id);
    }
}
