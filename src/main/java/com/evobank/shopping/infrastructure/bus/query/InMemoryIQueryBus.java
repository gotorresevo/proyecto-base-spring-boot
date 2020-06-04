package com.evobank.shopping.infrastructure.bus.query;

import com.evobank.architecture.domain.bus.Response;
import com.evobank.architecture.domain.bus.query.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class InMemoryIQueryBus implements IQueryBus {
    private final QueryHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryIQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public Optional<Response> ask(IQuery IQuery) {
        try {
            Class<? extends IQueryHandler> queryHandlerClass = information.search(IQuery.getClass());

            IQueryHandler handler = context.getBean(queryHandlerClass);

            return handler.handle(IQuery);
        } catch (Exception error) {
            throw new QueryHandlerExecutionError(error);
        }
    }
}
