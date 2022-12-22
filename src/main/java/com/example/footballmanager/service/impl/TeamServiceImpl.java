package com.example.footballmanager.service.impl;

import com.example.footballmanager.dto.TeamRequestDto;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.TeamRepository;
import com.example.footballmanager.service.BankAccountService;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final PlayerService playerService;
    private final TeamRepository footballTeamRepository;
    private final BankAccountService bankAccountService;

    @Override
    @Transactional
    public Team save(Team footballTeam) {
        if (footballTeam.getBankAccount() == null) {
            footballTeam.setBankAccount(bankAccountService.createNewBankAccountForTeam());
            return footballTeamRepository.save(footballTeam);
        }
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public Team getById(Long id) {
        if (!footballTeamRepository.existsById(id)) {
            throw new RuntimeException("Football team with id: " + id + " not found.");
        }
        return footballTeamRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        footballTeamRepository.deleteById(id);
    }

    @Override
    public Team update(Long id, TeamRequestDto teamRequestDto) {
        if (!footballTeamRepository.existsById(id)) {
            throw new RuntimeException("Team with id " + id + " not found.");
        }

        Team footballTeam = footballTeamRepository.getReferenceById(id);
        if (teamRequestDto.getName() != null) {
            footballTeam.setName(teamRequestDto.getName());
        }
        if (teamRequestDto.getPlayersIds() != null && !teamRequestDto.getPlayersIds().isEmpty()) {
            footballTeam.setPlayers(playerService.getAllByIds(teamRequestDto.getPlayersIds()));
        }
        if (teamRequestDto.getBankAccountId() != null) {
            footballTeam.setBankAccount(
                    bankAccountService.getById(teamRequestDto.getBankAccountId()));
        }
        if (teamRequestDto.getCommission() != null) {
            footballTeam.setCommission(teamRequestDto.getCommission());
        }
        footballTeamRepository.save(footballTeam);
        return footballTeam;
    }

    @Override
    public List<Team> getAll() {
        return footballTeamRepository.findAll();
    }
}
