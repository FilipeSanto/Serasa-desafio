package br.com.serasa.teste.cadastro.pessoa.model.endereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosCepDTO {
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
}
