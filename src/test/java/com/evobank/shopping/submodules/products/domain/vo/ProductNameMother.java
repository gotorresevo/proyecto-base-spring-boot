package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.WordMother;

public final class ProductNameMother {
    public static ProductName create(String value) {
        return ProductName.createFromCommand(value);
    }
    public static ProductName update(String value) {
        return ProductName.updateFromCommand(value);
    }

    public static ProductName random() {
        return create(WordMother.random());
    }
}
