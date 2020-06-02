package com.evobank.shopping.controllers.restfull.products;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandBus;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.query.QueryBus;
import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.architecture.infrastructure.IOError;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.IdResponse;
import com.evobank.shopping.submodules.products.application.create.CreateProductCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public final class ProductPostController extends ApiController {

    @InjectDependency
    public ProductPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/products")
    public ResponseEntity create(@RequestBody Request request) {
        try {
            IdResponse idProduct = (IdResponse) dispatch(new CreateProductCommand(null, request.getName())).get();
            return new ResponseEntity(idProduct, HttpStatus.CREATED);
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            DomainException domainException = (DomainException) commandHandlerExecutionError.getCause();
            List<IOError> list = domainException.getExceptions().stream()
                .map(e -> new IOError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Some message"))
                .collect(Collectors.toList());
            return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
        }
    }
}

