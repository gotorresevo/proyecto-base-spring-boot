package com.evobank.shopping.submodules.userTask.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.bpm.IBpmEngine;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.userTask.businessProcess.ProcessUserTask;
import com.evobank.shopping.submodules.userTask.domain.vo.UserTaskVar1;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ContinueProcessUserTaskCommandHandler implements ICommandResultHandler<ContinueProcessUserTaskCommand, Response> {

    private final ProcessUserTask processUserTask;

    @Override
    public Optional<Response> handle(ContinueProcessUserTaskCommand command) {
        processUserTask.toContinue(UserTaskVar1.createFromCommand(command.getVar1()));
        return Optional.empty();
    }
}
