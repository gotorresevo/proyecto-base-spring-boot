package com.evobank.shopping.controllers.restful.sendTask;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.receiveTask.application.process.InitProcessReceiveTaskCommand;
import com.evobank.shopping.submodules.sendTask.application.process.InitProcessSendTaskCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public final class InitProcessSendTaskPostController extends ApiController {

    @InjectDependency
    public InitProcessSendTaskPostController(IQueryBus IQueryBus, ICommandBus ICommandBus) {
        super(IQueryBus, ICommandBus);
    }

    @PostMapping("/init-process/send-task/{paramPath}")
    public ResponseEntity init(@PathVariable String paramPath) {
        try {
            dispatch(new InitProcessSendTaskCommand(paramPath));
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

