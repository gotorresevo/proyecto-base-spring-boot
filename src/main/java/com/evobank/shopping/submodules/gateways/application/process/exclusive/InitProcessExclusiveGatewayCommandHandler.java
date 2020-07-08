package com.evobank.shopping.submodules.gateways.application.process.exclusive;

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
public final class InitProcessExclusiveGatewayCommandHandler implements ICommandResultHandler<InitProcessExclusiveGatewayCommand, Response> {

    private final ProcessEngine processEngine;

    @Override
    public Optional<Response> handle(InitProcessExclusiveGatewayCommand command) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("value", command.getValue());
        processEngine.getRuntimeService()
                .startProcessInstanceByKey("process-exclusive-gateway", command.getValue(), variables);
        return Optional.empty();
    }
}
