package com.DataInfo.Api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_classe")
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String id_Cnj;
    private String ds_Classe;
    private String sigla;
    private String tipo;

    @OneToMany(mappedBy = "classe")
    private List<Processo> processos = new ArrayList<>();

    public Classe() {}

    public Classe(Long id, String id_Cnj, String ds_Classe, 
    		      String sigla, String tipo) {
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

    public List<Processo> getProcessos() {
        return processos;
    } 

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ds_Classe == null) ? 0 : ds_Classe.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Cnj == null) ? 0 : id_Cnj.hashCode());
		result = prime * result + ((processos == null) ? 0 : processos.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Classe other = (Classe) obj;
		if (ds_Classe == null) {
			if (other.ds_Classe != null)
				return false;
		} else if (!ds_Classe.equals(other.ds_Classe))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_Cnj == null) {
			if (other.id_Cnj != null)
				return false;
		} else if (!id_Cnj.equals(other.id_Cnj))
			return false;
		if (processos == null) {
			if (other.processos != null)
				return false;
		} else if (!processos.equals(other.processos))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
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
