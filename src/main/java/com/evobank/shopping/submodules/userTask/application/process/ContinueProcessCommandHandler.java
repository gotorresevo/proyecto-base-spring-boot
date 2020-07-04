package com.evobank.shopping.submodules.userTask.application.process;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler("continueProcessCommandHandlerUserTask")
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ContinueProcessCommandHandler implements ICommandResultHandler<ContinueProcessCommand, Response> {

    private final TaskService taskService;

    @Override
    public Optional<Response> handle(ContinueProcessCommand command) {

        Task task = taskService.createTaskQuery()
                .processDefinitionKey("process-user-task")
                .orderByDueDate().asc()
                .processInstanceBusinessKey(command.getVar1()).singleResult();
        taskService.claim(task.getId(), "admin");
        taskService.complete(task.getId());
        return Optional.empty();
    }
}
