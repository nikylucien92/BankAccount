package com.serviceImpl;

import com.authentication.JwtService;
import com.dto.AuthenticationResponse;
import com.dto.LoginRequest;
import com.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.entity.Cliente;
import com.repository.RepositoryCliente;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RepositoryCliente clienteRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(
            RegisterRequest request) {

        Cliente cliente = new Cliente();
        cliente.setCognome(request.getCognome());

        cliente.setEmail(request.getEmail());

        cliente.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        cliente.setRuolo("ROLE_USER");

        clienteRepository.save(cliente);

        String jwtToken =
                jwtService.generateToken(cliente);

        return new AuthenticationResponse(jwtToken);

    }

    //metodo autenticazione
    public AuthenticationResponse authenticate(
            LoginRequest request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getEmail(),

                        request.getPassword()
                )
        );

        Cliente cliente =
                clienteRepository
                        .findByEmail(
                                request.getEmail())
                        .orElseThrow();

        String jwtToken =
                jwtService.generateToken(cliente);

        return new AuthenticationResponse(jwtToken);
    }

}
