package com.evobank.shopping.submodules.gateways.inclusive.businessProcess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.businessprocess.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.inclusive.domain.vo.InclusiveGatewayValue;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessInclusiveGateway {

    private final IBpmEngine bpmEngine;
    private static final String ID_PROCESS = "process-inclusive-gateway";

    public void init(InclusiveGatewayValue value){
        Map<String, Object> variables = new HashMap<>();
        variables.put("value", value.getValue());
        bpmEngine.startProcessInstance(ID_PROCESS, value.getValue(), variables);
    }
}
