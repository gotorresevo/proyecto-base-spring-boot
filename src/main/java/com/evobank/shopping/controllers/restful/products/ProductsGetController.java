package com.evobank.shopping.controllers.restful.products;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.CommandBus;
import com.evobank.architecture.domain.bus.command.CommandHandlerExecutionError;
import com.evobank.architecture.domain.bus.query.QueryBus;
import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.architecture.infrastructure.IOError;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.ProductsResponse;
import com.evobank.shopping.submodules.products.application.search_all.SearchAllProductsQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public final class ProductsGetController extends ApiController {

    @InjectDependency
    public ProductsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/products")
    public ResponseEntity search() {
        try {
            ProductsResponse productsResponse = (ProductsResponse) ask(new SearchAllProductsQuery()).get();
            return new ResponseEntity(productsResponse.getProducts(), HttpStatus.OK);
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            DomainException domainException = (DomainException) commandHandlerExecutionError.getCause();
            List<IOError> list = domainException.getExceptions().stream()
                .map(e -> new IOError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Some message"))
                .collect(Collectors.toList());
            return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
        }
    }
}

