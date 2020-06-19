package com.evobank.shopping.submodules.carts.application.addproduct;

import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProductMother;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartQuantityMother;

public final class AddProductToCartCommandMother {
    public static AddProductToCartCommand create(String idCart, String idProduct, Integer quantity) {
        return new AddProductToCartCommand(idCart, idProduct, quantity);
    }

    public static AddProductToCartCommand random() {
        return create(CartIdMother.randomCreateFromAddProductToCartCommand().getValue(),
                ProductInCartProductMother.random().getValue(),
                ProductInCartQuantityMother.random().getValue());
    }

    public static AddProductToCartCommand createIdCart(String value) {
        return create(value, ProductInCartProductMother.random().getValue(), ProductInCartQuantityMother.random().getValue());
    }
}
