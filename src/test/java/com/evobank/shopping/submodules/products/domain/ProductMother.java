package com.evobank.shopping.submodules.products.domain;

import com.evobank.shopping.submodules.products.application.create.CreateProductCommand;
import com.evobank.shopping.submodules.products.application.update.UpdateProductCommand;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import com.evobank.shopping.submodules.products.domain.vo.*;
import org.mockito.Mockito;

public final class ProductMother {
    public static Product update(ProductId id, ProductName name, ProductStock stock, ProductsValidator searcher) {
        return Product.update(id, name, stock, searcher);
    }
    public static Product create(ProductId id, ProductName name, ProductStock stock, ProductsValidator searcher) {
        return Product.create(id, name, stock, searcher);
    }

    public static Product updateId(String id, ProductsValidator searcher) {
        return Product.create(ProductIdMother.update(id), ProductNameMother.random(), ProductStockMother.random(), searcher);
    }

    public static Product fromRequest(CreateProductCommand command, ProductsValidator searcher) {
        return create(
            ProductIdMother.create(command.getId()),
            ProductNameMother.create(command.getName()),
                ProductStockMother.create(command.getStock()), searcher
        );
    }

    public static Product fromRequest(UpdateProductCommand command, ProductsValidator searcher) {
        return update(
                ProductIdMother.update(command.getId()),
                ProductNameMother.update(command.getName()),
                ProductStockMother.update(command.getStock()),searcher
        );
    }

    public static Product fromRequestWithNameNull(UpdateProductCommand command, ProductsValidator searcher) {
        return update(
                ProductIdMother.update(command.getId()),
                ProductNameMother.update(null),
                ProductStockMother.update(command.getStock()),
                searcher
        );
    }

    public static Product random() {
        return create(ProductIdMother.random(), ProductNameMother.random(), ProductStockMother.random(),Mockito.mock(ProductsValidator.class));
    }
}
