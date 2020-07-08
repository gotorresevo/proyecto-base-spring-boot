package com.evobank.architecture.domain.bus.bpm;

import java.util.Map;

public interface IBpmEngine {
    /**
     * Inicia una instancia de proceso
     *
     * @param idProcess id del proceso
     * @param key       clave a relacionar a la instancia del proceso que se inicia
     * @param variables variables que se relacionan a la instancia de proceso que se inicia
     */
    void startProcessInstance(String idProcess, String key, Map<String, Object> variables);

    /**
     * Coloca en estado "COMPLETADA" una tarea manual.
     *
     * @param idProcess id del proceso
     * @param key       clave relacionada a la instancia del proceso
     * @param userName  nombre del usuario al que se le asignará completar la tarea.
     */
    void completeTask(String idProcess, String key, String userName);
}