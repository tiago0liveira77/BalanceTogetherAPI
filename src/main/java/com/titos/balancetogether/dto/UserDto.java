package com.titos.balancetogether.dto;

import java.util.UUID;

public record UserDto(
        long id,
        String name,
        String email
) {}
