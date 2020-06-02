package com.evobank.shopping.shared.infrastructure.bus.query;

import com.evobank.architecture.domain.bus.query.Query;
import com.evobank.architecture.domain.bus.query.QueryHandler;
import com.evobank.architecture.domain.bus.query.QueryNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

@Service
public final class QueryHandlersInformation {
    HashMap<Class<? extends Query>, Class<? extends QueryHandler>> indexedQueryHandlers;

    public QueryHandlersInformation() {
        Reflections                        reflections = new Reflections("com.evobank");
        Set<Class<? extends QueryHandler>> classes = Collections.emptySet();
        try{
            classes     = reflections.getSubTypesOf(QueryHandler.class);
        }catch (org.reflections.ReflectionsException e){

        }

        indexedQueryHandlers = formatHandlers(classes);
    }

    public Class<? extends QueryHandler> search(Class<? extends Query> queryClass) throws QueryNotRegisteredError {
        Class<? extends QueryHandler> queryHandlerClass = indexedQueryHandlers.get(queryClass);

        if (null == queryHandlerClass) {
            throw new QueryNotRegisteredError(queryClass);
        }

        return queryHandlerClass;
    }

    private HashMap<Class<? extends Query>, Class<? extends QueryHandler>> formatHandlers(
        Set<Class<? extends QueryHandler>> queryHandlers
    ) {
        HashMap<Class<? extends Query>, Class<? extends QueryHandler>> handlers = new HashMap<>();

        for (Class<? extends QueryHandler> handler : queryHandlers) {
            ParameterizedType      paramType  = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Query> queryClass = (Class<? extends Query>) paramType.getActualTypeArguments()[0];

            handlers.put(queryClass, handler);
        }

        return handlers;
    }
}
