package com.evobank.shopping.submodules.products.application.bpm.domainEventSubscriber;

import com.evobank.architecture.domain.bus.event.DomainEventSubscriber;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.shared.carts.domain.events.ProductAggregateToCartDomainEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DomainEventSubscriber({ProductAggregateToCartDomainEvent.class})
@AllArgsConstructor(onConstructor_= {@InjectDependency})
@Slf4j
public final class UpdateStockOnProductAggregatedToCart {

    @Autowired
    private ProcessEngine processEngine;

    @EventListener
    public void on(ProductAggregateToCartDomainEvent event) {
        /**
         * Se consulta la definicion de procesos, que no son mas que los archivos *.bpmn y sus versiones.
         */
        List<ProcessDefinition> processDefinitions = processEngine.getRepositoryService().createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion()
                .asc()
                .list();
        Map<String, Object> variables = new HashMap<>();
        variables.put("idProduct", event.getIdProduct());
        variables.put("quantity", event.getQuantity());
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("process-stock-products", variables);
    }
}
