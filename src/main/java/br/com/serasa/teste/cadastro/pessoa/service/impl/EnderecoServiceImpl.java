package br.com.serasa.teste.cadastro.pessoa.service.impl;

import br.com.serasa.teste.cadastro.pessoa.itg.dto.EnderecoDTO;
import br.com.serasa.teste.cadastro.pessoa.itg.service.ConsultaCepService;
import br.com.serasa.teste.cadastro.pessoa.model.endereco.DadosCepDTO;
import br.com.serasa.teste.cadastro.pessoa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private ConsultaCepService consultaCepService;

    @Override
    public DadosCepDTO buscaCep(String cep) {
        EnderecoDTO response = consultaCepService.consultaCep(cep);
        return buildResponse(response);
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
