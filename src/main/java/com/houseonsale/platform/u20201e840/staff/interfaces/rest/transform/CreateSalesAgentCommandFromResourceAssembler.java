package com.houseonsale.platform.u20201e840.staff.interfaces.rest.transform;

import com.houseonsale.platform.u20201e840.staff.domain.model.commands.CreateSalesAgentCommand;
import com.houseonsale.platform.u20201e840.staff.interfaces.rest.resources.CreateSalesAgentResource;

public class CreateSalesAgentCommandFromResourceAssembler {
    public static CreateSalesAgentCommand toCommandFromResource(CreateSalesAgentResource resource) {
        return new CreateSalesAgentCommand(
                resource.name(),
                resource.licenseId(),
                resource.commission(),
                resource.salesCount());
    }
}
