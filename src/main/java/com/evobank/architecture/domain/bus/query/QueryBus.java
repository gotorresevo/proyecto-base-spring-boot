package com.evobank.architecture.domain.bus.query;

import com.evobank.architecture.domain.bus.Response;

import java.util.Optional;

public interface QueryBus {
    <R extends Response> Optional<R> ask(Query query);
}
