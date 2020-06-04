package com.evobank.architecture.domain.bus.query;

import com.evobank.architecture.domain.bus.Response;

import java.util.Optional;

public interface IQueryBus {
    <R extends Response> Optional<R> ask(IQuery IQuery);
}
