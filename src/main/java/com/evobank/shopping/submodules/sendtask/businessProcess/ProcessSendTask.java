package com.evobank.shopping.submodules.sendtask.businessProcess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.businessprocess.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.sendtask.domain.vo.SendTaskVar1;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessSendTask {

    private final IBpmEngine bpmEngine;
    private static final String ID_PROCESS = "process-send-task";

    public void init(SendTaskVar1 var1){
        Map<String, Object> variables = new HashMap<>();
        variables.put("var1", var1.getValue());
        bpmEngine.startProcessInstance(ID_PROCESS, var1.getValue(), variables);
    }
}
