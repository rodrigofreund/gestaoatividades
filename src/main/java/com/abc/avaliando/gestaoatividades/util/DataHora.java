package com.abc.avaliando.gestaoatividades.util;

import java.time.LocalDateTime;
import java.time.Month;

public class DataHora {
    public static LocalDateTime getDataHoraSistema() {
        return LocalDateTime.of(2000, Month.MARCH, 21, 21, 0);
    }
}
