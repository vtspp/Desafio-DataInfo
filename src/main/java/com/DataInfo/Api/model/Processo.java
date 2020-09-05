package com.DataInfo.Api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_processo")
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

    /*@OneToMany(mappedBy = "processo")
    @JsonIgnore
    private List<ProcessoParte> processoPartes = new ArrayList<>();*/

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

    /*public List<ProcessoParte> getPartes() {
        return processoPartes;
    }*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((data_Criacao == null) ? 0 : data_Criacao.hashCode());
		result = prime * result + ((data_distribuicao == null) ? 0 : data_distribuicao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nr_Processo == null) ? 0 : nr_Processo.hashCode());
		/*result = prime * result + ((processoPartes == null) ? 0 : processoPartes.hashCode());*/
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (data_Criacao == null) {
			if (other.data_Criacao != null)
				return false;
		} else if (!data_Criacao.equals(other.data_Criacao))
			return false;
		if (data_distribuicao == null) {
			if (other.data_distribuicao != null)
				return false;
		} else if (!data_distribuicao.equals(other.data_distribuicao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nr_Processo == null) {
			if (other.nr_Processo != null)
				return false;
		} else if (!nr_Processo.equals(other.nr_Processo))
			return false;
		/*if (processoPartes == null) {
			if (other.processoPartes != null)
				return false;
		} else if (!processoPartes.equals(other.processoPartes))
			return false;*/
		return true;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", nr_Processo=" + nr_Processo + ", data_Criacao=" + data_Criacao
				+ ", data_distribuicao=" + data_distribuicao + ", classe=" + classe + ", processoPartes="
				+ /*processoPartes +*/ "]";
	}

    
}
