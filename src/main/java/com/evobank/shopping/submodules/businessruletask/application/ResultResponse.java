package com.evobank.shopping.submodules.businessruletask.application;

import com.evobank.architecture.domain.bus.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public final class ResultResponse implements Response {
    private List<Object> result;
}
