package com.evobank.shopping.submodules.receiveTask.application.process;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ContinueProcessReceiveTaskCommandHandler implements ICommandResultHandler<ContinueProcessReceiveTaskCommand, Response> {

    private final RuntimeService runtimeService;

    @Override
    public Optional<Response> handle(ContinueProcessReceiveTaskCommand command) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("process-receive-task")
                .processInstanceBusinessKey(command.getVar1()).singleResult();
        Execution execution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId()).activityId("test-receive-task").singleResult();
        runtimeService.signal(execution.getId());
        return Optional.empty();
    }
}
