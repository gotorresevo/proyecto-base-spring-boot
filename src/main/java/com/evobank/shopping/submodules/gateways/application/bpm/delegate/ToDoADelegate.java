package com.evobank.shopping.submodules.gateways.application.bpm.delegate;

import com.evobank.architecture.application.BpmDelegate;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.usecases.UseCaseA;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@AllArgsConstructor(onConstructor_= {@InjectDependency})
@NoArgsConstructor(force = true)
@BpmDelegate
@Slf4j
public final class ToDoADelegate implements JavaDelegate {

    private final UseCaseA useCasesA;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        useCasesA.execute();
    }
}
