package com.evobank.shopping.submodules.gateways.shared.infrastructure.bpm.task;

import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.shared.usecases.UseCaseA;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@AllArgsConstructor(onConstructor_= {@InjectDependency})
@NoArgsConstructor(force = true)
@Slf4j
@Component
public final class ToDoADelegate implements JavaDelegate {

    private final UseCaseA useCasesA;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        useCasesA.execute();
    }
}
