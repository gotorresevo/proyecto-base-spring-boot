package com.evobank.shopping.submodules.products.usecases;

import com.evobank.architecture.domain.bus.event.IEventBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.factories.ProductFactory;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.domain.vo.ProductStock;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class ProductCreator {
    private final IProductsRepository productRepository;
    private final IEventBus IEventBus;
    private final ProductFactory factory;

    public Optional<Product> create(ProductId id, ProductName name, ProductStock stock) {
        Product product = factory.create(id, name, stock);
        productRepository.save(product);
        IEventBus.publish(product.pullDomainEvents());
        return Optional.ofNullable(product);
    }
}
