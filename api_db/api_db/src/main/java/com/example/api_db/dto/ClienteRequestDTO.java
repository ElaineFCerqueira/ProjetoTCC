package com.example.api_db.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres")
    private String nome;

    @Email(message = "Deve ser um email válido")
    private String email;

    @NotNull(message = "O telefome é obrigatóroio")
    private String telefone;

    public ClienteRequestDTO(){

    }

    public ClienteRequestDTO(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "O nome não pode ser vazio") @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome não pode ser vazio") @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres") String nome) {
        this.nome = nome;
    }

    public @Email(message = "Deve ser um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Deve ser um email válido") String email) {
        this.email = email;
    }

    public @NotNull(message = "O telefome é obrigatóroio") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull(message = "O telefome é obrigatóroio") String telefone) {
        this.telefone = telefone;
    }
}

