package com.DataInfo.Api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco_parte")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String logadouro;
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_parte")
    private Parte parte;

    public Endereco() {}

    public Endereco(Long id, String bairro, String cidade,
                          String estado, String cep, String logadouro,
                          Integer numero, Parte parte) {
        this.id = id;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.logadouro = logadouro;
        this.numero = numero;
        this.parte = parte;
    }

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        return this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public String setBairro(String bairro) {
        return this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String setCidade(String cidade) {
        return this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String setEstado(String estado) {
        return this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public String  setCep(String cep) {
        return this.cep = cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public String setLogadouro(String logadouro) {
        return this.logadouro = logadouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer setNumero(Integer numero) {
        return this.numero = numero;
    }

    public Parte getParte() {
        return parte;
    }

    public Parte setParte(Parte parte) {
        return this.parte = parte;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep="
				+ cep + ", logadouro=" + logadouro + ", numero=" + numero + ", parte=" + parte + "]";
	}
   
}
