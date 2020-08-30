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
public class Processo_Juiz implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_procsso")
    private Processo processo;
    
    @ManyToOne
    @JoinColumn(name = "id_juiz")
    private Juiz juiz;

    public Processo_Juiz(Long id, Processo processo, Juiz juiz) {
        this.id = id;
        this.processo = processo;
        this.juiz = juiz;
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

    public Juiz getJuiz() {
        return juiz;
    }

    public void setJuiz(Juiz juiz) {
        this.juiz = juiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processo_Juiz)) return false;
        Processo_Juiz that = (Processo_Juiz) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Processo_Juiz{" +
                "id=" + id +
                ", processo=" + processo +
                ", juiz=" + juiz +
                '}';
    }
}
