package br.com.serasa.teste.cadastro.pessoa.service;

import java.util.List;

import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaDTO;

public interface PessoaService {

    void cadastraPessoa(PessoaDTO request);

    List<PessoaDTO> listarPessoas();

    List<PessoaDTO> listarPessoasAtivas();

    void excluirPessoa(Long id);

    void ativarPessoa(Long id);
}
