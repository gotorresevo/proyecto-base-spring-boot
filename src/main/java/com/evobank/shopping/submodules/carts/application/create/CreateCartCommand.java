package com.evobank.shopping.submodules.carts.application.create;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CreateCartCommand implements ICommand {
    private String id;
}
