package br.com.serasa.teste.cadastro.pessoa.controller;

import br.com.serasa.teste.cadastro.pessoa.model.CepRequestDTO;
import br.com.serasa.teste.cadastro.pessoa.model.DadosCepDTO;
import br.com.serasa.teste.cadastro.pessoa.model.PessoaDTO;
import br.com.serasa.teste.cadastro.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public void cadastraPessoa(@RequestBody PessoaDTO request) {
        pessoaService.cadastraPessoa(request);
    }

    @PostMapping("/busca-cep")
    public DadosCepDTO buscaCep(@RequestBody CepRequestDTO request) {
        return pessoaService.buscaCep(request.cep());
    }
}
