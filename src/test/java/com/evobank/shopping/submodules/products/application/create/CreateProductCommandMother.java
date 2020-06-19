package com.evobank.shopping.submodules.products.application.create;

import com.evobank.shopping.submodules.products.domain.vo.ProductIdMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductNameMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductStockMother;

public final class CreateProductCommandMother {
    public static CreateProductCommand create(String id, String name, Integer stock) {
        return new CreateProductCommand(id, name, stock);
    }

    public static CreateProductCommand createName(String name) {
        return new CreateProductCommand(ProductIdMother.random().getValue(), name, ProductStockMother.random().getValue());
    }

    public static CreateProductCommand random() {
        return create(ProductIdMother.random().getValue(), ProductNameMother.random().getValue(), ProductStockMother.random().getValue());
    }

    public static CreateProductCommand createId(String id) {
        return new CreateProductCommand(id, ProductNameMother.random().getValue(), ProductStockMother.random().getValue());
    }
}
