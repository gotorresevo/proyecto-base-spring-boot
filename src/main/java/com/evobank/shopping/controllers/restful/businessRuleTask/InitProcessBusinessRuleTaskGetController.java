package com.evobank.shopping.controllers.restful.businessRuleTask;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.businessRuleTask.application.InitProcessBusinessRuleTaskCommand;
import com.evobank.shopping.submodules.businessRuleTask.application.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@Slf4j
public final class InitProcessBusinessRuleTaskGetController extends ApiController {

    @InjectDependency
    public InitProcessBusinessRuleTaskGetController(IQueryBus IQueryBus, ICommandBus ICommandBus) {
        super(IQueryBus, ICommandBus);
    }

    @GetMapping("/init-process/business-rule-task")
    public ResponseEntity init(@QueryParam("var1") String var1, @QueryParam("var2") String var2) {
        try {
            ResultResponse resultResponse = (ResultResponse) dispatch(new InitProcessBusinessRuleTaskCommand(var1, var2)).orElseThrow(RuntimeException::new);
            return new ResponseEntity(resultResponse, HttpStatus.OK);
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

