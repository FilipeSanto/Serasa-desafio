package br.com.serasa.teste.cadastro.pessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.serasa.teste.cadastro.pessoa.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("Select p from Pessoa p where p.ativo = true")
    List<Pessoa> findAllAtivos();
}