package com.evobank.shopping.submodules.sendtask.usecases;

import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
@Slf4j
public final class UseCasesSendTask {

    public void execute() {
        log.info("Se ejecuta el caso de uso del modulo SendTask");
    }
}
