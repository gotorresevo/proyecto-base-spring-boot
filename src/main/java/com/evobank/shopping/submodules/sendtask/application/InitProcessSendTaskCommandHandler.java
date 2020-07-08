package com.evobank.shopping.submodules.sendtask.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.sendtask.businessProcess.ProcessSendTask;
import com.evobank.shopping.submodules.sendtask.domain.vo.SendTaskVar1;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessSendTaskCommandHandler implements ICommandResultHandler<InitProcessSendTaskCommand, Response> {

    private final ProcessEngine processEngine;
    private final ProcessSendTask processSendTask;

    @Override
    public Optional<Response> handle(InitProcessSendTaskCommand command) {

        processSendTask.init(SendTaskVar1.createFromCommand(command.getVar1()));
        return Optional.empty();
    }
}
