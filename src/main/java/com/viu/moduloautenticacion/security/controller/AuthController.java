package com.viu.moduloautenticacion.security.controller;

import com.viu.moduloautenticacion.Usuario.model.User;
import com.viu.moduloautenticacion.Usuario.service.UserService;
import com.viu.moduloautenticacion.security.TokenProvider;
import com.viu.moduloautenticacion.security.WebSecurityConfig;
import com.viu.moduloautenticacion.security.exception.DuplicatedUserInfoException;
import com.viu.moduloautenticacion.security.model.AuthResponse;
import com.viu.moduloautenticacion.security.model.LoginRequest;
import com.viu.moduloautenticacion.security.model.SignUpRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @PostMapping("/authenticate")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        System.out.println("ingresa a la authenticacion:");
        System.out.println(loginRequest);
        String token = authenticateAndGetToken(loginRequest.getUserName(), loginRequest.getPassword());
        return new AuthResponse(token);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public AuthResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            throw new DuplicatedUserInfoException(String.format("Email %s already been used", signUpRequest.getEmail()));
        }

        userService.saveUsuario(mapSignUpRequestToUser(signUpRequest));
        System.out.println("nuevo usuario creado! " + signUpRequest.getUserName() + " - " + signUpRequest.getPassword());
        String token = authenticateAndGetToken(signUpRequest.getUserName(), signUpRequest.getPassword());
        System.out.println("token devuelto.... " + token);
        return new AuthResponse(token);
    }

    private String authenticateAndGetToken(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return tokenProvider.generate(authentication);
    }

    private User mapSignUpRequestToUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUserName(signUpRequest.getUserName());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setRole(signUpRequest.getRol());
        user.setParking(signUpRequest.getParking());
        return user;
    }
}
