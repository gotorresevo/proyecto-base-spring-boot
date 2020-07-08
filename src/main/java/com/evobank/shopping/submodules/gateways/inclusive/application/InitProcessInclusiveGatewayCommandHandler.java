package com.evobank.shopping.submodules.gateways.inclusive.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.inclusive.businessProcess.ProcessInclusiveGateway;
import com.evobank.shopping.submodules.gateways.inclusive.domain.vo.InclusiveGatewayValue;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessInclusiveGatewayCommandHandler implements ICommandResultHandler<InitProcessInclusiveGatewayCommand, Response> {

    private final ProcessInclusiveGateway processInclusiveGateway;

    @Override
    public Optional<Response> handle(InitProcessInclusiveGatewayCommand command) {
        processInclusiveGateway.init(InclusiveGatewayValue.createFromCommand(command.getValue()));
        return Optional.empty();
    }
}
