package com.authentication;

import com.serviceImpl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationResponse register(
            @RequestBody RegisterRequest request) {

        return authenticationService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(
            @RequestBody LoginRequest request) {

        return authenticationService.authenticate(request);
    }

}
