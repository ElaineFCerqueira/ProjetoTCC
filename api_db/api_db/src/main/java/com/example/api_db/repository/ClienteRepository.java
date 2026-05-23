package com.example.api_db.repository;

import com.example.api_db.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel,Long> {
    Optional<ClienteModel> findByEmail(String email);
}
