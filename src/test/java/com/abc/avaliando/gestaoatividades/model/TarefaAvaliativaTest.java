package com.abc.avaliando.gestaoatividades.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import com.abc.avaliando.gestaoatividades.exception.TarefaForaLimitesValoresAvaliacao;
import com.abc.avaliando.gestaoatividades.util.DataHora;

import org.junit.jupiter.api.Test;

public class TarefaAvaliativaTest implements AbstractTest {

    @Test
    public void criandoTarefaAvaliativa() throws Exception {

        int peso = 100;

        LocalDateTime entrega = DataHora.getDataHoraSistema().plusDays(20);

        TarefaAvaliativa tarefaAvaliativa = criarTarefaAvaliativa(entrega, peso);

        assertTrue(tarefaAvaliativa.getPercentualAvaliacao() > 0);

    }

    @Test
    public void criandoTarefaAvaliativaPesoForaLimites() throws Exception {

        int peso = 101;

        LocalDateTime entrega = DataHora.getDataHoraSistema().plusDays(20);

        assertThrows(TarefaForaLimitesValoresAvaliacao.class, () -> criarTarefaAvaliativa(entrega, peso));

    }
}
