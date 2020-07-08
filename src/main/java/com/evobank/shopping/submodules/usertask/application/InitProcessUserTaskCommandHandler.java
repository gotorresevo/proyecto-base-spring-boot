package com.evobank.shopping.submodules.usertask.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.usertask.businessProcess.ProcessUserTask;
import com.evobank.shopping.submodules.usertask.domain.vo.UserTaskVar1;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessUserTaskCommandHandler implements ICommandResultHandler<InitProcessUserTaskCommand, Response> {

    private final ProcessUserTask processUserTask;

    @Override
    public Optional<Response> handle(InitProcessUserTaskCommand command) {
        processUserTask.init(UserTaskVar1.createFromCommand(command.getVar1()));
        return Optional.empty();
    }
}
