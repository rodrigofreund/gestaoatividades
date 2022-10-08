package com.abc.avaliando.gestaoatividades.model;

import com.abc.avaliando.gestaoatividades.util.Strings;

public class EnvioTexto implements ConteudoTarefa {
    
    private String texto;
    
    public EnvioTexto() { }
    
    public EnvioTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String getHash() {
        return texto;
    }

    @Override
    public boolean valido() {
        return Strings.possuiTexto(texto);
    }

    @Override
    public void setConteudo(Object dado) {
        texto = (String) dado;
        
    }

}
