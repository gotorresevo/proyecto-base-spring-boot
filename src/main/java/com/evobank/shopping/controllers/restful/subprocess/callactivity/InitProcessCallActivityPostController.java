package com.evobank.shopping.controllers.restful.subprocess.callactivity;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.sendtask.application.InitProcessSendTaskCommand;
import com.evobank.shopping.submodules.subprocess.callactivity.application.InitProcessCallActivityCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public final class InitProcessCallActivityPostController extends ApiController {

    @InjectDependency
    public InitProcessCallActivityPostController(IQueryBus queryBus, ICommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/init-process/call-activity/{paramPath}")
    public ResponseEntity init(@PathVariable String paramPath) {
        try {
            dispatch(new InitProcessCallActivityCommand(paramPath));
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

