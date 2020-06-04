package com.evobank.shopping.submodules.products.application.update;

import com.evobank.shopping.submodules.products.application.create.CreateProductICommand;
import com.evobank.shopping.submodules.products.domain.vo.ProductIdMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductNameMother;

public final class UpdateProductCommandMother {
    public static UpdateProductICommand create(String id, String name) {
        return new UpdateProductICommand(id, name);
    }

    public static UpdateProductICommand createName(String name) {
        return new UpdateProductICommand(ProductIdMother.random().getValue(), name);
    }

    public static UpdateProductICommand random() {
        return create(ProductIdMother.random().getValue(), ProductNameMother.random().getValue());
    }

    public static CreateProductICommand createId(String id) {
        return new CreateProductICommand(id, ProductNameMother.random().getValue());
    }
}
