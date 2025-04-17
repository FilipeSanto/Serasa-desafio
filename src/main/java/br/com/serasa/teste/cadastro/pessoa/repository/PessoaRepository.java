package br.com.serasa.teste.cadastro.pessoa.repository;

import br.com.serasa.teste.cadastro.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("Select p from Pessoa p where p.ativo = true")
    List<Pessoa> findAllAtivos();
}