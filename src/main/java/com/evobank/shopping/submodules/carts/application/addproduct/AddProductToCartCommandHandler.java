package com.evobank.shopping.submodules.carts.application.addproduct;

import com.evobank.architecture.domain.bus.command.CommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import com.evobank.shopping.submodules.carts.usecases.ProductAggregatorToCart;
import com.evobank.shopping.submodules.products.application.IdResponse;
import lombok.AllArgsConstructor;

import java.util.Optional;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class AddProductToCartCommandHandler implements CommandResultHandler<AddProductToCartCommand, IdResponse> {

    private final ProductAggregatorToCart aggregator;

    @Override
    public Optional<IdResponse> handle(AddProductToCartCommand command) {
        return aggregator.add(CartId.createFromAddProductToCartCommand(command.getIdCart()), ProductInCartProduct.createFromCommand(command.getIdProduct()))
                .map(productInCart -> new IdResponse(productInCart.getIdCart().getValue()));
    }
}
