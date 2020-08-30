package com.DataInfo.Api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nr_Processo;
    private Date data_Criacao;
    private Date data_distribuicao;

    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;

    @OneToMany
    @JoinColumn(name = "id_processo")
    private Set<Processo_Parte> processoPartes = new HashSet<>();

    public Processo() {}

    public Processo(Long id, String nr_Processo, Date data_Criacao,
                    Date data_distribuicao, Classe classe) {
        this.id = id;
        this.nr_Processo = nr_Processo;
        this.data_Criacao = data_Criacao;
        this.data_distribuicao = data_distribuicao;
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNr_Processo() {
        return nr_Processo;
    }

    public void setNr_Processo(String nr_Processo) {
        this.nr_Processo = nr_Processo;
    }

    public Date getData_Criacao() {
        return data_Criacao;
    }

    public void setData_Criacao(Date data_Criacao) {
        this.data_Criacao = data_Criacao;
    }

    public Date getData_distribuicao() {
        return data_distribuicao;
    }

    public void setData_distribuicao(Date data_distribuicao) {
        this.data_distribuicao = data_distribuicao;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

   /* public Set<Processo_Parte> getProcessoPartes() {
        return processoPartes;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processo)) return false;
        Processo processo = (Processo) o;
        return getId().equals(processo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", nr_Processo='" + nr_Processo + '\'' +
                ", data_Criacao=" + data_Criacao +
                ", data_distribuicao=" + data_distribuicao +
                ", classe=" + classe +
                ", processoPartes=" /*+ processoPartes*/ +
                '}';
    }
}
