package com.abc.avaliando.gestaoatividades.exception;

public class TarefaNaoPermiteEntregaForaPrazo extends ModelException {

    private static final long serialVersionUID = 3798229525588330411L;

    public TarefaNaoPermiteEntregaForaPrazo() {
        super("tarefa não permite entrega fora do prazo.");
    }
    
}
