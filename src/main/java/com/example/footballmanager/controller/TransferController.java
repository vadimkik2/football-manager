package com.example.footballmanager.controller;

import com.example.footballmanager.dto.PlayerResponseDto;
import com.example.footballmanager.mapper.PlayerDtoMapper;
import com.example.footballmanager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players-transfer")
public class TransferController {
    private final ManagerService managerService;
    private final PlayerDtoMapper playerDtoMapper;

    @GetMapping("/player-id/{player-id}/team-id/{team-id}")
    public PlayerResponseDto transferPLayer(@PathVariable(name = "player-id") Long playerId,
                                                    @PathVariable(name = "team-id") Long teamId) {
        return playerDtoMapper.mapToDto(
                managerService.transferPlayerToAnotherTeam(playerId, teamId));
    }
}
