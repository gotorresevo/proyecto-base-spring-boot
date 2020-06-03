package com.evobank.shopping.shared.infrastructure.bus.command;

import com.evobank.architecture.domain.bus.command.Command;
import com.evobank.architecture.domain.bus.command.CommandResultHandler;
import com.evobank.architecture.domain.bus.command.CommandNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Service
public final class CommandHandlersInformation {
    HashMap<Class<? extends Command>, Class<? extends CommandResultHandler>> indexedCommandResultHandlers;

    public CommandHandlersInformation() {
        Reflections                          reflections = new Reflections("com.evobank");
        Set<Class<? extends CommandResultHandler>> classes     = reflections.getSubTypesOf(CommandResultHandler.class);

        indexedCommandResultHandlers = formatHandlers(classes);
    }

    public Class<? extends CommandResultHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandResultHandler> commandHandlerClass = indexedCommandResultHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    private HashMap<Class<? extends Command>, Class<? extends CommandResultHandler>> formatHandlers(
        Set<Class<? extends CommandResultHandler>> commandHandlers
    ) {
        HashMap<Class<? extends Command>, Class<? extends CommandResultHandler>> handlers = new HashMap<>();

        for (Class<? extends CommandResultHandler> handler : commandHandlers) {
            ParameterizedType        paramType    = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
}
