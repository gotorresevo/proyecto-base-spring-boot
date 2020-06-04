package com.evobank.shopping.infrastructure.bus.query;

import com.evobank.architecture.domain.bus.query.IQuery;
import com.evobank.architecture.domain.bus.query.IQueryHandler;
import com.evobank.architecture.domain.bus.query.QueryNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Service
public final class QueryHandlersInformation {
    HashMap<Class<? extends IQuery>, Class<? extends IQueryHandler>> indexedQueryHandlers;

    public QueryHandlersInformation() {
        Reflections reflections = new Reflections("com.evobank");
        indexedQueryHandlers = formatHandlers(reflections.getSubTypesOf(IQueryHandler.class));
    }

    public Class<? extends IQueryHandler> search(Class<? extends IQuery> queryClass) throws QueryNotRegisteredError {
        Class<? extends IQueryHandler> queryHandlerClass = indexedQueryHandlers.get(queryClass);

        if (null == queryHandlerClass) {
            throw new QueryNotRegisteredError(queryClass);
        }

        return queryHandlerClass;
    }

    private HashMap<Class<? extends IQuery>, Class<? extends IQueryHandler>> formatHandlers(
            Set<Class<? extends IQueryHandler>> queryHandlers
    ) {
        HashMap<Class<? extends IQuery>, Class<? extends IQueryHandler>> handlers = new HashMap<>();

        for (Class<? extends IQueryHandler> handler : queryHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends IQuery> queryClass = (Class<? extends IQuery>) paramType.getActualTypeArguments()[0];

            handlers.put(queryClass, handler);
        }

        return handlers;
    }
}
