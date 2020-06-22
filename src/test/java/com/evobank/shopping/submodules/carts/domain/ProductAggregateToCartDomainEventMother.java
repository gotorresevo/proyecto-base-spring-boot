package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.domain.vo.*;
import com.evobank.shopping.submodules.shared.carts.domain.events.ProductAggregateToCartDomainEvent;

public final class ProductAggregateToCartDomainEventMother {
    public static ProductAggregateToCartDomainEvent create(CartId id, ProductInCartProduct product, ProductInCartQuantity quantity) {
        return new ProductAggregateToCartDomainEvent(id.getValue(), product.getValue(), quantity.getValue());
    }

    public static ProductAggregateToCartDomainEvent fromProductInCart(ProductInCart productInCart) {
        return create(productInCart.getIdCart(), productInCart.getProduct(), productInCart.getQuantity());
    }

    public static ProductAggregateToCartDomainEvent random() {
        return create(CartIdMother.randomCreateFromAddProductToCartCommand(), ProductInCartProductMother.random(), ProductInCartQuantityMother.random());
    }
}
