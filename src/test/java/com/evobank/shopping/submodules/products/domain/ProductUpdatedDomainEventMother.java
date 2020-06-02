package com.evobank.shopping.submodules.products.domain;

import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductIdMother;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.domain.vo.ProductNameMother;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductUpdatedDomainEvent;

public final class ProductUpdatedDomainEventMother {
    public static ProductUpdatedDomainEvent create(ProductId id, ProductName name) {
        return new ProductUpdatedDomainEvent(id.getValue(), name.getValue());
    }

    public static ProductUpdatedDomainEvent fromProduct(Product product) {
        return create(product.getId(), product.getName());
    }

    public static ProductUpdatedDomainEvent random() {
        return create(ProductIdMother.random(), ProductNameMother.random());
    }
}
