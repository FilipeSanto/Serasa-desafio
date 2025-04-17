package br.com.serasa.teste.cadastro.pessoa.model.pessoa;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class PessoaCompleteDTO extends PessoaDTO {
    private Long id;
    private boolean ativo;

    public PessoaCompleteDTO(Long id, boolean ativo) {
        this.id = id;
        this.ativo = ativo;
    }

    public PessoaCompleteDTO(String nome, int idade, String cep, String estado, String cidade, String bairro,
            String logradouro, String telefone, int score, Long id, boolean ativo) {
        super(nome, idade, cep, estado, cidade, bairro, logradouro, telefone, score);
        this.id = id;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
