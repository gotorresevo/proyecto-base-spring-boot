package com.evobank.shopping.submodules.carts.usecases;

import com.evobank.architecture.domain.bus.event.EventBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import com.evobank.shopping.submodules.carts.domain.ICartsRepository;
import com.evobank.shopping.submodules.carts.domain.ProductInCart;
import com.evobank.shopping.submodules.carts.domain.factories.CartFactory;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class ProductAggregatorToCart {
    private final ICartsRepository cartsRepository;
    private final EventBus eventBus;
    private final CartFactory factory;

    public Optional<ProductInCart> add(CartId id, ProductInCartProduct product) {
        ProductInCart productInCart = factory.create(id, product);
        cartsRepository.addProductToCart(productInCart);
        eventBus.publish(productInCart.pullDomainEvents());
        return Optional.ofNullable(productInCart);
    }
}
