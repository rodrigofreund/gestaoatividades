package com.abc.avaliando.gestaoatividades.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.abc.avaliando.gestaoatividades.exception.DadosEnvioTarefaInvalido;
import com.abc.avaliando.gestaoatividades.util.DataHora;

import org.junit.jupiter.api.Test;

public class EntregaTarefaTest implements AbstractTest {

    @Test
    public void envioTarefaSemPrazoEntrega() throws Exception {
        
        Tarefa tarefa = criarTarefa();

        EnvioTarefa envioTarefa = new EnvioTarefa(tarefa);
        
        ConteudoTarefa conteudo = new EnvioTexto("dados da tarefa");
        
        envioTarefa.setDadosTarefa(conteudo);

        envioTarefa.finalizaTarefa(DataHora.getDataHoraSistema());

        assertNotNull(envioTarefa.getDadosTarefa());
        assertNotNull(envioTarefa.getDataHoraRealizacaoTarefa());
        assertNotNull(envioTarefa.getDataHoraConfirmacaoEnvio());
    }

    @Test
    public void envioTarefaSemPrazoEntregaSemConteudo() throws Exception {

        Tarefa tarefa = criarTarefa();

        EnvioTarefa envioTarefa = new EnvioTarefa(tarefa);

        assertThrows(DadosEnvioTarefaInvalido.class, () -> envioTarefa.finalizaTarefa(DataHora.getDataHoraSistema()));

    }
}
