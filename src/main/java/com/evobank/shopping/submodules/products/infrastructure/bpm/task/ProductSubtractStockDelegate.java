package com.evobank.shopping.submodules.products.infrastructure.bpm.task;

import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.infrastructure.Task;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductQuantityToSubtract;
import com.evobank.shopping.submodules.products.usecases.ProductStockUpdater;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@AllArgsConstructor(onConstructor_= {@InjectDependency})
@NoArgsConstructor(force = true)
@Slf4j
@Task
public final class ProductSubtractStockDelegate implements JavaDelegate {

    private final ProductStockUpdater updater;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String idProduct = (String) delegateExecution.getVariable("idProduct");
        Integer quantity = (Integer) delegateExecution.getVariable("quantity");
        updater.updateStock(ProductId.createFromCommand(idProduct),
                ProductQuantityToSubtract.createFromCommand(quantity));
    }
}