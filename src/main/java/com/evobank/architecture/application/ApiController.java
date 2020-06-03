package com.evobank.architecture.application;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.command.Command;
import com.evobank.architecture.domain.bus.command.CommandBus;
import com.evobank.architecture.domain.bus.query.Query;
import com.evobank.architecture.domain.bus.query.QueryBus;

import java.util.Optional;

public abstract class ApiController {
    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected <R extends Response> Optional<R> dispatch(Command command) {
        return commandBus.dispatch(command);
    }

    protected <R extends Response> Optional<R> ask(Query query) {
        return queryBus.ask(query);
    }
}
