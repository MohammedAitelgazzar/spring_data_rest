package org.example.tp_spring_data_rest;

import org.example.tp_spring_data_rest.entities.Client;
import org.example.tp_spring_data_rest.entities.Compte;
import org.example.tp_spring_data_rest.entities.TypeCompte;
import org.example.tp_spring_data_rest.repositories.ClientRepository;
import org.example.tp_spring_data_rest.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class TpSpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpSpringDataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            ClientRepository clientRepository,
                            RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);


            // Creating and saving clients
            Client c1 = clientRepository.save(new Client(null, "Simo", "simo@example.com", null));
            Client c2 = clientRepository.save(new Client(null, "Brahim", "brahim@example.com", null));

            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE,c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT,c2));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE,c1));
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
