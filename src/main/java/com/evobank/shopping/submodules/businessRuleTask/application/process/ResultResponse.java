package com.evobank.shopping.submodules.businessRuleTask.application.process;

import com.evobank.architecture.domain.bus.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class ResultResponse implements Response {
    private String result;
}
