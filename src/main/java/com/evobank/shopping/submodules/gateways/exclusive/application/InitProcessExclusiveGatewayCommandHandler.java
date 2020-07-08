package com.evobank.shopping.submodules.gateways.exclusive.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.exclusive.businessProcess.ProcessExclusiveGateway;
import com.evobank.shopping.submodules.gateways.exclusive.domain.vo.ExclusiveGatewayValue;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessExclusiveGatewayCommandHandler implements ICommandResultHandler<InitProcessExclusiveGatewayCommand, Response> {

    private final ProcessExclusiveGateway processExclusiveGateway;

    @Override
    public Optional<Response> handle(InitProcessExclusiveGatewayCommand command) {
        processExclusiveGateway.init(ExclusiveGatewayValue.createFromCommand(command.getValue()));
        return Optional.empty();
    }
}
