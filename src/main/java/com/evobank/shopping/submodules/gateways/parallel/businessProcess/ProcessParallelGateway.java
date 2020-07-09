package com.evobank.shopping.submodules.gateways.parallel.businessProcess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.businessprocess.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessParallelGateway {

    private final IBpmEngine bpmEngine;
    private static final String ID_PROCESS = "process-parallel-gateway";

    public void init(){
        bpmEngine.startProcessInstance(ID_PROCESS);
    }
}
