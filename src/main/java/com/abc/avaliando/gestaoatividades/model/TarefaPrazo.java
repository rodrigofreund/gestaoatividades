package com.abc.avaliando.gestaoatividades.model;

import java.time.LocalDateTime;

import com.abc.avaliando.gestaoatividades.exception.ModelException;
import com.abc.avaliando.gestaoatividades.util.DataHora;

public class TarefaPrazo extends Tarefa {

    private LocalDateTime prazoEntrega;

    private boolean permiteEntregaForaPrazo;

    public TarefaPrazo(AtividadeCurricular atividadeAcademica, String descricao, FormatoEntrega formato,
            LocalDateTime prazoEntrega) throws ModelException {
        super(atividadeAcademica, descricao, formato);
        if(prazoEntrega == null) {
            
        }
        this.prazoEntrega = prazoEntrega;
    }
    
    @Override
    public boolean permiteEnvio() {
        if (!super.permiteEnvio()) {
            return false;
        }

        if (permiteEntregaForaPrazo) {
            return true;
        }

        if (podeEnviarNaData(DataHora.getDataHoraSistema())) {
            return true;
        }

        return false;
    }

    public LocalDateTime getPrazoEntrega() {
        return prazoEntrega;
    }

    @Override
    public boolean getPermiteEntregaForaPrazo() {
        return this.permiteEntregaForaPrazo;
    }

    @Override
    public void setPermiteEntregaForaPrazo(boolean b)  throws ModelException {
        this.permiteEntregaForaPrazo = b;
    }
    
    @Override
    public int getPercentualAvaliacao() {
        return 0;
    }

    private boolean podeEnviarNaData(LocalDateTime dataHoraEnvio) {
        return dataHoraEnvio.isBefore(prazoEntrega) || dataHoraEnvio.isEqual(prazoEntrega);
    }

}
