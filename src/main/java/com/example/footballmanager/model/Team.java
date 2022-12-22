package com.example.footballmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "football_teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "footballTeam")
    private List<Player> players;
    @OneToOne
    @JoinColumn(name = "bank_account")
    private BankAccount bankAccount;
    private BigDecimal commission;

    public Team(String name, BigDecimal commission, List<Player> players) {
        this.name = name;
        this.commission = commission;
        this.players = players;
    }

    public Team() {
    }
}
