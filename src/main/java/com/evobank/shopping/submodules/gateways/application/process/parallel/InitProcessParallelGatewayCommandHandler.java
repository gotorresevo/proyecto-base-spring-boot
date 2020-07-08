package com.evobank.shopping.submodules.gateways.application.process.parallel;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessParallelGatewayCommandHandler implements ICommandResultHandler<InitProcessParallelGatewayCommand, Response> {

    private final ProcessEngine processEngine;

    @Override
    public Optional<Response> handle(InitProcessParallelGatewayCommand command) {
        processEngine.getRuntimeService()
                .startProcessInstanceByKey("process-parallel-gateway");
        return Optional.empty();
    }
}
