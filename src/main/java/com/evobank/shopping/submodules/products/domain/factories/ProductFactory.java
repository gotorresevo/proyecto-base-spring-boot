package com.evobank.shopping.submodules.products.domain.factories;

import com.evobank.architecture.domain.Factory;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.domain.vo.ProductQuantityToSubtract;
import com.evobank.shopping.submodules.products.domain.vo.ProductStock;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_=@InjectDependency)
@Factory
public final class ProductFactory {
    private final ProductsValidator searcher;
    public Product create(ProductId id, ProductName name, ProductStock stock) {
        return Product.create(id, name, stock, searcher);
    }

    public Product update(ProductId id, ProductName name, ProductStock stock) {
        return Product.update(id, name, stock, searcher);
    }

    public Product updateStock(Product product, ProductQuantityToSubtract quantityToSubtract) {
        return Product.updateStock(product,
                quantityToSubtract, searcher);
    }
}
