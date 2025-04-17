package br.com.serasa.teste.cadastro.pessoa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "PESSOA_SEQ", allocationSize = 1)
    private Long id;
    private String nome;
    private int idade;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String telefone;
    private int score;
    private boolean ativo = true;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, int idade, String cep, String estado, String cidade, String bairro,
            String logradouro, String telefone, int score, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.score = score;
        this.ativo = ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void ativar() {
        this.ativo = true;
    }
}