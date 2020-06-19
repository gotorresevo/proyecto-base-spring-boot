package com.evobank.shopping.submodules.carts.domain;

import com.evobank.architecture.domain.AggregateRoot;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartQuantity;
import com.evobank.shopping.submodules.shared.carts.domain.events.ProductAggregateToCartDomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductInCart extends AggregateRoot {
    private final CartId idCart;
    private final ProductInCartProduct product;
    private final ProductInCartQuantity quantity;

    public static ProductInCart create(CartId id, ProductInCartProduct product, ProductInCartQuantity quantity, CartValidator validator) {
        ProductInCart productInCart = new ProductInCart(id, product, quantity, validator);
        productInCart.record(new ProductAggregateToCartDomainEvent(id.getValue(), product.getValue()));
        return productInCart;
    }

    private ProductInCart(CartId id, ProductInCartProduct product, ProductInCartQuantity quantity, CartValidator validator) {
        super(id, product, quantity);
        validValueObject(validator);
        this.idCart = id;
        this.product = product;
        this.quantity =quantity;
    }
}
