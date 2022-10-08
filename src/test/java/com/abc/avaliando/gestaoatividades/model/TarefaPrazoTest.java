package com.abc.avaliando.gestaoatividades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TarefaPrazoTest {

    @Test
    public void criandoTarefaComPrazo() throws Exception {
        AtividadeAcademica atividadeAcademica = AtividadeAcademica.getAtivo();
        String descricao = "Descrição da atividade";
        FormatoEntrega formato = FormatoEntrega.TEXTO;

        LocalDateTime prazoEntrega = LocalDateTime.now();

        TarefaPrazo tarefaPrazo = new TarefaPrazo(atividadeAcademica, descricao, formato, prazoEntrega);

        assertEquals(prazoEntrega, tarefaPrazo.getPrazoEntrega());
        assertFalse(tarefaPrazo.getPermiteEntregaForaPrazo());
    }
    
    @Test
    public void criandoTarefaComPrazoEPermiteEntregaDepoisPrazo() throws Exception {
        AtividadeAcademica atividadeAcademica = AtividadeAcademica.getAtivo();
        String descricao = "Descrição da atividade";
        FormatoEntrega formato = FormatoEntrega.TEXTO;

        LocalDateTime prazoEntrega = LocalDateTime.now();

        TarefaPrazo tarefaPrazo = new TarefaPrazo(atividadeAcademica, descricao, formato, prazoEntrega);
        
        tarefaPrazo.setPermiteEntregaForaPrazo(true);

        assertEquals(prazoEntrega, tarefaPrazo.getPrazoEntrega());
        assertTrue(tarefaPrazo.getPermiteEntregaForaPrazo());
    }
}
