package com.evobank.shopping.submodules.gateways.shared.infraestructure.bpm.task;

import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.shared.usecases.UseCaseDefault;
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
public final class ToDoDefaultDelegate implements JavaDelegate {

    private final UseCaseDefault useCaseDefault;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        useCaseDefault.execute();
    }
}
