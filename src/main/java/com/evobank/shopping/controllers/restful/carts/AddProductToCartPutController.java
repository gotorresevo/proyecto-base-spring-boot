package com.evobank.shopping.controllers.restful.carts;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandBus;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.query.QueryBus;
import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.architecture.infrastructure.IOError;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.carts.application.addproduct.AddProductToCartCommand;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartNotFoundException;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public final class AddProductToCartPutController extends ApiController {

    @InjectDependency
    public AddProductToCartPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/cart/{idCart}/product/{idProduct}")
    public ResponseEntity add(@PathVariable String idCart, @PathVariable String idProduct) {
        try {
            dispatch(new AddProductToCartCommand(idCart, idProduct));
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            DomainException domainException = (DomainException) commandHandlerExecutionError.getCause();
            for (RuntimeException exception : domainException.getExceptions()){
                if(exception instanceof ProductNotFoundException || exception instanceof CartNotFoundException)
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            List<IOError> list = domainException.getExceptions().stream()
                .map(e -> new IOError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Some message"))
                .collect(Collectors.toList());
            return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

