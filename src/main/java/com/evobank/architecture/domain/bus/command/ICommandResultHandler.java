package com.evobank.architecture.domain.bus.command;


import com.evobank.architecture.domain.bus.Response;

import java.util.Optional;

public interface ICommandResultHandler<T extends ICommand, R extends Response>{
    Optional<R> handle(T command);
}
