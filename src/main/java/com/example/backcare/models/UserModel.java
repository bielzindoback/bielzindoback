package com.example.backcare.models;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.backcare.controllers.dto.LoginRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "usuarios")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String birthdate;

    @NotNull
    @Positive
    private float altura;

    @NotNull
    @Positive
    private float peso;

    @NotNull
    @Enumerated(EnumType.STRING) // Armazena o valor do enum como String
    @Column(nullable = false)
    private Sexo sexo; // Usando o enum Sexo

    @NotNull
    @Positive
    private int idade;

    @NotNull
    @Positive
    private float naf;

    public UserModel() {
    }

    public UserModel(String name, String password, String email, String birthdate, float altura, float peso, Sexo sexo, int idade, float naf) {
        this.name = name; 
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.idade = idade;
        this.naf = naf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getNaf() {
        return naf;
    }

    public void setNaf(float naf) {
        this.naf = naf;
    }

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }
}
