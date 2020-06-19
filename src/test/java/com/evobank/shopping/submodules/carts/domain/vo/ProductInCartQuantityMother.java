package com.evobank.shopping.submodules.carts.domain.vo;

import com.evobank.architecture.domain.IntegerMother;

public final class ProductInCartQuantityMother {
    public static ProductInCartQuantity create(Integer value) {
        return ProductInCartQuantity.createFromCommand(value);
    }

    public static ProductInCartQuantity random() {
        return create(IntegerMother.random());
    }
}
