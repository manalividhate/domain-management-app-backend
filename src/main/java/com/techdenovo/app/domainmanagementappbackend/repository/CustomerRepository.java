package com.techdenovo.app.domainmanagementappbackend.repository;

import com.techdenovo.app.domainmanagementappbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long > {
}
