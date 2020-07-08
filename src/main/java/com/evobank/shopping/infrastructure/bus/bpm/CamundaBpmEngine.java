package com.evobank.shopping.infrastructure.bus.bpm;

import com.evobank.architecture.domain.bus.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class CamundaBpmEngine implements IBpmEngine {

    private final ProcessEngine processEngine;
    private final TaskService taskService;

    @Override
    public void startProcessInstance(String idProcess, String key, Map<String, Object> variables) {
        processEngine.getRuntimeService()
                .startProcessInstanceByKey(idProcess, key, variables);
    }

    @Override
    public void completeTask(String idProcess, String key, String userName) {
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(idProcess)
                .orderByDueDate().asc()
                .processInstanceBusinessKey(key).singleResult();
        taskService.claim(task.getId(), userName);
        taskService.complete(task.getId());
    }
}
