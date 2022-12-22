package com.example.footballmanager.controller;

import com.example.footballmanager.dto.TeamRequestDto;
import com.example.footballmanager.dto.TeamResponseDto;
import com.example.footballmanager.mapper.TeamDtoMapper;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.TeamService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/football-teams")
public class TeamController {
    private final TeamService footballTeamService;

    @PostMapping
    public TeamResponseDto save(@RequestBody @Valid TeamRequestDto dto) {
        Team footballTeam = footballTeamService.save(TeamDtoMapper.INSTANCE.mapToModel(dto));
        return TeamDtoMapper.INSTANCE.mapToDto(footballTeam);
    }

    @GetMapping("/{id}")
    public TeamResponseDto findById(@PathVariable Long id) {
        Team footballTeam = footballTeamService.getById(id);
        return TeamDtoMapper.INSTANCE.mapToDto(footballTeam);
    }

    @PutMapping("/{id}")
    public TeamResponseDto update(@PathVariable Long id,
                                  @RequestBody TeamRequestDto dto) {
        Team footballTeam = footballTeamService.update(id, dto);
        return TeamDtoMapper.INSTANCE.mapToDto(footballTeam);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        footballTeamService.delete(id);
    }

    @GetMapping
    public List<TeamResponseDto> getAll() {
        return footballTeamService.getAll().stream()
                .map(TeamDtoMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
