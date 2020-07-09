package com.evobank.shopping.submodules.gateways.exclusive.businessProcess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.businessprocess.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.exclusive.domain.vo.ExclusiveGatewayValue;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessExclusiveGateway {

    private final IBpmEngine bpmEngine;
    private static final String ID_PROCESS = "process-exclusive-gateway";

    public void init(ExclusiveGatewayValue value){
        Map<String, Object> variables = new HashMap<>();
        variables.put("value", value.getValue());
        bpmEngine.startProcessInstance(ID_PROCESS, value.getValue(), variables);
    }
}
