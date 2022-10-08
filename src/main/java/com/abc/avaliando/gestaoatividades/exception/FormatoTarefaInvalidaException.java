package com.abc.avaliando.gestaoatividades.exception;

public class FormatoTarefaInvalidaException extends ModelException {

    private static final long serialVersionUID = -4538818889640617171L;
    
    public FormatoTarefaInvalidaException() {
        super("formato da tarefa não informado!");
    }
    
}
