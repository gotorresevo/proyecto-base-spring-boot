package com.evobank.shopping.submodules.sendtask.application;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessSendTaskCommand implements ICommand {
    private String var1;
}
