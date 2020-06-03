package com.evobank.shopping.controllers.restful.products;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandBus;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.query.QueryBus;
import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.architecture.infrastructure.IOError;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.update.UpdateProductCommand;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public final class ProductPatchController extends ApiController {

    @InjectDependency
    public ProductPatchController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PatchMapping("/products/{idProduct}")
    public ResponseEntity create(@PathVariable String idProduct, @RequestBody Request request) {
        try {
            dispatch(new UpdateProductCommand(idProduct, request.getName()));
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            DomainException domainException = (DomainException) commandHandlerExecutionError.getCause();
            for (RuntimeException runtimeException : domainException.getExceptions()){
                if(runtimeException instanceof ProductNotFoundException){
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            }
            List<IOError> list = domainException.getExceptions().stream()
                .map(e -> new IOError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Some message"))
                .collect(Collectors.toList());
            return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
