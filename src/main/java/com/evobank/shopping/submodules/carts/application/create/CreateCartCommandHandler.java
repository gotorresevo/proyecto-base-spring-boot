package com.evobank.shopping.submodules.carts.application.create;

import com.evobank.architecture.domain.bus.command.CommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.usecases.CartCreator;
import com.evobank.shopping.submodules.products.application.IdResponse;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class CreateCartCommandHandler implements CommandResultHandler<CreateCartCommand, IdResponse> {

    private final CartCreator creator;

    @Override
    public Optional<IdResponse> handle(CreateCartCommand command) {
        return creator.create(CartId.createFromCreateCartCommand(command.getId()))
                .map(product -> new IdResponse(product.getId().getValue()));
    }
}
