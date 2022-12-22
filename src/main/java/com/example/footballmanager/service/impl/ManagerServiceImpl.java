package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.BankAccount;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.BankAccountService;
import com.example.footballmanager.service.ManagerService;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private static final int MONTHS_IN_YEAR = 12;
    private static final BigDecimal PRICE = BigDecimal.valueOf(100000.0);
    private final BankAccountService bankAccountService;
    private final TeamService footballTeamService;
    private final PlayerService playerService;

    @Override
    @Transactional
    public Player transferPlayerToAnotherTeam(Long playerId, Long transferToTeamId) {
        Player player = playerService.getByIds(playerId);
        if (player.getFootballTeam() == null) {
            player.setFootballTeam(footballTeamService.getById(transferToTeamId));
            playerService.save(player);
            return player;
        }

        BankAccount sender = footballTeamService.getById(transferToTeamId).getBankAccount();
        BankAccount receiver = player.getFootballTeam().getBankAccount();

        bankAccountService.transfer(sender, receiver,countTransferExpenses(player));

        player.setFootballTeam(footballTeamService.getById(transferToTeamId));
        playerService.save(player);
        return player;
    }

    private BigDecimal countTransferExpenses(Player player) {
        LocalDate yearsExperience = LocalDate.now()
                .minusYears(player.getMonthlyExperience().getYear());

        int experienceInMonths = (yearsExperience.getYear() * MONTHS_IN_YEAR)
                + yearsExperience.getMonthValue();

        LocalDate playerAge = LocalDate.now().minusYears(player.getBirthDate().getYear());
        BigDecimal transferCost = PRICE.multiply(BigDecimal.valueOf(experienceInMonths))
                .divide(BigDecimal.valueOf(playerAge.getYear()), RoundingMode.FLOOR);
        BigDecimal commissionPrice = transferCost
                .multiply(player.getFootballTeam().getCommission());
        return transferCost.add(commissionPrice);
    }
}
