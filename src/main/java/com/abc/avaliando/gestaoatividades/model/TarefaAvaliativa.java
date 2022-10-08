package com.abc.avaliando.gestaoatividades.model;

import java.time.LocalDateTime;

import com.abc.avaliando.gestaoatividades.exception.ModelException;
import com.abc.avaliando.gestaoatividades.exception.TarefaForaLimitesValoresAvaliacao;

import lombok.Getter;

public class TarefaAvaliativa extends TarefaPrazo {
    
    
    @Getter
    private int peso;

    public TarefaAvaliativa(AtividadeCurricular atividadeAcademica, String descricao, FormatoEntrega formato,
            LocalDateTime prazoEntrega, int peso) throws ModelException {
        
        super(atividadeAcademica, descricao, formato, prazoEntrega);
        
        if(validaLimitesPesoTarefa(atividadeAcademica, peso)) {
            this.peso = peso;
            return;
        }
        
        throw new TarefaForaLimitesValoresAvaliacao();
    }
    
    @Override
    public int getPercentualAvaliacao() {
        return peso * getAtividadeAcademica().getPesoMaximoAvaliacao() / 100;
    }

    private boolean validaLimitesPesoTarefa(AtividadeCurricular atividadeAcademica, int peso) {
        return peso <= atividadeAcademica.getPesoMaximoAvaliacao() && peso > atividadeAcademica.getPesoMinimoAvaliacao();
    }
    
}
