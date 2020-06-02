package com.evobank.shopping.submodules.products.application;

import com.evobank.architecture.domain.bus.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public final class ProductsResponse implements Response {
    private List<ProductResponse> products;
}
