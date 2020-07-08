package com.evobank.shopping.submodules.gateways.application.bpm.delegate;

import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.usecases.UseCaseB;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@AllArgsConstructor(onConstructor_= {@InjectDependency})
@NoArgsConstructor(force = true)
@Slf4j
public final class ToDoBDelegate implements JavaDelegate {

    private final UseCaseB useCaseB;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        useCaseB.execute();
    }
}
