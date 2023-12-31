package com.houseonsale.platform.u20201e840.staff.application.internal.commandservices;

import com.houseonsale.platform.u20201e840.staff.domain.model.agreggates.SalesAgent;
import com.houseonsale.platform.u20201e840.staff.domain.model.commands.CreateSalesAgentCommand;
import com.houseonsale.platform.u20201e840.staff.domain.services.SalesAgentCommandService;
import com.houseonsale.platform.u20201e840.staff.infrastructure.persistance.jpa.repositories.SalesAgentRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesAgentCommandServiceImpl implements SalesAgentCommandService {
    private final SalesAgentRepository salesAgentRepository;

    public SalesAgentCommandServiceImpl(SalesAgentRepository salesAgentRepository) {
        this.salesAgentRepository = salesAgentRepository;
    }

    @Override
    public Long handle(CreateSalesAgentCommand command) {
        if (salesAgentRepository.existsByNameAndLicenseId(command.name(), command.licenseId()))
            throw new IllegalArgumentException("SalesAgent with same name and licenseId already exists");

        if (command.commission() < 1 || command.commission()>50)
            throw new IllegalArgumentException("Commission should be between 1 and 50");


        if (command.salesCount() < 0)
            throw new IllegalArgumentException("SalesCount should be greater than or equal to zero");

        var salesAgent = new SalesAgent(command.name(), command.licenseId(), command.commission(), command.salesCount());
        salesAgentRepository.save(salesAgent);
        return salesAgent.getId();
    }
}
