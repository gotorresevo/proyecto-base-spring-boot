package com.evobank.shopping.submodules.receivetask.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.receivetask.businessProcess.ProcessReceiveTask;
import com.evobank.shopping.submodules.receivetask.domain.vo.ReceiveTaskVar1;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ContinueProcessReceiveTaskCommandHandler implements ICommandResultHandler<ContinueProcessReceiveTaskCommand, Response> {

    private final ProcessReceiveTask processReceiveTask;

    @Override
    public Optional<Response> handle(ContinueProcessReceiveTaskCommand command) {
        processReceiveTask.toContinue(ReceiveTaskVar1.createFromCommand(command.getVar1()));
        return Optional.empty();
    }
}
