package com.evobank.shopping.submodules.products.domain;

import com.evobank.architecture.domain.AggregateRoot;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.domain.vo.ProductQuantityToSubtract;
import com.evobank.shopping.submodules.products.domain.vo.ProductStock;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductCreatedDomainEvent;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductStockSubtractedDomainEvent;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductUpdatedDomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public final class Product extends AggregateRoot {
    private final ProductId id;
    private final ProductName name;
    private final ProductStock stock;

    public static Product create(ProductId id, ProductName name, ProductStock stock, ProductsValidator searcher) {
        Product product = new Product(id, name, stock, searcher);
        product.record(new ProductCreatedDomainEvent(id.getValue(), name.getValue()));
        return product;
    }

    private Product(ProductId id, ProductName name, ProductStock stock, ProductsValidator searcher) {
         super(id, name, stock);
        validValueObject(searcher);
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public static Product update(ProductId id, ProductName name, ProductStock stock, ProductsValidator searcher) {
        Product product = new Product(id, name, stock, searcher);
        product.record(new ProductUpdatedDomainEvent(id.getValue(), name.getValue()));
        return product;
    }

    public static Product updateStock(Product product, ProductQuantityToSubtract quantityToSubtract, ProductsValidator searcher) {
        Product newProduct = new Product(ProductId.updateFromCommand(product.getId().getValue()), ProductName.updateFromCommand(product.getName().getValue()),
                product.getStock().subtract(quantityToSubtract), searcher);
        newProduct.record(new ProductStockSubtractedDomainEvent(newProduct.getId().getValue(), newProduct.getName().getValue()));
        return newProduct;
    }
}
