package com.techdenovo.app.domainmanagementappbackend.repository;

import com.techdenovo.app.domainmanagementappbackend.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain,Long> {
}
