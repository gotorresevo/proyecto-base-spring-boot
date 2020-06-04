package com.evobank.shopping.submodules.products.application.update;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class UpdateProductICommand implements ICommand {
    private String id;
    private String name;
}
