package br.com.serasa.teste.cadastro.pessoa.itg.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.serasa.teste.cadastro.pessoa.itg.dto.EnderecoDTO;
import br.com.serasa.teste.cadastro.pessoa.itg.service.ConsultaCepService;

@Service
public class ConsultaCepServiceImpl implements ConsultaCepService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${consulta.cep.url}")
    private String consultaCepUrl;

    @Override
    public EnderecoDTO consultaCep(String cep) {
        return restTemplate.getForObject(buildUrl(cep), EnderecoDTO.class, cep);
    }

    private String buildUrl(String cep) {
        return UriComponentsBuilder.fromUriString(consultaCepUrl)
                .buildAndExpand(cep)
                .toUriString();
    }
}
