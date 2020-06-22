package com.evobank.shopping.submodules.products.usecases;

import com.evobank.architecture.domain.bus.event.IEventBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.factories.ProductFactory;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import com.evobank.shopping.submodules.products.domain.vo.ProductQuantityToSubtract;
import com.evobank.shopping.submodules.products.domain.vo.ProductStock;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class ProductStockUpdater {
    private final IProductsRepository productRepository;
    private final IEventBus IEventBus;
    private final ProductFactory factory;

    public void updateStock(ProductId id, ProductQuantityToSubtract quantityToSubtract) {
        Product product = productRepository.searchById(id)
                .map(productAux -> factory.updateStock(productAux, quantityToSubtract))
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado para actualzar el stock"));
        productRepository.save(product);
        IEventBus.publish(product.pullDomainEvents());
    }
}
