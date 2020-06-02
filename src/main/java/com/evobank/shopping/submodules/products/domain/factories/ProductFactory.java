package com.evobank.shopping.submodules.products.domain.factories;

import com.evobank.architecture.domain.Factory;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_=@InjectDependency)
@Factory
public final class ProductFactory {
    private final ProductsValidator searcher;
    public Product create(ProductId id, ProductName name) {
        return Product.create(id, name, searcher);
    }

    public Product update(ProductId id, ProductName name) {
        return Product.update(id, name, searcher);
    }
}
