package br.edu.ufabc.icarius.security;

import br.edu.ufabc.icarius.model.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by fcosta on 16/07/16.
 */
@Component
public class IcariusAuthProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository users;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = (String) auth.getPrincipal();
        String password = (String) auth.getCredentials();

        Long usersAuthentic = users.countByUsernameAndPassword(username, password);

        if (usersAuthentic == 1) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ADMIN");
            Collection<? extends GrantedAuthority> authorities = Collections.singleton(simpleGrantedAuthority);
            return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), authorities);
        } else {
            throw new BadCredentialsException("Usuário ou senha inválido(s)");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
