package com.evobank.architecture.businessprocess.bpm;

import java.util.Map;
import java.util.stream.Stream;

public interface IBpmEngine {

    /**
     * Inicia una instancia de proceso
     *
     * @param idProcess id del proceso
     * @param key       clave a relacionar a la instancia del proceso que se inicia
     * @param variables variables que se relacionan a la instancia de proceso que se inicia
     * @return id de la instancia de proceso iniciada
     */
    String startProcessInstance(String idProcess, String key, Map<String, Object> variables);

    /**
     * Inicia una instancia de proceso
     *
     * @param idProcess id del proceso
     * @param variables variables que se relacionan a la instancia de proceso que se inicia
     * @return id de la instancia de proceso iniciada
     */
    String startProcessInstance(String idProcess, Map<String, Object> variables);

    /**
     * Inicia una instancia de proceso
     *
     * @param idProcess id del proceso
     * @return id de la instancia de proceso iniciada
     */
    String startProcessInstance(String idProcess);

    /**
     * Coloca en estado "COMPLETADA" una tarea manual.
     *
     * @param idProcess id del proceso
     * @param key       clave relacionada a la instancia del proceso
     * @param userName  nombre del usuario al que se le asignará completar la tarea.
     */
    void completeTask(String idProcess, String key, String userName);

    void sendSignal(String idProcess, String idReceiveTask, String value);



    Stream<Object> getOutputsBusinessRule(String idInstanceProcess, String idDecisionDefinition);


}
