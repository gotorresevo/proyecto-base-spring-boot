package com.evobank.architecture.domain.bus.query;

import com.evobank.architecture.domain.bus.Response;

import java.util.Optional;

public interface IQueryHandler<Q extends IQuery, R extends Response> {
    Optional<R> handle(Q query);
}
