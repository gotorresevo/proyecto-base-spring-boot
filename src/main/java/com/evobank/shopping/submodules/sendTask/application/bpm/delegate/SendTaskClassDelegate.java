package com.evobank.shopping.submodules.sendTask.application.bpm.delegate;

import com.evobank.architecture.application.BpmDelegate;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.sendTask.usecases.UseCasesSendTask;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;


@AllArgsConstructor(onConstructor_= {@InjectDependency})
@NoArgsConstructor(force = true)
@BpmDelegate
@Slf4j
public final class SendTaskClassDelegate implements JavaDelegate {

    private final UseCasesSendTask useCasesSendTask;
    private final RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        useCasesSendTask.execute();
        String var1 = (String) delegateExecution.getVariable("var1");
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("process-receive-task")
                .processInstanceBusinessKey(var1).singleResult();
        Execution execution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId()).activityId("test-receive-task").singleResult();
        runtimeService.signal(execution.getId());
    }
}
