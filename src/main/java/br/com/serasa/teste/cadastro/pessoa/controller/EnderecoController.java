package br.com.serasa.teste.cadastro.pessoa.controller;

import br.com.serasa.teste.cadastro.pessoa.model.endereco.CepRequestDTO;
import br.com.serasa.teste.cadastro.pessoa.model.endereco.DadosCepDTO;
import br.com.serasa.teste.cadastro.pessoa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/busca-cep")
    public DadosCepDTO buscaCep(@RequestBody CepRequestDTO request) {
        return enderecoService.buscaCep(request.cep());
    }
}
