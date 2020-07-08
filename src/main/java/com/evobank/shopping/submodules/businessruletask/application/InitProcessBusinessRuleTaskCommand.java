package com.evobank.shopping.submodules.businessruletask.application;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessBusinessRuleTaskCommand implements ICommand {
    private String var1;
    private String var2;
}
