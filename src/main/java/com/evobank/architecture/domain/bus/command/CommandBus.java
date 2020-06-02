package com.evobank.architecture.domain.bus.command;

import com.evobank.architecture.domain.bus.Response;

import java.util.Optional;

public interface CommandBus {
    <R extends Response> Optional<R> dispatch(Command command) throws CommandHandlerExecutionError;
}
