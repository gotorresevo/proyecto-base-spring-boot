package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.application.addproduct.AddProductToCartCommand;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.*;
import org.mockito.Mockito;

public final class ProductInCartMother {

    public static ProductInCart create(CartId id, ProductInCartProduct product, ProductInCartQuantity quantity, CartValidator validator) {
        return ProductInCart.create(id, product, quantity, validator);
    }

    public static ProductInCart fromRequest(AddProductToCartCommand command, CartValidator validator) {
        return create(
            CartIdMother.createFromAddProductToCartCommand(command.getIdCart()),
                ProductInCartProductMother.create(command.getIdProduct()),
                ProductInCartQuantityMother.create(command.getQuantity()),
                validator
        );
    }

    public static ProductInCart random() {
        return create(CartIdMother.randomCreateFromAddProductToCartCommand(),
                ProductInCartProductMother.random(),
                ProductInCartQuantityMother.random(),
                Mockito.mock(CartValidator.class));
    }
}
