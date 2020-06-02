package com.evobank.shopping.submodules.carts.domain.vo;

import com.evobank.architecture.domain.UuidMother;

public final class CartIdMother {
    public static CartId createFromAddProductToCartCommand(String value) {
        return CartId.createFromAddProductToCartCommand(value);
    }

    public static CartId createFromCreateCartCommand(String value) {
        return CartId.createFromCreateCartCommand(value);
    }

    public static CartId randomCreateFromCreateCartCommand() {
        return createFromCreateCartCommand(UuidMother.random());
    }

    public static CartId randomCreateFromAddProductToCartCommand() {
        return createFromAddProductToCartCommand(UuidMother.random());
    }
}
