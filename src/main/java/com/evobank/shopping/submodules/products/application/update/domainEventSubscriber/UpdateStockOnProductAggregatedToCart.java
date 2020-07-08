package com.evobank.shopping.submodules.products.application.update.domainEventSubscriber;

import com.evobank.architecture.domain.bus.event.DomainEventSubscriber;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.businessprocess.ProcessStockProducts;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductQuantityToSubtract;
import com.evobank.shopping.submodules.shared.carts.domain.events.ProductAggregateToCartDomainEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({ProductAggregateToCartDomainEvent.class})
@AllArgsConstructor(onConstructor_= {@InjectDependency})
@Slf4j
public final class UpdateStockOnProductAggregatedToCart {
    private final ProcessStockProducts processStockProducts;

    @EventListener
    public void on(ProductAggregateToCartDomainEvent event) {
        processStockProducts.init(ProductId.createFromCommand(event.getIdProduct()),
                ProductQuantityToSubtract.createFromCommand(event.getQuantity()));
    }
}
