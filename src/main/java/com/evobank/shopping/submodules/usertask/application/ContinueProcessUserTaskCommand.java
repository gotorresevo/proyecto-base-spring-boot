package com.evobank.shopping.submodules.usertask.application;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class ContinueProcessUserTaskCommand implements ICommand {
    private String var1;
}
