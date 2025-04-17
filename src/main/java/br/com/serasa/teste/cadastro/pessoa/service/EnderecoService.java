package br.com.serasa.teste.cadastro.pessoa.service;

import br.com.serasa.teste.cadastro.pessoa.model.endereco.DadosCepDTO;

public interface EnderecoService {

    DadosCepDTO buscaCep(String cep);

}
