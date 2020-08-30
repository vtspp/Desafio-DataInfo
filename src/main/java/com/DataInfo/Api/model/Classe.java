package com.DataInfo.Api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String id_Cnj;
    private String ds_Classe;
    private String sigla;
    private String tipo;

    @OneToMany
    @JoinColumn(name = "id_classe")
    private Set<Processo> processos = new HashSet<>();

    public Classe() {}

    public Classe(Long id, String id_Cnj, String ds_Classe, String sigla, String tipo) {
        this.id = id;
        this.id_Cnj = id_Cnj;
        this.ds_Classe = ds_Classe;
        this.sigla = sigla;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_Cnj() {
        return id_Cnj;
    }

    public void setId_Cnj(String id_Cnj) {
        this.id_Cnj = id_Cnj;
    }

    public String getDs_Classe() {
        return ds_Classe;
    }

    public void setDs_Classe(String ds_Classe) {
        this.ds_Classe = ds_Classe;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Processo> getProcessos() {
        return processos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classe)) return false;
        Classe classe = (Classe) o;
        return getId().equals(classe.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", id_Cnj='" + id_Cnj + '\'' +
                ", ds_Classe='" + ds_Classe + '\'' +
                ", sigla='" + sigla + '\'' +
                ", tipo='" + tipo + '\'' +
                ", processos=" + processos +
                '}';
    }
}
