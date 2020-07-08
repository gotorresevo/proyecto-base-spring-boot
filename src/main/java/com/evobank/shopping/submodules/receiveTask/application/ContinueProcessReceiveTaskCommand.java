package com.evobank.shopping.submodules.receiveTask.application;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class ContinueProcessReceiveTaskCommand implements ICommand {
    private String var1;
}
