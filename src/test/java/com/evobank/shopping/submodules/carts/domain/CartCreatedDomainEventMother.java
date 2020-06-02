package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;
import com.evobank.shopping.submodules.shared.carts.domain.events.CartCreatedDomainEvent;

public final class CartCreatedDomainEventMother {
    public static CartCreatedDomainEvent create(CartId id) {
        return new CartCreatedDomainEvent(id.getValue());
    }

    public static CartCreatedDomainEvent fromCart(Cart product) {
        return create(product.getId());
    }

    public static CartCreatedDomainEvent random() {
        return create(CartIdMother.randomCreateFromCreateCartCommand());
    }
}
