package com.bank.repo;

import com.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
@Repository
public interface BankRepo extends JpaRepository<Bank, Long> {

}
