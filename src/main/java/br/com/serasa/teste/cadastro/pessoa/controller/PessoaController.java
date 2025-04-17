package br.com.serasa.teste.cadastro.pessoa.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaDTO;
import br.com.serasa.teste.cadastro.pessoa.service.PessoaService;

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
    public List<PessoaDTO> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/listar-ativos")
    public List<PessoaDTO> listarPessoasAtivas() {
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
