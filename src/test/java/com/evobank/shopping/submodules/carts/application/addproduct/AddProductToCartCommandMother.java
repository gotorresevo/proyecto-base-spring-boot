package com.evobank.shopping.submodules.carts.application.addproduct;

import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProductMother;

public final class AddProductToCartCommandMother {
    public static AddProductToCartICommand create(String idCart, String idProduct) {
        return new AddProductToCartICommand(idCart, idProduct);
    }

    public static AddProductToCartICommand random() {
        return create(CartIdMother.randomCreateFromAddProductToCartCommand().getValue(), ProductInCartProductMother.random().getValue());
    }

    public static AddProductToCartICommand createIdCart(String value) {
        return create(value, ProductInCartProductMother.random().getValue());
    }
}
