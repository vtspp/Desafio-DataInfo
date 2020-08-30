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
public class Endereco_Parte implements Serializable {
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

    public Endereco_Parte() {}

    public Endereco_Parte(Long id, String bairro, String cidade,
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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
        if (!(o instanceof Endereco_Parte)) return false;
        Endereco_Parte that = (Endereco_Parte) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Endereco_Parte{" +
                "id=" + id +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", logadouro='" + logadouro + '\'' +
                ", numero=" + numero +
                ", parte=" + parte +
                '}';
    }
}
