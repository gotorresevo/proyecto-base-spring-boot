package com.evobank.shopping.submodules.carts.application.create;

import com.evobank.architecture.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CreateCartCommand implements Command {
    private String id;
}
