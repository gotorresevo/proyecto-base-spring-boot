package com.evobank.shopping.submodules.businessRuleTask.businessProcess;

import com.evobank.architecture.businessProcess.BusinessProcess;
import com.evobank.architecture.domain.bus.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.businessRuleTask.domain.vo.BusinessRuleTaskGuestCount;
import com.evobank.shopping.submodules.businessRuleTask.domain.vo.BusinessRuleTaskSeason;
import com.evobank.shopping.submodules.sendTask.domain.vo.SendTaskVar1;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.history.HistoricDecisionInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@BusinessProcess
@AllArgsConstructor(onConstructor_ = {@InjectDependency})
public final class ProcessBusinessRuleTask {

    private final IBpmEngine bpmEngine;
    private static final String ID_PROCESS = "process-business-rule-task";

    public Stream<Object> init(BusinessRuleTaskSeason season, BusinessRuleTaskGuestCount guestCount){
        Map<String, Object> variables = new HashMap<>();
        variables.put("season", season.getValue());
        variables.put("guestCount", guestCount.getValue());
        String idInstanceProcess = bpmEngine.startProcessInstance(ID_PROCESS, season.getValue(), variables);
        return bpmEngine.getOutputsBusinessRule(idInstanceProcess, "DecisionTable");
    }
}
