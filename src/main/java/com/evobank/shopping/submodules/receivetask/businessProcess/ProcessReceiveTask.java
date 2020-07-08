package com.evobank.shopping.submodules.receivetask.businessProcess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.domain.bus.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.receivetask.domain.vo.ReceiveTaskVar1;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessReceiveTask {

    private final IBpmEngine bpmEngine;

    private static final String ID_PROCESS = "process-receive-task";

    public void init(ReceiveTaskVar1 var1){
        Map<String, Object> variables = new HashMap<>();
        variables.put("var1", var1.getValue());
        bpmEngine.startProcessInstance(ID_PROCESS, var1.getValue(), variables);
    }

    public void toContinue(ReceiveTaskVar1 var1){
        bpmEngine.sendSignal(ID_PROCESS, "test-receive-task", var1.getValue());
    }
}
