package com.houseonsale.platform.u20201e840.staff.application.internal.queryservices;

import com.houseonsale.platform.u20201e840.staff.domain.model.agreggates.SalesAgent;
import com.houseonsale.platform.u20201e840.staff.domain.model.queries.GetSalesAgentByIdQuery;
import com.houseonsale.platform.u20201e840.staff.domain.services.SalesAgentQueryService;
import com.houseonsale.platform.u20201e840.staff.infrastructure.persistance.jpa.repositories.SalesAgentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesAgentQueryServiceImpl implements SalesAgentQueryService {
    private final SalesAgentRepository salesAgentRepository;

    public SalesAgentQueryServiceImpl(SalesAgentRepository salesAgentRepository) {
        this.salesAgentRepository = salesAgentRepository;
    }

    @Override
    public Optional<SalesAgent> handle(GetSalesAgentByIdQuery query) {
        return salesAgentRepository.findById(query.salesAgentId());
    }
}
