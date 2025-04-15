package br.com.serasa.teste.cadastro.pessoa.service;

import br.com.serasa.teste.cadastro.pessoa.model.DadosCepDTO;
import br.com.serasa.teste.cadastro.pessoa.model.PessoaDTO;

public interface PessoaService {

    DadosCepDTO buscaCep(String cep);

    void cadastraPessoa(PessoaDTO request);
}
