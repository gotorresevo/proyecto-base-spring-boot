package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.IntegerMother;
import com.evobank.architecture.domain.WordMother;

public final class ProductStockMother {
    public static ProductStock create(Integer value) {
        return ProductStock.createFromCommand(value);
    }
    public static ProductStock update(Integer value) {
        return ProductStock.updateFromCommand(value);
    }

    public static ProductStock random() {
        return create(IntegerMother.random());
    }
}
