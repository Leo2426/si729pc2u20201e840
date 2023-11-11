package com.houseonsale.platform.u20201e840.staff.domain.services;

import com.houseonsale.platform.u20201e840.staff.domain.model.agreggates.SalesAgent;
import com.houseonsale.platform.u20201e840.staff.domain.model.queries.GetSalesAgentByIdQuery;

import java.util.Optional;

public interface SalesAgentQueryService {
    Optional<SalesAgent> handle(GetSalesAgentByIdQuery query);
}
