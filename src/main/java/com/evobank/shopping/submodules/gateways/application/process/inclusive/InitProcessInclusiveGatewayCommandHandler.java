package com.evobank.shopping.submodules.gateways.application.process.inclusive;

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
public final class InitProcessInclusiveGatewayCommandHandler implements ICommandResultHandler<InitProcessInclusiveGatewayCommand, Response> {

    private final ProcessEngine processEngine;

    @Override
    public Optional<Response> handle(InitProcessInclusiveGatewayCommand command) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("value", command.getValue());
        processEngine.getRuntimeService()
                .startProcessInstanceByKey("process-inclusive-gateway", command.getValue(), variables);
        return Optional.empty();
    }
}
