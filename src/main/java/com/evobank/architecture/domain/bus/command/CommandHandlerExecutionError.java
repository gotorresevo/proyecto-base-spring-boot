package com.evobank.architecture.domain.bus.command;

public final class CommandHandlerExecutionError extends RuntimeException {
    public CommandHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}
