package br.com.serasa.teste.cadastro.pessoa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PageResponse;
import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaCompleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serasa.teste.cadastro.pessoa.entity.Pessoa;
import br.com.serasa.teste.cadastro.pessoa.model.pessoa.PessoaDTO;
import br.com.serasa.teste.cadastro.pessoa.repository.PessoaRepository;
import br.com.serasa.teste.cadastro.pessoa.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void cadastraPessoa(PessoaDTO request) {
        pessoaRepository.save(buildPessoa(request));
    }

    @Override
    public PageResponse<PessoaCompleteDTO> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return convertCompleteResponse(pessoas, 2, 10);

    }

    @Override
    public PageResponse<PessoaDTO> listarPessoasAtivas() {
        List<Pessoa> pessoas = pessoaRepository.findAllAtivos();
        return convertResponse(pessoas, 2, 10);

    }

    @Override
    public void excluirPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id));
        pessoa.desativar();
        pessoaRepository.save(pessoa);

    }

    @Override
    public void ativarPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id));

        if (Boolean.TRUE.equals(pessoa.getAtivo())) {
            throw new RuntimeException("Pessoa já está ativa.");
        }

        pessoa.ativar();
        pessoaRepository.save(pessoa);

    }

    private PageResponse<PessoaCompleteDTO> convertCompleteResponse(List<Pessoa> pessoas, int page, int size) {
        int totalElements = pessoas.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);

        List<PessoaCompleteDTO> content = pessoas.stream()
                .skip((long) (page - 1) * size)
                .limit(size)
                .map(pessoa -> {
                    PessoaCompleteDTO pessoaDTO = PessoaCompleteDTO.builder()
                            .id(pessoa.getId())
                            .nome(pessoa.getNome())
                            .idade(pessoa.getIdade())
                            .cep(pessoa.getCep())
                            .estado(pessoa.getEstado())
                            .cidade(pessoa.getCidade())
                            .bairro(pessoa.getBairro())
                            .logradouro(pessoa.getLogradouro())
                            .telefone(pessoa.getTelefone())
                            .score(pessoa.getScore())
                            .ativo(pessoa.getAtivo())
                            .build();
                    pessoaDTO.validarScore();
                    return pessoaDTO;
                })
                .collect(Collectors.toList());

        return new PageResponse<>(content, page, totalPages, totalElements);
    }

    public PageResponse<PessoaDTO> convertResponse(List<Pessoa> pessoas, int page, int size) {
        int totalElements = pessoas.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);

        List<PessoaDTO> content = pessoas.stream()
                .skip((long) (page - 1) * size)
                .limit(size)
                .map(pessoa -> {
                    PessoaDTO pessoaDTO = PessoaDTO.builder()
                            .nome(pessoa.getNome())
                            .idade(pessoa.getIdade())
                            .cep(pessoa.getCep())
                            .estado(pessoa.getEstado())
                            .cidade(pessoa.getCidade())
                            .bairro(pessoa.getBairro())
                            .logradouro(pessoa.getLogradouro())
                            .telefone(pessoa.getTelefone())
                            .score(pessoa.getScore())
                            .build();
                    pessoaDTO.validarScore();
                    return pessoaDTO;
                })
                .collect(Collectors.toList());

        return new PageResponse<>(content, page, totalPages, totalElements);
    }

    private Pessoa buildPessoa(PessoaDTO request) {
        return Pessoa.builder()
                .nome(request.getNome())
                .idade(request.getIdade())
                .cep(request.getCep().replace("-", ""))
                .estado(request.getEstado())
                .cidade(request.getCidade())
                .bairro(request.getBairro())
                .logradouro(request.getLogradouro())
                .telefone(request.getTelefone())
                .score(request.getScore())
                .build();
    }
}
