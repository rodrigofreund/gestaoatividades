package com.abc.avaliando.gestaoatividades.exception;

public class DescricaoTarefaInvalidaException extends ModelException {

    private static final long serialVersionUID = -4538818889640617171L;
    
    public DescricaoTarefaInvalidaException() {
        super("descrição da tarefa inválida!");
    }
    
}
