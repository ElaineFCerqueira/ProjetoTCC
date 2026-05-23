package com.example.api_db.controller;


import com.example.api_db.dto.ClienteRequestDTO;
import com.example.api_db.dto.ClienteResponseDto;
import com.example.api_db.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> Listar(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarTodos());
        }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody ClienteRequestDTO dto){
        service.salvarCliente(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Cliente cadastrado com sucesso"));
    }
}
