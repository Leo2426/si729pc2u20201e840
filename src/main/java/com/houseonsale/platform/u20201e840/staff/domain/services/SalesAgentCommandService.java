package com.houseonsale.platform.u20201e840.staff.domain.services;

import com.houseonsale.platform.u20201e840.staff.domain.model.commands.CreateSalesAgentCommand;

public interface SalesAgentCommandService {
    Long handle(CreateSalesAgentCommand command);
}
