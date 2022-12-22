package com.example.footballmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
@Table(name = "football_players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    @Column(name = "monthly_Experience")
    private LocalDate monthlyExperience;
    @ManyToOne
    @JoinColumn(name = "football_team")
    private Team footballTeam;

    public Player(String name, LocalDate birthDate, LocalDate monthlyExperience) {
        this.name = name;
        this.birthDate = birthDate;
        this.monthlyExperience = monthlyExperience;
    }

    public Player() {
    }
}
