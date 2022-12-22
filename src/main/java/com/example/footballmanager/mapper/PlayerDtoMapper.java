package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.PlayerRequestDto;
import com.example.footballmanager.dto.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerDtoMapper implements RequestDtoMapper<PlayerRequestDto, Player>,
        ResponseDtoMapper<PlayerResponseDto, Player> {
    private final TeamService teamService;

    @Override
    public Player mapToModel(PlayerRequestDto dto) {
        Player player = new Player();
        player.setName(dto.getName());
        player.setBirthDate(dto.getBirthDate());
        player.setMonthlyExperience(dto.getMonthlyExperience());
        player.setFootballTeam(teamService.getById(dto.getFootballTeamId()));
        return player;
    }

    @Override
    public PlayerResponseDto mapToDto(Player player) {
        PlayerResponseDto responseDto = new PlayerResponseDto();
        responseDto.setId(player.getId());
        responseDto.setName(player.getName());
        responseDto.setBirthDate(player.getBirthDate());
        responseDto.setMonthlyExperience(player.getMonthlyExperience());
        if (player.getFootballTeam() != null) {
            responseDto.setFootballTeamId(player.getFootballTeam().getId());
        }
        return responseDto;
    }
}
