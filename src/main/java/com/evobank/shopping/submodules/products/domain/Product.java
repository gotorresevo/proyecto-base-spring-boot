package com.evobank.shopping.submodules.products.domain;

import com.evobank.architecture.domain.AggregateRoot;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductCreatedDomainEvent;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductUpdatedDomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public final class Product extends AggregateRoot {
    private final ProductId id;
    private final ProductName name;

    public static Product create(ProductId id, ProductName name, ProductsValidator searcher) {
        Product product = new Product(id, name, searcher);
        product.record(new ProductCreatedDomainEvent(id.getValue(), name.getValue()));
        return product;
    }

    private Product(ProductId id, ProductName name, ProductsValidator searcher) {
        super(id, name);
        validValueObject(searcher);
        this.id = id;
        this.name = name;
    }

    public static Product update(ProductId id, ProductName name, ProductsValidator searcher) {
        Product product = new Product(id, name, searcher);
        product.record(new ProductUpdatedDomainEvent(id.getValue(), name.getValue()));
        return product;
    }
}
