package org.sid.bankaccountservice1.repositories;

import org.sid.bankaccountservice1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    

}
