package com.abc.avaliando.gestaoatividades.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import com.abc.avaliando.gestaoatividades.exception.TarefaNaoPermiteEnvioException;
import com.abc.avaliando.gestaoatividades.util.DataHora;

import org.junit.jupiter.api.Test;

public class EntregaTarefaPrazoTest implements AbstractTest {

    @Test
    public void envioTarefaNoPrazo() throws Exception {

        Tarefa tarefa = criarTarefaComPrazo(20);

        EnvioTarefa envio = new EnvioTarefa(tarefa);

        envio.setDadosTarefa(new EnvioTexto("Conteudo do trabalho"));

        LocalDateTime dataEnvioConfirmado = DataHora.getDataHoraSistema().plusMinutes(1);

        envio.finalizaTarefa(dataEnvioConfirmado);

        assertNotNull(envio.getDataHoraConfirmacaoEnvio());
        assertNotNull(envio.getDataHoraRealizacaoTarefa());
    }

    @Test
    public void envioTarefaForaPrazo() throws Exception {

        Tarefa tarefa = criarTarefaComPrazo(DataHora.getDataHoraSistema().minusDays(1));

        assertThrows(TarefaNaoPermiteEnvioException.class, () -> new EnvioTarefa(tarefa));

    }
    
    @Test
    public void envioTarefaNoPrazoComEnvioPostumo() throws Exception {
        
        final int dias = 0;
        
        final Tarefa tarefa = criarTarefaComPrazoEnvioForaPrazoPostumo(dias);

        final EnvioTarefa envio = new EnvioTarefa(tarefa);

        envio.setDadosTarefa(new EnvioTexto("Conteudo do trabalho"));

        LocalDateTime dataEnvioConfirmado = DataHora.getDataHoraSistema().plusMinutes(1);

        envio.finalizaTarefa(dataEnvioConfirmado);

        assertNotNull(envio.getDataHoraConfirmacaoEnvio());
        assertNotNull(envio.getDataHoraRealizacaoTarefa());
    }
    
    @Test
    public void envioTarefaForaPrazoComEnvioPostumo() throws Exception {
        
        final int dias = -1;
        
        final Tarefa tarefa = criarTarefaComPrazoEnvioForaPrazoPostumo(dias);

        final EnvioTarefa envio = new EnvioTarefa(tarefa);

        envio.setDadosTarefa(new EnvioTexto("Conteudo do trabalho"));

        LocalDateTime dataEnvioConfirmado = DataHora.getDataHoraSistema().plusMinutes(1);

        envio.finalizaTarefa(dataEnvioConfirmado);

        assertNotNull(envio.getDataHoraConfirmacaoEnvio());
        assertNotNull(envio.getDataHoraRealizacaoTarefa());
    }
}
