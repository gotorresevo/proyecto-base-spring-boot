package com.evobank.shopping.controllers.restful.usertask;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.usertask.application.InitProcessUserTaskCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("initProcessUserTaskController")
@Slf4j
public final class InitProcessUserTaskPostController extends ApiController {

    @InjectDependency
    public InitProcessUserTaskPostController(IQueryBus queryBus, ICommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/init-process/user-task/{paramPath}")
    public ResponseEntity init(@PathVariable String paramPath) {
        try {
            dispatch(new InitProcessUserTaskCommand(paramPath));
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

