package com.evobank.shopping.controllers.restful.userTask;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.userTask.application.process.ContinueProcessCommand;
import com.evobank.shopping.submodules.userTask.application.process.InitProcessCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public final class ContinueProcessPostController extends ApiController {

    @InjectDependency
    public ContinueProcessPostController(IQueryBus IQueryBus, ICommandBus ICommandBus) {
        super(IQueryBus, ICommandBus);
    }

    @PostMapping("/continue-process/user-task/{paramPath}")
    public ResponseEntity init(@PathVariable String paramPath) {
        try {
            dispatch(new ContinueProcessCommand(paramPath));
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
