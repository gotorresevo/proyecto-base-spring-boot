package com.evobank.shopping.submodules.userTask.businessProcess;

import com.evobank.architecture.businessProcess.BusinessProcess;
import com.evobank.architecture.domain.bus.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.userTask.domain.vo.UserTaskVar1;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessUserTask {

    private final IBpmEngine bpmEngine;

    private static final String ID_PROCESS = "process-user-task";

    public void init(UserTaskVar1 var1){
        Map<String, Object> variables = new HashMap<>();
        variables.put("var1", var1.getValue());
        bpmEngine.startProcessInstance(ID_PROCESS, var1.getValue(), variables);
    }

    public void toContinue(UserTaskVar1 var1){
        bpmEngine.completeTask(ID_PROCESS, var1.getValue(), "admin");
    }
}
