package com.evobank.shopping.submodules.products.application.create;

import com.evobank.architecture.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CreateProductCommand implements Command {
    private String id;
    private String name;
}
