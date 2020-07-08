package com.evobank.architecture.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommand;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQuery;
import com.evobank.architecture.domain.bus.query.IQueryBus;

import java.util.Optional;

public abstract class ApiController {
    private final IQueryBus queryBus;
    private final ICommandBus commandBus;

    public ApiController(IQueryBus queryBus, ICommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    protected <R extends Response> Optional<R> dispatch(ICommand command) {
        return commandBus.dispatch(command);
    }

    protected <R extends Response> Optional<R> ask(IQuery query) {
        return queryBus.ask(query);
    }
}
