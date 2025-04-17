package br.com.serasa.teste.cadastro.pessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PageResponse;
import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaCompleteDTO;
import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaDTO;
import br.com.serasa.teste.cadastro.pessoa.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @Operation(summary = "Lista todas as pessoas", description = "Retorna todas as pessoas cadastradas no sistema.")
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastraPessoa(@RequestBody PessoaDTO request) {
        pessoaService.cadastraPessoa(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa cadastrada com sucesso");
    }

    @GetMapping("/listar")
    public PageResponse<PessoaCompleteDTO> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/listar-ativos")
    public PageResponse<PessoaDTO> listarPessoasAtivas() {
        return pessoaService.listarPessoasAtivas();
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<Void> ativarPessoa(@PathVariable Long id) {
        pessoaService.ativarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
