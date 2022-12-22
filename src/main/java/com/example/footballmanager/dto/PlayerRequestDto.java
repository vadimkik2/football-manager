package com.example.footballmanager.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerRequestDto {
    @NotNull
    private String name;
    private LocalDate age;
    @NotNull
    private LocalDate monthlyExperience;
    private Long footballTeamId;
}
