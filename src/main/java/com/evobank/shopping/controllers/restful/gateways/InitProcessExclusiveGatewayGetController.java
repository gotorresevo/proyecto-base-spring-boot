package com.evobank.shopping.controllers.restful.gateways;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.gateways.exclusive.application.InitProcessExclusiveGatewayCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@Slf4j
public final class InitProcessExclusiveGatewayGetController extends ApiController {

    @InjectDependency
    public InitProcessExclusiveGatewayGetController(IQueryBus queryBus, ICommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/init-process/gateway/exclusive")
    public ResponseEntity init(@QueryParam("value") String value) {
        try {
            return dispatch(new InitProcessExclusiveGatewayCommand(value)).map(response -> new ResponseEntity(response, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity(HttpStatus.NO_CONTENT));
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

