package com.example.footballmanager.service;

import com.example.footballmanager.dto.TeamRequestDto;
import com.example.footballmanager.model.Team;
import java.util.List;

public interface TeamService {
    Team save(Team footballTeam);

    Team getById(Long id);

    void delete(Long id);

    Team update(Long id, TeamRequestDto teamRequestDto);

    List<Team> getAll();
}
