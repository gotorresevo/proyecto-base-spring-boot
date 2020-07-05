package com.evobank.shopping.submodules.sendTask.application.process;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessCommand implements ICommand {
    private String var1;
}
