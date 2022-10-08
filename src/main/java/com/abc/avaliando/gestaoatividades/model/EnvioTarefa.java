package com.abc.avaliando.gestaoatividades.model;

import java.time.LocalDateTime;

import com.abc.avaliando.gestaoatividades.exception.DadosEnvioTarefaInvalido;
import com.abc.avaliando.gestaoatividades.exception.ModelException;
import com.abc.avaliando.gestaoatividades.exception.TarefaNaoPermiteEnvioException;
import com.abc.avaliando.gestaoatividades.util.DataHora;

public class EnvioTarefa {
    
    private ConteudoTarefa dadosTarefa;
    private LocalDateTime dataHoraRealizacaoTarefa;
    private LocalDateTime dataHoraConfirmacaoEnvio;


    public EnvioTarefa(final Tarefa tarefa) throws ModelException {
        if(tarefa.permiteEnvio()) {
            this.dataHoraRealizacaoTarefa = DataHora.getDataHoraSistema();
            return;
        }
        throw new TarefaNaoPermiteEnvioException();
    }

    public void setDadosTarefa(final ConteudoTarefa conteudoTarefa) {
        this.dadosTarefa = conteudoTarefa;
    }

    public void finalizaTarefa(LocalDateTime dataHoraConfirmacaoEnvio) throws DadosEnvioTarefaInvalido {
        if(dadosTarefa != null && dadosTarefa.valido()) {
            this.dataHoraConfirmacaoEnvio = dataHoraConfirmacaoEnvio;
            return;
        }
        throw new DadosEnvioTarefaInvalido();
    }

    public ConteudoTarefa getDadosTarefa() {
        return dadosTarefa;
    }

    public LocalDateTime getDataHoraRealizacaoTarefa() {
        return dataHoraRealizacaoTarefa;
    }

    public LocalDateTime getDataHoraConfirmacaoEnvio() {
        return dataHoraConfirmacaoEnvio;
    }

}
