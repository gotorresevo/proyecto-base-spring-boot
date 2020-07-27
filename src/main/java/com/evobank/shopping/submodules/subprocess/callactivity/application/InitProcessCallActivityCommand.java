package com.evobank.shopping.submodules.subprocess.callactivity.application;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class InitProcessCallActivityCommand implements ICommand {
    private String var1;
}
