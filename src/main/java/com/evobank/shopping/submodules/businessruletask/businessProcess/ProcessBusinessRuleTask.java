package com.evobank.shopping.submodules.businessruletask.businessProcess;

import com.evobank.architecture.businessprocess.BusinessProcess;
import com.evobank.architecture.domain.bus.bpm.IBpmEngine;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.businessruletask.domain.vo.BusinessRuleTaskGuestCount;
import com.evobank.shopping.submodules.businessruletask.domain.vo.BusinessRuleTaskSeason;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
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
