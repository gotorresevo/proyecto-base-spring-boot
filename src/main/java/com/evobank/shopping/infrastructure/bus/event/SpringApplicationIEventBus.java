package com.evobank.shopping.infrastructure.bus.event;

import com.evobank.architecture.domain.bus.event.DomainEvent;
import com.evobank.architecture.domain.bus.event.IEventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringApplicationIEventBus implements IEventBus {
    private final ApplicationEventPublisher publisher;

    public SpringApplicationIEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
