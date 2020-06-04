package com.evobank.shopping.submodules.products.application.update;

import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.IdResponse;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.usecases.ProductUpdater;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class UpdateProductICommandHandler implements ICommandResultHandler<UpdateProductICommand, IdResponse> {

    private final ProductUpdater updater;

    @Override
    public Optional<IdResponse> handle(UpdateProductICommand command) {
        return updater.update(ProductId.updateFromCommand(command.getId()), ProductName.updateFromCommand(command.getName()))
                .map(product -> new IdResponse(product.getId().getValue()));
    }
}
