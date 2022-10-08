package com.abc.avaliando.gestaoatividades.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class AtividadeAcademica {
    @Id
    private Long numero;
    private int ano;
    private int semestre;
    private String estado;
}
