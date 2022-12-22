package com.example.footballmanager.service;

import com.example.footballmanager.dto.PlayerRequestDto;
import com.example.footballmanager.model.Player;
import java.util.List;

public interface PlayerService {
    Player save(Player footballTeam);

    Player getByIds(Long id);

    List<Player> getAllByIds(List<Long> id);

    void delete(Long id);

    Player update(Long id, PlayerRequestDto requestDto);

    List<Player> getPlayersByTeam(Long id);

    List<Player> getAll();
}
