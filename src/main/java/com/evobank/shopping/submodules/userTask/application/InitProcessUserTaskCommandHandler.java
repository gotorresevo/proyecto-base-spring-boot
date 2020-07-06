package com.evobank.shopping.submodules.userTask.application;

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
public final class InitProcessUserTaskCommandHandler implements ICommandResultHandler<InitProcessUserTaskCommand, Response> {

    private final ProcessEngine processEngine;

    @Override
    public Optional<Response> handle(InitProcessUserTaskCommand command) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("var1", command.getVar1());
        processEngine.getRuntimeService()
                .startProcessInstanceByKey("process-user-task", command.getVar1(), variables);
        return Optional.empty();
    }
}
