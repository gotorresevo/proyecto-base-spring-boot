package com.evobank.shopping.submodules.gateways.application.process.inclusive;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessInclusiveGatewayCommand implements ICommand {
    private String value;
}
