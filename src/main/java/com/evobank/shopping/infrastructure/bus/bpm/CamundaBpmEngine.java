package com.evobank.shopping.infrastructure.bus.bpm;

import com.evobank.architecture.businessprocess.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.history.HistoricDecisionInstance;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class CamundaBpmEngine implements IBpmEngine {

    private final ProcessEngine processEngine;

    @Override
    public String startProcessInstance(String idProcess, String key, Map<String, Object> variables) {
        return processEngine.getRuntimeService()
                .startProcessInstanceByKey(idProcess, key, variables).getId();
    }

    @Override
    public String startProcessInstance(String idProcess, Map<String, Object> variables) {
        return processEngine.getRuntimeService()
                .startProcessInstanceByKey(idProcess, variables).getId();
    }

    @Override
    public void completeTask(String idProcess, String key, String userName) {
        Task task = processEngine.getTaskService().createTaskQuery()
                .processDefinitionKey(idProcess)
                .orderByDueDate().asc()
                .processInstanceBusinessKey(key).list().get(0);
        processEngine.getTaskService().claim(task.getId(), userName);
        processEngine.getTaskService().complete(task.getId());
    }

    @Override
    public void sendSignal(String idProcess, String idReceiveTask, String value) {
        ProcessInstance processInstance = processEngine.getRuntimeService().createProcessInstanceQuery()
                .processDefinitionKey(idProcess)
                .processInstanceBusinessKey(value).singleResult();
        Execution execution = processEngine.getRuntimeService().createExecutionQuery()
                .processInstanceId(processInstance.getId()).activityId(idReceiveTask).singleResult();
        processEngine.getRuntimeService().signal(execution.getId());
    }

    @Override
    public String startProcessInstance(String idProcess) {
        return processEngine.getRuntimeService()
                .startProcessInstanceByKey(idProcess).getId();
    }

    @Override
    public Stream<Object> getOutputsBusinessRule(String idInstanceProcess, String idDecisionDefinition) {
        List<HistoricDecisionInstance> historicDecisions = processEngine.getHistoryService().createHistoricDecisionInstanceQuery()
                .processInstanceId(idInstanceProcess)
                .decisionDefinitionKey("DecisionTable")
                .includeInputs()
                .includeOutputs()
                .list();
        return historicDecisions.get(0).getOutputs().stream()
                .map(historicDecisionOutputInstance -> historicDecisionOutputInstance.getValue());
    }
}
