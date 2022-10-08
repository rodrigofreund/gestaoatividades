package com.abc.avaliando.gestaoatividades.model;

//OCP
public class AtividadeAcademica implements AtividadeCurricular {
    
    private AtividadeAcademicaEstado estado;
    
    private AtividadeAcademica() {
        this.estado = AtividadeAcademicaEstado.ATIVO;
    }

    public AtividadeAcademica(AtividadeAcademicaEstado estado) {
        this.estado = estado;
    }
    
    @Override
    public boolean bloqueadoParaCriacaoTarefas() {
        return this.estado.equals(AtividadeAcademicaEstado.INATIVO);
    }
    
    @Override
    public boolean permiteEnvioTarefas() {
        return this.estado.equals(AtividadeAcademicaEstado.ATIVO);
    }
    
    public static AtividadeAcademica getAtivo() {
        return new AtividadeAcademica();
    }
    
    public static AtividadeAcademica getInativo() {
        return new AtividadeAcademica(AtividadeAcademicaEstado.INATIVO);
    }

    @Override
    public int getPesoMinimoAvaliacao() {
        return 10;
    }

    @Override
    public int getPesoMaximoAvaliacao() {
        return 100;
    }
}
