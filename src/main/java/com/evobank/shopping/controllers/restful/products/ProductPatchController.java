package com.evobank.shopping.controllers.restful.products;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.architecture.infrastructure.IOError;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.update.UpdateProductICommand;
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
    public ProductPatchController(IQueryBus IQueryBus, ICommandBus ICommandBus) {
        super(IQueryBus, ICommandBus);
    }

    @PatchMapping("/products/{idProduct}")
    public ResponseEntity create(@PathVariable String idProduct, @RequestBody Request request) {
        try {
            dispatch(new UpdateProductICommand(idProduct, request.getName()));
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            if(commandHandlerExecutionError.getCause() instanceof ProductNotFoundException){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            DomainException domainException = (DomainException) commandHandlerExecutionError.getCause();
            List<IOError> list = domainException.getExceptions().stream()
                .map(e -> new IOError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Some message"))
                .collect(Collectors.toList());
            return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

