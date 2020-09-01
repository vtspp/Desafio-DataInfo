package com.DataInfo.Api.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_processo")
public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nr_Processo;
    private Instant data_Criacao;
    private Instant data_distribuicao;

    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;

    @OneToMany(mappedBy = "processo")
    private List<ProcessoParte> processoPartes = new ArrayList<>();

    public Processo() {}

    public Processo(Long id, String nr_Processo, Instant data_Criacao,
                    Instant data_distribuicao/*, Classe classe*/) {
        this.id = id;
        this.nr_Processo = nr_Processo;
        this.data_Criacao = data_Criacao;
        this.data_distribuicao = data_distribuicao;
        /*this.classe = classe;*/
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

    public Instant getData_Criacao() {
        return data_Criacao;
    }

    public void setData_Criacao(Instant data_Criacao) {
        this.data_Criacao = data_Criacao;
    }

    public Instant getData_distribuicao() {
        return data_distribuicao;
    }

    public void setData_distribuicao(Instant data_distribuicao) {
        this.data_distribuicao = data_distribuicao;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<ProcessoParte> getPartes() {
        return processoPartes;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nr_Processo == null) ? 0 : nr_Processo.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", "
				+ "nr_Processo=" + nr_Processo + ", "
				+ "data_Criacao=" + data_Criacao
				+ ", data_distribuicao=" + data_distribuicao + ", "
				+ "classe=" + classe + ", processoPartes="
				+ processoPartes + "]";
	}

    
}
