package com.example.footballmanager.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamRequestDto {
    @NotNull
    private String name;
    private List<Long> playersIds;
    private Long bankAccountId;
    @DecimalMin("0.0") @DecimalMax("0.1")
    private BigDecimal commission;
}
