package org.example.tp_spring_data_rest.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde",types = Compte.class)
public interface CompteProjection1 {
    public double getSolde();
}

