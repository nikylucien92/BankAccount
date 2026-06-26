package com.serviceImpl;

import com.repository.RepositoryCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomClienteDetailsService implements UserDetailsService {

    private final RepositoryCliente repoCliente;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return repoCliente.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Cliente non trovato"));
    }
}
