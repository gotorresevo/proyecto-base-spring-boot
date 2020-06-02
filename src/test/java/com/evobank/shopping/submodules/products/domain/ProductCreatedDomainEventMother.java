package com.evobank.shopping.submodules.products.domain;

import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductIdMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.domain.vo.ProductNameMother;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductCreatedDomainEvent;

public final class ProductCreatedDomainEventMother {
    public static ProductCreatedDomainEvent create(ProductId id, ProductName name) {
        return new ProductCreatedDomainEvent(id.getValue(), name.getValue());
    }

    public static ProductCreatedDomainEvent fromProduct(Product product) {
        return create(product.getId(), product.getName());
    }

    public static ProductCreatedDomainEvent random() {
        return create(ProductIdMother.random(), ProductNameMother.random());
    }
}
