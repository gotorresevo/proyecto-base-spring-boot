package com.evobank.shopping.submodules.products.businessprocess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.domain.bus.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductQuantityToSubtract;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessStockProducts {

    private final IBpmEngine bpmEngine;
    private static final String ID_PROCESS = "process-stock-products";

    public void init(ProductId id, ProductQuantityToSubtract quantityToSubtract){
        Map<String, Object> variables = new HashMap<>();
        variables.put("idProduct", id.getValue());
        variables.put("quantity", quantityToSubtract.getValue());
        bpmEngine.startProcessInstance(ID_PROCESS, id.getValue(), variables);
    }
}
