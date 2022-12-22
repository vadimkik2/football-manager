package com.example.footballmanager.util;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
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
    private final PlayerService footballPlayerService;

    @PostConstruct
    public void inject() {
        Player firstPlayer = new Player("Oleg",
                LocalDate.of(1991, 2, 24),
                LocalDate.of(2018, 7, 10));
        Player secondPlayer = new Player("Ivan",
                LocalDate.of(1983, 6, 11),
                LocalDate.of(2017, 4, 18));
        Player thirdPlayer = new Player("Roman",
                LocalDate.of(1987, 10, 2),
                LocalDate.of(2020, 3, 8));
        Player fourthPlayer = new Player("Victor",
                LocalDate.of(1995, 11, 28),
                LocalDate.of(2016, 5, 10));
        Player fifthPlayer = new Player("Vitaliy",
                LocalDate.of(1992, 11, 13),
                LocalDate.of(2019, 2, 25));
        Player sixthPlayer = new Player("Andriy",
                LocalDate.of(1996, 4, 19),
                LocalDate.of(2020, 1, 24));

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
        footballPlayerService.save(firstPlayer);
        footballPlayerService.save(secondPlayer);
        footballPlayerService.save(thirdPlayer);
        footballPlayerService.save(fourthPlayer);
        footballPlayerService.save(fifthPlayer);
        footballPlayerService.save(sixthPlayer);
    }
}
