package com.houseonsale.platform.u20201e840.staff.domain.model.agreggates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * SalesAgent
 *
 * @author Leonardo Taype
 */

@Entity
public class SalesAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private Long licenseId;
    @Getter
    private int commission;
    @Getter
    private Long salesCount;

    public SalesAgent(String name, Long licenseId, int commission, Long salesCount) {
        this.name = name;
        this.licenseId = licenseId;
        this.commission = commission;
        this.salesCount = salesCount;
    }

    public SalesAgent() {

    }
}
