package com.evobank.shopping.submodules.carts.domain;

import com.evobank.architecture.domain.AggregateRoot;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.shared.carts.domain.events.CartCreatedDomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public final class Cart extends AggregateRoot {
    private final CartId id;

    public static Cart create(CartId id, CartValidator searcher) {
        Cart product = new Cart(id, searcher);
        product.record(new CartCreatedDomainEvent(id.getValue()));
        return product;
    }

    private Cart(CartId id, CartValidator searcher) {
        super(id);
        validValueObject(searcher);
        this.id = id;
    }
}
