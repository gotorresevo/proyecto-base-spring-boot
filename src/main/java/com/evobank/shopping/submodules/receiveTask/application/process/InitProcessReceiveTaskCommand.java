package com.evobank.shopping.submodules.receiveTask.application.process;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessReceiveTaskCommand implements ICommand {
    private String var1;
}
