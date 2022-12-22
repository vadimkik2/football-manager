package com.example.footballmanager.repository;

import com.example.footballmanager.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount, Long> {
}
