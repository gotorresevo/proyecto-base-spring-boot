package com.evobank.shopping.submodules.products.application;

import com.evobank.architecture.domain.bus.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class IdResponse implements Response {
    private String id;
}
