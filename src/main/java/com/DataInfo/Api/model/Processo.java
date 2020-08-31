package com.DataInfo.Api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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

    @ManyToMany
    @JoinTable(name = "processo_parte", 
               joinColumns = @JoinColumn(name = "id_processo"),
               inverseJoinColumns = @JoinColumn(name = "id_parte"))
    private List<Parte> partes = new ArrayList<>();

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

    public List<Parte> getPartes() {
        return partes;
    }

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
		return "Processo [id=" + id + ", "
				+ "nr_Processo=" + nr_Processo + ", "
				+ "data_Criacao=" + data_Criacao
				+ ", data_distribuicao=" + data_distribuicao + ", "
				+ "classe=" + classe + ", partes="
				+ partes + "]";
	}

    
}
