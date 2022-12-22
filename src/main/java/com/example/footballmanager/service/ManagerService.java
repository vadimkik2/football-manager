package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;

public interface ManagerService {
    Player transferPlayerToAnotherTeam(Long playerId, Long transferToTeamId);
}
