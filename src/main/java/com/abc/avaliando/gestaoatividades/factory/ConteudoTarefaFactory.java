package com.abc.avaliando.gestaoatividades.factory;

import com.abc.avaliando.gestaoatividades.exception.ConteudoArquivoFormatoInvalido;
import com.abc.avaliando.gestaoatividades.model.ConteudoTarefa;
import com.abc.avaliando.gestaoatividades.model.EnvioTexto;
import com.abc.avaliando.gestaoatividades.model.FormatoEntrega;

import org.springframework.stereotype.Component;

@Component
public class ConteudoTarefaFactory<T> {
    public ConteudoTarefa create(FormatoEntrega formato) throws ConteudoArquivoFormatoInvalido {
        switch(formato) {
            case TEXTO:
                return new EnvioTexto();
            default:
                throw new ConteudoArquivoFormatoInvalido();
        }
    }
}
