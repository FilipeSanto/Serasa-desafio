package br.com.serasa.teste.cadastro.pessoa.model.pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
public class PessoaDTO {

    private String nome;
    private int idade;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    @JsonProperty(required = false)
    private String descScore;
    private String logradouro;
    private String telefone;
    private int score;

    public PessoaDTO() {
    }

    public PessoaDTO(String nome, int idade, String cep, String estado, String cidade, String bairro, String logradouro, String telefone, int score) {
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.score = score;
    }

    public String getDescScore() {
        return descScore;
    }

    public void setDescScore(String descScore) {
        this.descScore = descScore;
    }

    @JsonProperty
    public String getNome() {
        return nome;
    }

    @JsonProperty
    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void validarScore() {
        if (score >= 0 && score <= 200) {
            this.descScore = "Insuficiente";
        } else if (score >= 201 && score <= 500) {
            this.descScore = "Inaceitável";
        } else if (score >= 501 && score <= 700) {
            this.descScore = "Aceitável";
        } else if (score >= 701 && score <= 1000) {
            this.descScore = "Recomendável";
        } else {
            this.descScore = "Valor Inválido";
        }
    }
}