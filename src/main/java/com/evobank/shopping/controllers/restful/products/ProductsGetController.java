package com.evobank.shopping.controllers.restful.products;

import com.evobank.architecture.application.ApiController;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.ProductsResponse;
import com.evobank.shopping.submodules.products.application.search_all.SearchAllProductsIQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@Slf4j
public final class ProductsGetController extends ApiController {

    @InjectDependency
    public ProductsGetController(IQueryBus IQueryBus, ICommandBus ICommandBus) {
        super(IQueryBus, ICommandBus);
    }

    @GetMapping("/products")
    public ResponseEntity search() {
        return new ResponseEntity(ask(new SearchAllProductsIQuery())
                .map(response -> ((ProductsResponse)response).getProducts())
                .orElse(Collections.emptyList())
                , HttpStatus.OK);
    }
}

