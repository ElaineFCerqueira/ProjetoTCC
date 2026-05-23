package com.example.api_db.service;

import com.example.api_db.dto.ClienteRequestDTO;
import com.example.api_db.dto.ClienteResponseDto;
import com.example.api_db.model.ClienteModel;
import com.example.api_db.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // Listar todos os clientes convertendo para DTO
    public List<ClienteResponseDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(c -> new ClienteResponseDto(c.getNome(), c.getEmail()))
                .toList();
    }

    // Cadastrar um novo Cliente

    public ClienteModel salvarCliente(ClienteRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado com este e-mail.");
        }


        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());


        return repository.save(novoCliente);
    }
}
