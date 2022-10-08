package com.abc.avaliando.gestaoatividades.model;

public interface AtividadeCurricular {
    public boolean bloqueadoParaCriacaoTarefas();
    public boolean permiteEnvioTarefas();
    public int getPesoMinimoAvaliacao();
    public int getPesoMaximoAvaliacao();
}
