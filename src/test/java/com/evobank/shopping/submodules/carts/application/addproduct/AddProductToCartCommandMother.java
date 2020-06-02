package com.evobank.shopping.submodules.carts.application.addproduct;

import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProductMother;

public final class AddProductToCartCommandMother {
    public static AddProductToCartCommand create(String idCart, String idProduct) {
        return new AddProductToCartCommand(idCart, idProduct);
    }

    public static AddProductToCartCommand random() {
        return create(CartIdMother.randomCreateFromAddProductToCartCommand().getValue(), ProductInCartProductMother.random().getValue());
    }

    public static AddProductToCartCommand createIdCart(String value) {
        return create(value, ProductInCartProductMother.random().getValue());
    }
}
