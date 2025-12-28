package com.titos.balancetogether.dto;

import com.titos.balancetogether.enums.RecordType;

public record CreateCategoryRequest(
        String name,
        RecordType type
) {}
