package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.application.addproduct.AddProductToCartCommand;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProductMother;
import org.mockito.Mockito;

public final class ProductInCartMother {

    public static ProductInCart create(CartId id, ProductInCartProduct product, CartValidator validator) {
        return ProductInCart.create(id, product, validator);
    }

    public static ProductInCart fromRequest(AddProductToCartCommand command, CartValidator validator) {
        return create(
            CartIdMother.createFromAddProductToCartCommand(command.getIdCart()), ProductInCartProductMother.create(command.getIdProduct()), validator
        );
    }

    public static ProductInCart random() {
        return create(CartIdMother.randomCreateFromAddProductToCartCommand(), ProductInCartProductMother.random(), Mockito.mock(CartValidator.class));
    }
}
