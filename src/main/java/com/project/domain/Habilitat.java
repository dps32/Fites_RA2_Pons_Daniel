package com.project.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Habilitat")
public class Habilitat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habilitat_id")
    private Long habilitatId;

    @Column(length = 20, nullable = false)
    private String nom;

    @Column(length = 100)
    private String descripcio;

    @Column(nullable = false)
    private Integer costEstamina;

    @ManyToMany(
        mappedBy = "habilitats",
        fetch = FetchType.LAZY
    )
    private Set<Personatge> personatges = new HashSet<>();

    // Constructors
    public Habilitat() {}

    public Habilitat(String nom, String descripcio, Integer costEstamina) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.costEstamina = costEstamina;
    }

    // Getters i Setters
    public Long getHabilitatId() {
        return habilitatId;
    }

    public void setHabilitatId(Long habilitatId) {
        this.habilitatId = habilitatId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Integer getCostEstamina() {
        return costEstamina;
    }

    public void setCostEstamina(Integer costEstamina) {
        this.costEstamina = costEstamina;
    }

    public Set<Personatge> getPersonatges() {
        return personatges;
    }

    public void setPersonatges(Set<Personatge> personatges) {
        this.personatges = personatges;
    }

    @Override
    public String toString() {
        return "Habilitat{id=" + habilitatId + ", nom='" + nom + "', cost=" + costEstamina + "}";
    }
}
