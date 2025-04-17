package br.com.serasa.teste.cadastro.pessoa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.serasa.teste.cadastro.pessoa.exception.EnderecoException;
import br.com.serasa.teste.cadastro.pessoa.itg.dto.EnderecoDTO;
import br.com.serasa.teste.cadastro.pessoa.itg.service.ConsultaCepService;
import br.com.serasa.teste.cadastro.pessoa.model.endereco.DadosCepDTO;
import br.com.serasa.teste.cadastro.pessoa.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private ConsultaCepService consultaCepService;

    @Override
    public DadosCepDTO buscaCep(String cep) {
        try {
            EnderecoDTO response = consultaCepService.consultaCep(cep);
            if (response.getCep() == null) {
                throw new EnderecoException("CEP não encontrado.");
            }
            return buildResponse(response);
        } catch (HttpClientErrorException e) {
            throw new EnderecoException("CEP não encontrado.");
        }
    }

    private DadosCepDTO buildResponse(EnderecoDTO response) {

        return DadosCepDTO.builder()
                .cep(response.getCep())
                .bairro(response.getBairro())
                .cidade(response.getLocalidade())
                .estado(response.getEstado())
                .logradouro(response.getLogradouro())
                .build();

    }
}
