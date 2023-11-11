package com.houseonsale.platform.u20201e840.staff.interfaces.rest.transform;

import com.houseonsale.platform.u20201e840.staff.domain.model.agreggates.SalesAgent;
import com.houseonsale.platform.u20201e840.staff.interfaces.rest.resources.SalesAgentResource;

public class SalesAgentResourceFronEntityAssembler {
    public static SalesAgentResource toResourceFromEntity(SalesAgent entity) {
        return new SalesAgentResource(
                entity.getId(),
                entity.getName(),
                entity.getLicenseId(),
                entity.getCommission(),
                entity.getSalesCount());
    }
}
