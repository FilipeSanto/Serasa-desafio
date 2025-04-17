package br.com.serasa.teste.cadastro.pessoa.model.user;

public record RegisterDTO(String login, String password, UserRole role) {
}