package com.evobank.shopping.submodules.products.application.update.domainEventSubscriber;

import com.evobank.architecture.domain.bus.event.DomainEventSubscriber;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.shared.carts.domain.events.ProductAggregateToCartDomainEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.context.event.EventListener;

import java.util.HashMap;
import java.util.Map;

@DomainEventSubscriber({ProductAggregateToCartDomainEvent.class})
@AllArgsConstructor(onConstructor_= {@InjectDependency})
@Slf4j
public final class UpdateStockOnProductAggregatedToCart {

    private final ProcessEngine processEngine;

    @EventListener
    public void on(ProductAggregateToCartDomainEvent event) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("idProduct", event.getIdProduct());
        variables.put("quantity", event.getQuantity());
        processEngine.getRuntimeService()
                .startProcessInstanceByKey("process-stock-products", variables);
    }
}
