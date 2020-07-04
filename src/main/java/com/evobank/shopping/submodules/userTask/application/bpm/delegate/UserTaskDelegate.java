package com.evobank.shopping.submodules.userTask.application.bpm.delegate;

import com.evobank.architecture.application.BpmDelegate;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductQuantityToSubtract;
import com.evobank.shopping.submodules.products.usecases.ProductStockUpdater;
import com.evobank.shopping.submodules.userTask.usecases.UseCaseForUserTask;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@AllArgsConstructor(onConstructor_= {@InjectDependency})
@NoArgsConstructor(force = true)
@BpmDelegate
@Slf4j
public final class UserTaskDelegate implements JavaDelegate {

    private final UseCaseForUserTask useCase;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    }
}
