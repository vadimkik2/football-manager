package com.example.footballmanager.service.impl;

import com.example.footballmanager.dto.PlayerRequestDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.repository.TeamRepository;
import com.example.footballmanager.service.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository footballPlayerRepository;
    private final TeamRepository teamRepository;

    @Override
    public Player save(Player footballPLayer) {
        return footballPlayerRepository.save(footballPLayer);
    }

    @Override
    public Player getByIds(Long id) {
        if (!footballPlayerRepository.existsById(id)) {
            throw new EntityNotFoundException("Football player with id: " + id + " not found");
        }
        return footballPlayerRepository.getReferenceById(id);
    }

    @Override
    public List<Player> getAllByIds(List<Long> id) {
        return footballPlayerRepository.findAllById(id);
    }

    @Override
    public void delete(Long id) {
        footballPlayerRepository.deleteById(id);
    }

    @Override
    public Player update(Long id, PlayerRequestDto requestDto) {
        if (!footballPlayerRepository.existsById(id)) {
            throw new EntityNotFoundException("Football player with id " + id + " not found.");
        }
        Player footballPlayer = footballPlayerRepository.getReferenceById(id);
        if (requestDto.getName() != null) {
            footballPlayer.setName(requestDto.getName());
        }
        if (requestDto.getBirthDate() != null) {
            footballPlayer.setBirthDate(requestDto.getBirthDate());
        }
        if (requestDto.getMonthlyExperience() != null) {
            footballPlayer.setMonthlyExperience(requestDto.getMonthlyExperience());
        }
        if (requestDto.getFootballTeamId() != null) {
            footballPlayer.setFootballTeam(
                    teamRepository.getReferenceById(requestDto.getFootballTeamId()));
        }
        return footballPlayerRepository.save(footballPlayer);
    }

    @Override
    public List<Player> getPlayersByTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new EntityNotFoundException("Team with id " + id + " not found.");
        }
        return footballPlayerRepository.getAllByFootballTeamId(id);
    }

    @Override
    public List<Player> getAll() {
        return footballPlayerRepository.findAll();
    }
}
