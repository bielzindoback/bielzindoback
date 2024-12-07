package com.example.backcare.controllers.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backcare.models.UserModel;
import com.example.backcare.repositories.user.UserRepository;

@RestController
public class GetDadosUsuario {

    @Autowired
    UserRepository userRepository;

    // Rota para obter dados do usuário
    @GetMapping("/getdadosusuario")
    public ResponseEntity<UserModel> getUserData(@AuthenticationPrincipal Jwt jwt) {
        String email = jwt.getClaimAsString("email"); // Extraindo o email do token JWT
        Optional<UserModel> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
