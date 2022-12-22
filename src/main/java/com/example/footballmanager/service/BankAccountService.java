package com.example.footballmanager.service;

import com.example.footballmanager.model.BankAccount;
import java.math.BigDecimal;

public interface BankAccountService {
    void transfer(BankAccount sender, BankAccount receiver, BigDecimal amount);

    void save(BankAccount bankAccount);

    BankAccount getById(Long id);

    BankAccount createNewBankAccountForTeam();
}
