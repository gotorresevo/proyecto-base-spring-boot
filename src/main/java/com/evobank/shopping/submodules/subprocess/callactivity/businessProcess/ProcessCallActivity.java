package com.evobank.shopping.submodules.subprocess.callactivity.businessProcess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.businessprocess.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.subprocess.callactivity.vo.CallActivityVar1;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessCallActivity {

    private final IBpmEngine bpmEngine;

    private static final String ID_PROCESS = "process-call-activity";

    public void init(CallActivityVar1 var1){
        Map<String, Object> variables = new HashMap<>();
        variables.put("var1", var1.getValue());
        bpmEngine.startProcessInstance(ID_PROCESS, var1.getValue(), variables);
    }

    public void toContinue(CallActivityVar1 var1){
        bpmEngine.completeTask(ID_PROCESS, var1.getValue(), "admin");
    }
}
