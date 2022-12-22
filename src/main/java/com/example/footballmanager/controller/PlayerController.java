package com.example.footballmanager.controller;

import com.example.footballmanager.dto.PlayerRequestDto;
import com.example.footballmanager.dto.PlayerResponseDto;
import com.example.footballmanager.mapper.PlayerDtoMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
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
@RequestMapping("/football-players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService footballPlayerService;
    private final PlayerDtoMapper playerDtoMapper;

    @PostMapping
    public PlayerResponseDto save(@RequestBody @Valid PlayerRequestDto dto) {
        Player player = footballPlayerService.save(playerDtoMapper.mapToModel(dto));
        return playerDtoMapper.mapToDto(player);
    }

    @GetMapping("/{id}")
    public PlayerResponseDto getById(@PathVariable Long id) {
        return playerDtoMapper.mapToDto(footballPlayerService.getByIds(id));
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id,
                                    @RequestBody PlayerRequestDto dto) {
        Player player = footballPlayerService.update(id, dto);
        return playerDtoMapper.mapToDto(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        footballPlayerService.delete(id);
    }

    @GetMapping("/by-team/{team-id}")
    public List<PlayerResponseDto> getPlayersByTeam(
            @PathVariable(name = "team-id") Long teamId) {
        return footballPlayerService.getPlayersByTeam(teamId).stream()
                .filter(p -> p.getFootballTeam().getId().equals(teamId))
                .map(playerDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<PlayerResponseDto> getAllPlayers() {
        return footballPlayerService.getAll().stream()
                .map(playerDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
