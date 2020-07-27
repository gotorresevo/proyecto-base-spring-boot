package com.evobank.shopping.submodules.subprocess.callactivity.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.subprocess.callactivity.businessProcess.ProcessCallActivity;
import com.evobank.shopping.submodules.subprocess.callactivity.vo.CallActivityVar1;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessCallActivityTaskCommandHandler implements ICommandResultHandler<InitProcessCallActivityCommand, Response> {

    private final ProcessCallActivity processCallActivity;

    @Override
    public Optional<Response> handle(InitProcessCallActivityCommand command) {
        processCallActivity.init(CallActivityVar1.createFromCommand(command.getVar1()));
        return Optional.empty();
    }
}
