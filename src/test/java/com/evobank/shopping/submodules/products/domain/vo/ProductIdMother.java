package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.UuidMother;

public final class ProductIdMother {
    public static ProductId create(String value) {
        return ProductId.createFromCommand(value);
    }

    public static ProductId update(String value) {
        return ProductId.updateFromCommand(value);
    }

    public static ProductId random() {
        return create(UuidMother.random());
    }
}
