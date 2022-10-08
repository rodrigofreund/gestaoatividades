package com.abc.avaliando.gestaoatividades.model;

import com.abc.avaliando.gestaoatividades.exception.AtividadeAcademicaInvalidaException;
import com.abc.avaliando.gestaoatividades.exception.DescricaoTarefaInvalidaException;
import com.abc.avaliando.gestaoatividades.exception.FormatoTarefaInvalidaException;
import com.abc.avaliando.gestaoatividades.exception.ModelException;
import com.abc.avaliando.gestaoatividades.exception.TarefaNaoPermiteEntregaForaPrazo;
import com.abc.avaliando.gestaoatividades.util.Strings;

public class Tarefa {

    private AtividadeCurricular atividadeAcademica;
    private String descricao;
    private FormatoEntrega formato;

    public Tarefa(final AtividadeCurricular atividadeAcademica, String descricao, FormatoEntrega formato)
            throws ModelException {
        
        if(atividadeAcademica == null) {
            throw new AtividadeAcademicaInvalidaException(
                    "atividade acadêmica não informada.");
        }

        if (atividadeAcademica.bloqueadoParaCriacaoTarefas()) {
            throw new AtividadeAcademicaInvalidaException(
                    "não é possível criar Tarefas para atividades acadêmicas inativas.");
        }
        this.atividadeAcademica = atividadeAcademica;

        if (descricaoTarefaInvalida(descricao)) {
            throw new DescricaoTarefaInvalidaException();
        }
        this.descricao = descricao;

        if (formato == null) {
            throw new FormatoTarefaInvalidaException();
        }
        this.formato = formato;
    }
    
    public boolean permiteEnvio() {
        if(atividadeAcademica.permiteEnvioTarefas()) {
            return true;
        }
        return false;
    }

    public String getDescricao() {
        return descricao;
    }

    public FormatoEntrega getFormato() {
        return formato;
    }
    
    public AtividadeCurricular getAtividadeAcademica() {
        return this.atividadeAcademica;
    }

    private boolean descricaoTarefaInvalida(String descricao) {
        return !Strings.possuiTexto(descricao);
    }

    public int getPercentualAvaliacao() {
        return 0;
    }
    
    public boolean getPermiteEntregaForaPrazo() {
        return false;
    }
    
    public void setPermiteEntregaForaPrazo(boolean b) throws ModelException {
        throw new TarefaNaoPermiteEntregaForaPrazo();
    }

}
