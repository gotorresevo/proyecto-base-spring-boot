package com.evobank.shopping.submodules.products.application.create;

import com.evobank.shopping.submodules.products.domain.vo.ProductIdMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductNameMother;

public final class CreateProductCommandMother {
    public static CreateProductCommand create(String id, String name) {
        return new CreateProductCommand(id, name);
    }

    public static CreateProductCommand createName(String name) {
        return new CreateProductCommand(ProductIdMother.random().getValue(), name);
    }

    public static CreateProductCommand random() {
        return create(ProductIdMother.random().getValue(), ProductNameMother.random().getValue());
    }

    public static CreateProductCommand createId(String id) {
        return new CreateProductCommand(id, ProductNameMother.random().getValue());
    }
}
