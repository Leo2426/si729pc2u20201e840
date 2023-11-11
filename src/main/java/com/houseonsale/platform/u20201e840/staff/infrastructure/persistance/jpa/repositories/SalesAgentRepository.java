package com.houseonsale.platform.u20201e840.staff.infrastructure.persistance.jpa.repositories;

import com.houseonsale.platform.u20201e840.staff.domain.model.agreggates.SalesAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAgentRepository extends JpaRepository<SalesAgent, Long> {
}
