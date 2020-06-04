package com.evobank.shopping.infrastructure.bus.command;

import com.evobank.architecture.domain.bus.command.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class InMemoryICommandBus implements ICommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryICommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public Optional dispatch(ICommand ICommand) {
        try {
            Class<? extends ICommandResultHandler> commandHandlerClass = information.search(ICommand.getClass());

            ICommandResultHandler handler = context.getBean(commandHandlerClass);

            return handler.handle(ICommand);
        } catch (Exception error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
