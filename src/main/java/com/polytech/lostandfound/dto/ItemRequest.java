package com.polytech.lostandfound.dto;

import com.polytech.lostandfound.model.ItemStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ItemRequest(
        @NotBlank @Size(max = 120) String title,
        @NotBlank @Size(max = 2000) String description,
        @NotBlank @Size(max = 80) String category,
        @NotBlank @Size(max = 200) String location,
        @NotNull LocalDate date,
        @NotNull ItemStatus status
) {
}
