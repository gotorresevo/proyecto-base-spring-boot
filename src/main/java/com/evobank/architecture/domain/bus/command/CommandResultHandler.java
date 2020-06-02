package com.evobank.architecture.domain.bus.command;


import com.evobank.architecture.domain.bus.Response;

import java.util.Optional;

public interface CommandResultHandler<T extends Command, R extends Response>{
    Optional<R> handle(T command);
}
