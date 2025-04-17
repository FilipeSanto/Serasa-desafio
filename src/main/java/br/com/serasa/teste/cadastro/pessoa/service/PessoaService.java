package br.com.serasa.teste.cadastro.pessoa.service;

import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PageResponse;
import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaCompleteDTO;
import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaDTO;

public interface PessoaService {

    void cadastraPessoa(PessoaDTO request);

    PageResponse<PessoaCompleteDTO> listarPessoas();

    PageResponse<PessoaDTO> listarPessoasAtivas();

    void excluirPessoa(Long id);

    void ativarPessoa(Long id);
}
