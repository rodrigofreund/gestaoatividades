package com.abc.avaliando.gestaoatividades.model;

import java.time.LocalDateTime;

import com.abc.avaliando.gestaoatividades.util.DataHora;

public interface AbstractTest {

    default Tarefa criarTarefa() throws Exception {

        AtividadeAcademica atividadeAcademica = AtividadeAcademica.getAtivo();
        String descricao = "Descrição da atividade";
        FormatoEntrega formato = FormatoEntrega.TEXTO;

        return new Tarefa(atividadeAcademica, descricao, formato);
    }

    default TarefaPrazo criarTarefaComPrazoEnvioForaPrazoPostumo(long dias) throws Exception {
        return criarTarefaComPrazoPermiteEnvioPostumo(DataHora.getDataHoraSistema().plusDays(dias));
    }

    default TarefaPrazo criarTarefaComPrazo(long dias) throws Exception {
        return criarTarefaComPrazo(DataHora.getDataHoraSistema().plusDays(dias));
    }

    default TarefaPrazo criarTarefaComPrazo(LocalDateTime dataEntrega) throws Exception {

        Tarefa tarefa = criarTarefa();

        return new TarefaPrazo(tarefa.getAtividadeAcademica(), tarefa.getDescricao(),
                tarefa.getFormato(), dataEntrega);
    }

    private TarefaPrazo criarTarefaComPrazoPermiteEnvioPostumo(LocalDateTime dataEntrega) throws Exception {

        Tarefa tarefa = criarTarefa();

        TarefaPrazo tarefaPrazo = new TarefaPrazo(tarefa.getAtividadeAcademica(), tarefa.getDescricao(),
                tarefa.getFormato(), dataEntrega);
        tarefaPrazo.setPermiteEntregaForaPrazo(true);

        return tarefaPrazo;
    }
    
    default TarefaAvaliativa criarTarefaAvaliativa(LocalDateTime dataEntrega, int peso) throws Exception {

        Tarefa tarefa = criarTarefa();

        return new TarefaAvaliativa(tarefa.getAtividadeAcademica(), tarefa.getDescricao(),
                tarefa.getFormato(), dataEntrega, peso);
    }
}
