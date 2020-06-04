package com.evobank.shopping.infrastructure.bus.command;

import com.evobank.architecture.domain.bus.command.ICommand;
import com.evobank.architecture.domain.bus.command.ICommandResultHandler;
import com.evobank.architecture.domain.bus.command.CommandNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Service
public final class CommandHandlersInformation {
    HashMap<Class<? extends ICommand>, Class<? extends ICommandResultHandler>> indexedCommandResultHandlers;

    public CommandHandlersInformation() {
        Reflections                          reflections = new Reflections("com.evobank");
        Set<Class<? extends ICommandResultHandler>> classes     = reflections.getSubTypesOf(ICommandResultHandler.class);
        indexedCommandResultHandlers = formatHandlers(classes);
    }

    public Class<? extends ICommandResultHandler> search(Class<? extends ICommand> commandClass) throws CommandNotRegisteredError {
        Class<? extends ICommandResultHandler> commandHandlerClass = indexedCommandResultHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    private HashMap<Class<? extends ICommand>, Class<? extends ICommandResultHandler>> formatHandlers(
        Set<Class<? extends ICommandResultHandler>> commandHandlers
    ) {
        HashMap<Class<? extends ICommand>, Class<? extends ICommandResultHandler>> handlers = new HashMap<>();

        for (Class<? extends ICommandResultHandler> handler : commandHandlers) {
            ParameterizedType        paramType    = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends ICommand> commandClass = (Class<? extends ICommand>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
}
