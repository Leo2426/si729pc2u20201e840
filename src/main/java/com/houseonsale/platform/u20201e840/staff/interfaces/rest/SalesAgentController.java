package com.houseonsale.platform.u20201e840.staff.interfaces.rest;

import com.houseonsale.platform.u20201e840.staff.domain.model.queries.GetSalesAgentByIdQuery;
import com.houseonsale.platform.u20201e840.staff.domain.services.SalesAgentCommandService;
import com.houseonsale.platform.u20201e840.staff.domain.services.SalesAgentQueryService;
import com.houseonsale.platform.u20201e840.staff.interfaces.rest.resources.CreateSalesAgentResource;
import com.houseonsale.platform.u20201e840.staff.interfaces.rest.resources.SalesAgentResource;
import com.houseonsale.platform.u20201e840.staff.interfaces.rest.transform.CreateSalesAgentCommandFromResourceAssembler;
import com.houseonsale.platform.u20201e840.staff.interfaces.rest.transform.SalesAgentResourceFronEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/sales-agent", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Sales Agents", description = "Sales Agents")
public class SalesAgentController {
    private final SalesAgentCommandService salesAgentCommandService;
    private final SalesAgentQueryService salesAgentQueryService;

    public SalesAgentController(SalesAgentCommandService salesAgentCommandService, SalesAgentQueryService salesAgentQueryService) {
        this.salesAgentCommandService = salesAgentCommandService;
        this.salesAgentQueryService = salesAgentQueryService;
    }



    /**
     * Creates a new sales agent
     * @param createSalesAgentResource the resource with the sales agent data
     * @return the sales agent resource
     * @see CreateSalesAgentResource
     * @see SalesAgentResource
     */

    @PostMapping
    public ResponseEntity<SalesAgentResource> createCourse(@RequestBody CreateSalesAgentResource createSalesAgentResource) {
        var createSalesAgentCommand = CreateSalesAgentCommandFromResourceAssembler.toCommandFromResource(createSalesAgentResource);
        var salesAgentId = salesAgentCommandService.handle(createSalesAgentCommand);
        if (salesAgentId == 0L) return ResponseEntity.badRequest().build();

        var getSalesAgemtByIdQuery = new GetSalesAgentByIdQuery(salesAgentId);

        var salesAgent = salesAgentQueryService.handle(getSalesAgemtByIdQuery);
        if (salesAgent.isEmpty()) return ResponseEntity.notFound().build();

        var salesAgentResource = SalesAgentResourceFronEntityAssembler.toResourceFromEntity(salesAgent.get());
        return new ResponseEntity<>(salesAgentResource, HttpStatus.CREATED);
    }

}
