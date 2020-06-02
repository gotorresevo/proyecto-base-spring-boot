package com.evobank.shopping.submodules.carts.usecases;

import com.evobank.architecture.domain.bus.event.EventBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import com.evobank.shopping.submodules.carts.domain.Cart;
import com.evobank.shopping.submodules.carts.domain.ICartsRepository;
import com.evobank.shopping.submodules.carts.domain.factories.CartFactory;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class CartCreator {
    private final ICartsRepository cartsRepository;
    private final EventBus eventBus;
    private final CartFactory factory;

    public Optional<Cart> create(CartId id) {
        Cart cart = factory.create(id);
        cartsRepository.save(cart);
        eventBus.publish(cart.pullDomainEvents());
        return Optional.ofNullable(cart);
    }
}
