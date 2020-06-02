package com.evobank.shopping.submodules.products.application.update;

import com.evobank.shopping.submodules.products.application.create.CreateProductCommand;
import com.evobank.shopping.submodules.products.domain.vo.ProductIdMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductNameMother;

public final class UpdateProductCommandMother {
    public static UpdateProductCommand create(String id, String name) {
        return new UpdateProductCommand(id, name);
    }

    public static UpdateProductCommand createName(String name) {
        return new UpdateProductCommand(ProductIdMother.random().getValue(), name);
    }

    public static UpdateProductCommand random() {
        return create(ProductIdMother.random().getValue(), ProductNameMother.random().getValue());
    }

    public static CreateProductCommand createId(String id) {
        return new CreateProductCommand(id, ProductNameMother.random().getValue());
    }
}
