package com.evobank.shopping.submodules.carts.domain.vo;

import com.evobank.architecture.domain.UuidMother;

public final class ProductInCartProductMother {
    public static ProductInCartProduct create(String value) {
        return ProductInCartProduct.createFromCommand(value);
    }

    public static ProductInCartProduct random() {
        return create(UuidMother.random());
    }
}
