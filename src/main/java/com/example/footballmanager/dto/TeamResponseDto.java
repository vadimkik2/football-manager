package com.example.footballmanager.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamResponseDto {
    private Long id;
    private String name;
    private List<Long> playersIds;
    private Long bankAccountId;
    private BigDecimal commission;
}
