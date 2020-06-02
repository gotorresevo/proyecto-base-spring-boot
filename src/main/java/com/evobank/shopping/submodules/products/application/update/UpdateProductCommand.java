package com.evobank.shopping.submodules.products.application.update;

import com.evobank.architecture.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class UpdateProductCommand implements Command {
    private String id;
    private String name;
}
