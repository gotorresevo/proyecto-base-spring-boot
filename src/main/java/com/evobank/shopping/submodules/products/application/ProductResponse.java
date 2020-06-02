package com.evobank.shopping.submodules.products.application;

import com.evobank.architecture.domain.bus.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class ProductResponse implements Response {
    private String id;
    private String name;
}
