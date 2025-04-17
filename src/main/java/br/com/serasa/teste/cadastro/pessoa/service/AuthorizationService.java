package br.com.serasa.teste.cadastro.pessoa.service;

import br.com.serasa.teste.cadastro.pessoa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public String validaRoleAndGenerateRedirect(String token, UsernamePasswordAuthenticationToken usernamePassword) {
        if (usernamePassword.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
           return "/admin-dashboard.html";
        } else if (usernamePassword.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "/user-dashboard.html";
        } else {
            return "/login.html";
        }

    }
}
