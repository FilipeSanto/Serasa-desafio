package br.com.serasa.teste.cadastro.pessoa.itg.service;

import br.com.serasa.teste.cadastro.pessoa.itg.dto.EnderecoDTO;

public interface ConsultaCepService {

    EnderecoDTO consultaCep(String cep);
}
