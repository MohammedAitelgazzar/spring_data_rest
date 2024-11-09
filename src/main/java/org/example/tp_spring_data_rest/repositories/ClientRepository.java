package org.example.tp_spring_data_rest.repositories;

import org.example.tp_spring_data_rest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
