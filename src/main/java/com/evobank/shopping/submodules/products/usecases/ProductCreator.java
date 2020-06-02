package com.evobank.shopping.submodules.products.usecases;

import com.evobank.architecture.domain.bus.event.EventBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.factories.ProductFactory;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class ProductCreator {
    private final IProductsRepository productRepository;
    private final EventBus eventBus;
    private final ProductFactory factory;

    public Optional<Product> create(ProductId id, ProductName name) {
        Product product = factory.create(id, name);
        productRepository.save(product);
        eventBus.publish(product.pullDomainEvents());
        return Optional.ofNullable(product);
    }
}
