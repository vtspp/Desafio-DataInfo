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
import javax.persistence.OneToMany;

@Entity
public class Parte implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Date data_Nascimento;
    private String cpf;
    private String tipo_Parte;

    @OneToMany
    @JoinColumn(name = "id_Parte")
    private Set<Processo_Parte> processo_Parte = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "id_parte")
    private Set<Endereco_Parte> endereco_Parte = new HashSet<>();

    public Parte() {}

    public Parte(Long id, String nome, Date data_Nascimento, String cpf, String tipo_Parte) {
        this.id = id;
        this.nome = nome;
        this.data_Nascimento = data_Nascimento;
        this.cpf = cpf;
        this.tipo_Parte = tipo_Parte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo_Parte() {
        return tipo_Parte;
    }

    public void setTipo_Parte(String tipo_Parte) {
        this.tipo_Parte = tipo_Parte;
    }

    public Set<Processo_Parte> getProcessoPartes() {
        return processo_Parte;
    }

    public Set<Endereco_Parte> getEndereco_partes() {
        return endereco_Parte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parte)) return false;
        Parte parte = (Parte) o;
        return getId().equals(parte.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Parte{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data_Nascimento=" + data_Nascimento +
                ", cpf='" + cpf + '\'' +
                ", tipo_Parte='" + tipo_Parte + '\'' +
                ", processo_Parte=" + processo_Parte +
                ", endereco_Parte=" + endereco_Parte +
                '}';
    }
}
