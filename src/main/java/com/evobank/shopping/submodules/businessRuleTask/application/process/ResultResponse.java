package com.evobank.shopping.submodules.businessRuleTask.application.process;

import com.evobank.architecture.domain.bus.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public final class ResultResponse implements Response {
    private List<Object> result;
}