package com.evobank.architecture.domain;

import com.evobank.architecture.domain.bus.event.DomainEvent;
import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ToString
public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents = new ArrayList<>();
    private List<IValueObject> valueObjects = new ArrayList<>();

    public AggregateRoot(IValueObject ...valueObjects){
        this.valueObjects.addAll(Arrays.asList(valueObjects));
    }

    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;
        domainEvents = Collections.emptyList();
        return events;
    }

    final protected void validValueObject(IValidator searcher){
        DomainException domainException = new DomainException();
        this.valueObjects.stream().parallel().forEach(aValueObject -> {
            try {
                aValueObject.valid(searcher);
            } catch (DomainException e) {
                domainException.add(e);
            }
        });
        if(!domainException.getExceptions().isEmpty())
            throw domainException;
    }

    final protected void record(DomainEvent event) {
        domainEvents.add(event);
    }
}
