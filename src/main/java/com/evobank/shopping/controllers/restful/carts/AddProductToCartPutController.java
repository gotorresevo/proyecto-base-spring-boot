package com.evobank.shopping.controllers.restful.carts;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.carts.application.addproduct.AddProductToCartICommand;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartNotFoundException;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public final class AddProductToCartPutController extends ApiController {

    @InjectDependency
    public AddProductToCartPutController(IQueryBus IQueryBus, ICommandBus ICommandBus) {
        super(IQueryBus, ICommandBus);
    }

    @PutMapping("/cart/{idCart}/product/{idProduct}")
    public ResponseEntity add(@PathVariable String idCart, @PathVariable String idProduct) {
        try {
            dispatch(new AddProductToCartICommand(idCart, idProduct));
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            DomainException domainException = (DomainException) commandHandlerExecutionError.getCause();
            return domainException.getExceptions().stream()
                    .filter(e -> e instanceof ProductNotFoundException || e instanceof CartNotFoundException)
                    .findFirst()
                    .map(e -> new ResponseEntity(HttpStatus.NOT_FOUND)).orElseGet(() -> new ResponseEntity("ERROR DESCONOCIDO", HttpStatus.BAD_REQUEST));
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

