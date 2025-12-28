package com.titos.balancetogether.dto;

import com.titos.balancetogether.enums.RecordType;

public record CategoryDto(
        Long id,
        String name,
        RecordType type,
        boolean system
) {}
