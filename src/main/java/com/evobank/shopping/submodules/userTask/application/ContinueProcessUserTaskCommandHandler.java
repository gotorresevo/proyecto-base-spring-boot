package com.evobank.shopping.submodules.userTask.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ContinueProcessUserTaskCommandHandler implements ICommandResultHandler<ContinueProcessUserTaskCommand, Response> {

    private final TaskService taskService;

    @Override
    public Optional<Response> handle(ContinueProcessUserTaskCommand command) {

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("process-user-task")
                .orderByDueDate().asc()
                .processInstanceBusinessKey(command.getVar1()).singleResult();
        taskService.claim(task.getId(), "admin");
        taskService.complete(task.getId());
        return Optional.empty();
    }
}
