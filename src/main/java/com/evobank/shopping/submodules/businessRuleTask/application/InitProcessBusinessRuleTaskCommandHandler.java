package com.evobank.shopping.submodules.businessRuleTask.application;

import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.businessRuleTask.businessProcess.ProcessBusinessRuleTask;
import com.evobank.shopping.submodules.businessRuleTask.domain.vo.BusinessRuleTaskGuestCount;
import com.evobank.shopping.submodules.businessRuleTask.domain.vo.BusinessRuleTaskSeason;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessBusinessRuleTaskCommandHandler implements ICommandResultHandler<InitProcessBusinessRuleTaskCommand, ResultResponse> {

    private final ProcessBusinessRuleTask processBusinessRuleTask;

    @Override
    public Optional<ResultResponse> handle(InitProcessBusinessRuleTaskCommand command) {
        return Optional.of(new ResultResponse(
                processBusinessRuleTask.init(
                        BusinessRuleTaskSeason.createFromCommand(command.getVar1()),
                        BusinessRuleTaskGuestCount.createFromCommand(Integer.parseInt(command.getVar2()))
                ).collect(Collectors.toList())
        ));
    }
}
