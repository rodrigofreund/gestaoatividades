package com.abc.avaliando.gestaoatividades.exception;

public class TarefaNaoPermiteEnvioException extends ModelException {

    private static final long serialVersionUID = -2838743478691683356L;

    public TarefaNaoPermiteEnvioException() {
        super("Tarefa não permite envio!");
    }

}
