package com.example.footballmanager.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerResponseDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate monthlyExperience;
    private Long footballTeamId;
}
