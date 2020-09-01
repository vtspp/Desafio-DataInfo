package com.DataInfo.Api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_processo_juiz")
public class ProcessoJuiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_processo")
	private Processo processo;

	@ManyToOne
	@JoinColumn(name = "id_juiz")
	private Juiz juiz;

	public ProcessoJuiz() {
	}

	public ProcessoJuiz(Long id, Processo processo, Juiz juiz) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProcessoJuiz other = (ProcessoJuiz) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProcessoJuiz [id=" + id + ", processo=" + processo + ", juiz=" + juiz + "]";
	}

}
