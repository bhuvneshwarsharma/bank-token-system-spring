package com.bank.repo;

import com.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByPhoneNumber(String phoneNumber);

}
