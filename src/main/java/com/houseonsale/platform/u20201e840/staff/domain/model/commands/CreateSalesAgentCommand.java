package com.houseonsale.platform.u20201e840.staff.domain.model.commands;

public record CreateSalesAgentCommand(String name, Long licenseId, int commission, Long salesCount) {
}
