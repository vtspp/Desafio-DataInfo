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
public class Juiz implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private Date data_Nascimento;

    @OneToMany
    @JoinColumn(name = "id_juiz")
    private Set<Processo_Juiz> processo_juiz = new HashSet<>();

    public Juiz(){}

    public Juiz(Long id, String nome, String cpf, Date data_Nascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_Nascimento = data_Nascimento;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public Set<Processo_Juiz> getProcesso_juiz() {
        return processo_juiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juiz)) return false;
        Juiz juiz = (Juiz) o;
        return getId().equals(juiz.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Juiz{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_Nascimento=" + data_Nascimento +
                ", processo_juiz=" + processo_juiz +
                '}';
    }
}
