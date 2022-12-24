package com.example.footballmanager.util;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.service.TeamService;
import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final TeamService footballTeamService;
    private final PlayerRepository footballPlayerRepository;

    @PostConstruct
    public void inject() {
        Player firstPlayer = new Player();
        firstPlayer.setName("Oleg");
        firstPlayer.setBirthDate(LocalDate.of(1991, 2, 24));
        firstPlayer.setMonthlyExperience(LocalDate.of(2018, 7, 10));

        Player secondPlayer = new Player();
        secondPlayer.setName("Ivan");
        secondPlayer.setBirthDate(LocalDate.of(1983, 6, 11));
        secondPlayer.setMonthlyExperience(LocalDate.of(2017, 4, 18));

        Player thirdPlayer = new Player();
        thirdPlayer.setName("Roman");
        thirdPlayer.setBirthDate(LocalDate.of(1987, 10, 2));
        thirdPlayer.setMonthlyExperience(LocalDate.of(2020, 3, 8));

        Player fourthPlayer = new Player();
        fourthPlayer.setName("Victor");
        fourthPlayer.setBirthDate(LocalDate.of(1995, 11, 28));
        fourthPlayer.setMonthlyExperience(LocalDate.of(2016, 5, 10));

        Player fifthPlayer = new Player();
        fifthPlayer.setName("Vitaliy");
        fifthPlayer.setBirthDate(LocalDate.of(1992, 11, 13));
        fifthPlayer.setMonthlyExperience(LocalDate.of(2019, 2, 25));

        Player sixthPlayer = new Player();
        sixthPlayer.setName("Andriy");
        sixthPlayer.setBirthDate(LocalDate.of(1996, 4, 19));
        sixthPlayer.setMonthlyExperience(LocalDate.of(2020, 1, 24));

        Team grizzlies = new Team("grizzlies", BigDecimal.valueOf(0.5),
                List.of(firstPlayer, secondPlayer, thirdPlayer));
        footballTeamService.save(grizzlies);

        Team eagles = new Team("eagles",BigDecimal.valueOf(0.8),
                List.of(fourthPlayer, fifthPlayer, sixthPlayer));
        footballTeamService.save(eagles);

        firstPlayer.setFootballTeam(grizzlies);
        secondPlayer.setFootballTeam(grizzlies);
        thirdPlayer.setFootballTeam(grizzlies);
        fourthPlayer.setFootballTeam(eagles);
        fifthPlayer.setFootballTeam(eagles);
        sixthPlayer.setFootballTeam(eagles);
        footballPlayerRepository.save(firstPlayer);
        footballPlayerRepository.save(secondPlayer);
        footballPlayerRepository.save(thirdPlayer);
        footballPlayerRepository.save(fourthPlayer);
        footballPlayerRepository.save(fifthPlayer);
        footballPlayerRepository.save(sixthPlayer);
    }
}
