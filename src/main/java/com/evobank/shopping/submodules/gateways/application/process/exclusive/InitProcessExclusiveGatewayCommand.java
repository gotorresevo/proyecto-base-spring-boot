package com.evobank.shopping.submodules.gateways.application.process.exclusive;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessExclusiveGatewayCommand implements ICommand {
    private String value;
}
