package com.evobank.shopping.submodules.products.application.create;

import com.evobank.shopping.submodules.products.domain.vo.ProductIdMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductNameMother;

public final class CreateProductCommandMother {
    public static CreateProductICommand create(String id, String name) {
        return new CreateProductICommand(id, name);
    }

    public static CreateProductICommand createName(String name) {
        return new CreateProductICommand(ProductIdMother.random().getValue(), name);
    }

    public static CreateProductICommand random() {
        return create(ProductIdMother.random().getValue(), ProductNameMother.random().getValue());
    }

    public static CreateProductICommand createId(String id) {
        return new CreateProductICommand(id, ProductNameMother.random().getValue());
    }
}
