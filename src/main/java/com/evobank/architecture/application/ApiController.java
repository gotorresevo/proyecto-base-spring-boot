package com.evobank.architecture.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.ICommand;
import com.evobank.architecture.domain.bus.command.ICommandBus;
import com.evobank.architecture.domain.bus.query.IQuery;
import com.evobank.architecture.domain.bus.query.IQueryBus;

import java.util.Optional;

public abstract class ApiController {
    private final IQueryBus IQueryBus;
    private final ICommandBus ICommandBus;

    public ApiController(IQueryBus IQueryBus, ICommandBus ICommandBus) {
        this.IQueryBus = IQueryBus;
        this.ICommandBus = ICommandBus;
    }

    protected <R extends Response> Optional<R> dispatch(ICommand ICommand) {
        return ICommandBus.dispatch(ICommand);
    }

    protected <R extends Response> Optional<R> ask(IQuery IQuery) {
        return IQueryBus.ask(IQuery);
    }
}
