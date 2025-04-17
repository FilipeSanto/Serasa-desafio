package br.com.serasa.teste.cadastro.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.serasa.teste.cadastro.pessoa.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}