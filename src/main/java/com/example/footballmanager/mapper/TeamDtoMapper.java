package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.TeamRequestDto;
import com.example.footballmanager.dto.TeamResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamDtoMapper implements RequestDtoMapper<TeamRequestDto, Team>,
        ResponseDtoMapper<TeamResponseDto, Team> {
    private final PlayerService playerService;

    @Override
    public Team mapToModel(TeamRequestDto dto) {
        Team footballTeam = new Team();
        footballTeam.setName(dto.getName());
        footballTeam.setCommission(dto.getCommission());
        if (dto.getPlayersIds() != null) {
            footballTeam.setPlayers(dto.getPlayersIds().stream()
                    .map(playerService::getByIds)
                    .collect(Collectors.toList()));
        }
        return footballTeam;
    }

    @Override
    public TeamResponseDto mapToDto(Team footballTeam) {
        TeamResponseDto responseDto = new TeamResponseDto();
        responseDto.setId(footballTeam.getId());
        responseDto.setName(footballTeam.getName());
        responseDto.setBankAccountId(footballTeam.getBankAccount().getId());
        responseDto.setCommission(footballTeam.getCommission());
        if (footballTeam.getPlayers() != null) {
            responseDto.setPlayersIds(footballTeam.getPlayers().stream()
                    .map(Player::getId)
                    .collect(Collectors.toList()));
        }
        return responseDto;
    }
}
