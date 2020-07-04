package com.evobank.shopping.submodules.receiveTask.application.process;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler("continueProcessCommandHandlerReceiveTask")
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ContinueProcessCommandHandler implements ICommandResultHandler<ContinueProcessCommand, Response> {

    private final RuntimeService runtimeService;

    @Override
    public Optional<Response> handle(ContinueProcessCommand command) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("process-receive-task")
                .processInstanceBusinessKey(command.getVar1()).singleResult();
        Execution execution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId()).activityId("test-receive-task").singleResult();
        runtimeService.signal(execution.getId());
        return Optional.empty();
    }
}
