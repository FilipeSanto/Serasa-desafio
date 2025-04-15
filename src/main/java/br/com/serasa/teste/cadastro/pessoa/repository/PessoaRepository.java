package br.com.serasa.teste.cadastro.pessoa.repository;

import br.com.serasa.teste.cadastro.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}