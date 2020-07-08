package com.evobank.shopping.submodules.gateways.inclusive.application;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessInclusiveGatewayCommand implements ICommand {
    private String value;
}
