package com.evobank.shopping.submodules.products.application.create;

import com.evobank.architecture.domain.bus.command.CommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.IdResponse;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.usecases.ProductCreator;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class gitCreateProductCommandHandler implements CommandResultHandler<CreateProductCommand, IdResponse> {

    private final ProductCreator creator;

    @Override
    public Optional<IdResponse> handle(CreateProductCommand command) {
        return creator.create(ProductId.createFromCommand(command.getId()), ProductName.createFromCommand(command.getName()))
                .map(product -> new IdResponse(product.getId().getValue()));
    }
}
