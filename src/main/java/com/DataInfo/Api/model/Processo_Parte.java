package com.DataInfo.Api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Processo_Parte implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_processo")
    private Processo processo;

    @ManyToOne
    @JoinColumn(name = "id_Parte")
    private Parte parte;

    public Processo_Parte() {}

    public Processo_Parte(Long id, Processo processo, Parte parte) {
        this.id = id;
        this.processo = processo;
        this.parte = parte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Parte getParte() {
        return parte;
    }

    public void setParte(Parte parte) {
        this.parte = parte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processo_Parte)) return false;
        Processo_Parte that = (Processo_Parte) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Processo_Parte{" +
                "id=" + id +
                ", processo=" + processo +
                ", parte=" + parte +
                '}';
    }
}
