package com.evobank.shopping.submodules.userTask.application.process;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class ContinueProcessCommand implements ICommand {
    private String var1;
}
