package com.evobank.shopping.infrastructure.bus.command;

import com.evobank.architecture.domain.bus.command.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public Optional dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandResultHandler> commandHandlerClass = information.search(command.getClass());

            CommandResultHandler handler = context.getBean(commandHandlerClass);

            return handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
