package com.evobank.shopping.submodules.gateways.parallel.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.parallel.businessProcess.ProcessParallelGateway;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessParallelGatewayCommandHandler implements ICommandResultHandler<InitProcessParallelGatewayCommand, Response> {

    private final ProcessParallelGateway processParallelGateway;

    @Override
    public Optional<Response> handle(InitProcessParallelGatewayCommand command) {
        processParallelGateway.init();
        return Optional.empty();
    }
}
