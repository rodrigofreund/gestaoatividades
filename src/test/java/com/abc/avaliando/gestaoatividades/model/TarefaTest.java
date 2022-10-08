package com.abc.avaliando.gestaoatividades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.abc.avaliando.gestaoatividades.exception.AtividadeAcademicaInvalidaException;
import com.abc.avaliando.gestaoatividades.exception.DescricaoTarefaInvalidaException;
import com.abc.avaliando.gestaoatividades.exception.FormatoTarefaInvalidaException;

import org.junit.jupiter.api.Test;

public class TarefaTest implements AbstractTest {

    @Test
    public void criandoTarefa() throws Exception {
        
        AtividadeAcademica atividadeAcademica = AtividadeAcademica.getAtivo();
        String descricao = "Descrição da atividade";
        FormatoEntrega formato = FormatoEntrega.TEXTO;

        Tarefa tarefa = new Tarefa(atividadeAcademica, descricao, formato);

        assertEquals(descricao, tarefa.getDescricao());
        assertEquals(formato, tarefa.getFormato());
    }

    @Test
    public void criandoTarefaAtividadeInativa() {
        AtividadeAcademica atividadeAcademica = AtividadeAcademica.getInativo();
        String descricao = "Descrição da atividade";
        FormatoEntrega formato = FormatoEntrega.TEXTO;

        assertThrows(AtividadeAcademicaInvalidaException.class,
                () -> new Tarefa(atividadeAcademica, descricao, formato));
    }
    
    @Test
    public void criandoTarefaSemAtividadeAcedemica() throws Exception {
        AtividadeAcademica atividadeAcademica = null;
        String descricao = "Descrição da atividade";
        FormatoEntrega formato = null;
        
        assertThrows(AtividadeAcademicaInvalidaException.class,
                () -> new Tarefa(atividadeAcademica, descricao, formato));
    }
    
    @Test
    public void criandoTarefaSemDescricao() {
        AtividadeAcademica atividadeAcademica = AtividadeAcademica.getAtivo();
        String descricao = "";
        FormatoEntrega formato = FormatoEntrega.TEXTO;

        assertThrows(DescricaoTarefaInvalidaException.class,
                () -> new Tarefa(atividadeAcademica, descricao, formato));
    }
    
    @Test
    public void criandoTarefaSemFormatoEntrega() throws Exception {
        AtividadeAcademica atividadeAcademica = AtividadeAcademica.getAtivo();
        String descricao = "Descrição da atividade";
        FormatoEntrega formato = null;
        
        assertThrows(FormatoTarefaInvalidaException.class,
                () -> new Tarefa(atividadeAcademica, descricao, formato));
    }
    

}
