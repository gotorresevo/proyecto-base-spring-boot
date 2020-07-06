package com.evobank.shopping.submodules.businessRuleTask.application.process;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.history.HistoricDecisionInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@com.evobank.architecture.application.CommandHandler
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class InitProcessBusinessRuleTaskCommandHandler implements ICommandResultHandler<InitProcessBusinessRuleTaskCommand, ResultResponse> {

    private final ProcessEngine processEngine;
    private final HistoryService historyService;

    @Override
    public Optional<ResultResponse> handle(InitProcessBusinessRuleTaskCommand command) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("season", command.getVar1());
        variables.put("guestCount", command.getVar2());
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("process-business-rule-task", command.getVar1(), variables);
        List<HistoricDecisionInstance> historicDecisions = historyService.createHistoricDecisionInstanceQuery()
                .processInstanceId(processInstance.getId())
                .decisionDefinitionKey("DecisionTable")
                .includeInputs()
                .includeOutputs()
                .list();
        return Optional.of(new ResultResponse(historicDecisions.get(0).getOutputs().stream()
                .map(historicDecisionOutputInstance -> historicDecisionOutputInstance.getValue())
                    .collect(Collectors.toList())));
    }
}
