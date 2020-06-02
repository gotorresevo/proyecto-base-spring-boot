package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProductMother;
import com.evobank.shopping.submodules.shared.carts.domain.events.ProductAggregateToCartDomainEvent;

public final class ProductAggregateToCartDomainEventMother {
    public static ProductAggregateToCartDomainEvent create(CartId id, ProductInCartProduct product) {
        return new ProductAggregateToCartDomainEvent(id.getValue(), product.getValue());
    }

    public static ProductAggregateToCartDomainEvent fromProductInCart(ProductInCart productInCart) {
        return create(productInCart.getIdCart(), productInCart.getProduct());
    }

    public static ProductAggregateToCartDomainEvent random() {
        return create(CartIdMother.randomCreateFromAddProductToCartCommand(), ProductInCartProductMother.random());
    }
}
