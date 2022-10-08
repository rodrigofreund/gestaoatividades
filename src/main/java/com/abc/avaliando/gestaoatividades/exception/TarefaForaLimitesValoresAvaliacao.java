package com.abc.avaliando.gestaoatividades.exception;

public class TarefaForaLimitesValoresAvaliacao extends ModelException {

    private static final long serialVersionUID = -860362236931981134L;

    public TarefaForaLimitesValoresAvaliacao() {
        super("Valores peso atividade fora limites de avaliação");
    }

}
