package com.evobank.architecture.application;

import com.evobank.architecture.domain.UuidGenerator;
import com.evobank.architecture.domain.bus.event.DomainEvent;
import com.evobank.architecture.domain.bus.event.IEventBus;
import com.evobank.architecture.domain.bus.query.IQuery;
import com.evobank.architecture.domain.bus.query.IQueryBus;
import com.evobank.architecture.domain.bus.Response;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class UnitTestCase {
    protected IEventBus IEventBus;
    protected IQueryBus IQueryBus;
    protected UuidGenerator uuidGenerator;

    @BeforeEach
    protected void setUp() {
        IEventBus = mock(IEventBus.class);
        IQueryBus = mock(IQueryBus.class);
        uuidGenerator = mock(UuidGenerator.class);
    }

    public void shouldHavePublished(List<DomainEvent> domainEvents) {
        verify(IEventBus, atLeastOnce()).publish(domainEvents);
    }

    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }

    public void shouldGenerateUuid(String uuid) {
        when(uuidGenerator.generate()).thenReturn(uuid);
    }

    public void shouldGenerateUuids(String uuid, String... others) {
        when(uuidGenerator.generate()).thenReturn(uuid, others);
    }

    public void shouldAsk(IQuery IQuery, Response response) {
        when(IQueryBus.ask(IQuery)).thenReturn(Optional.ofNullable(response));
    }
}
