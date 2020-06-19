package com.evobank.shopping.submodules.products.usecases;

import com.evobank.architecture.domain.bus.event.IEventBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.vo.ProductStock;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import com.evobank.shopping.submodules.products.domain.factories.ProductFactory;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class ProductUpdater {
    private final IProductsRepository productRepository;
    private final IEventBus IEventBus;
    private final ProductFactory factory;

    public Optional<Product> update(ProductId id, ProductName name, ProductStock stock) {
        Product current = productRepository.searchById(id).orElseThrow(()-> new ProductNotFoundException("Id del producto no encontrado"));

        // Se asume que al enviar un campo null, es porque no se intenta modificar su valor.
        Product product = factory.update(id, null == name.getValue() ? current.getName() : name, stock);

        productRepository.update(product);
        IEventBus.publish(product.pullDomainEvents());
        return Optional.ofNullable(product);
    }
}
