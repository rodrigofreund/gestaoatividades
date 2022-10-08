package com.abc.avaliando.gestaoatividades.util;

import org.springframework.util.StringUtils;

public class Strings {
    
    //Open closed principle - para alterar a biblioteca StringUtils não precisa alterar classes de negócio do sitema
    public static boolean possuiTexto(String texto) {
        return StringUtils.hasText(texto);
        
    }
}
