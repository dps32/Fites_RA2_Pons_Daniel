package com.project.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Faccio")
public class Faccio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faccioId;

    @Column(length = 15, nullable = false)
    private String nom;

    @Column(length = 500)
    private String resum;

    // TO DO
    private Set<Personatge> personatges = new HashSet<>();

    // Constructors
    public Faccio() {}

    public Faccio(String nom, String resum) {
        this.nom = nom;
        this.resum = resum;
    }

    // Getters i Setters
    public Long getFaccioId() {
        return faccioId;
    }

    public void setFaccioId(Long faccioId) {
        this.faccioId = faccioId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResum() {
        return resum;
    }

    public void setResum(String resum) {
        this.resum = resum;
    }

    public Set<Personatge> getPersonatges() {
        return personatges;
    }

    public void setPersonatges(Set<Personatge> personatges) {
        this.personatges = personatges;
    }

    // Mètode helper per afegir personatge (manté sincronitzada la relació bidireccional)
    public void addPersonatge(Personatge personatge) {
        personatges.add(personatge);
        personatge.setFaccio(this);
    }

    @Override
    public String toString() {
        return "Faccio{id=" + faccioId + ", nom='" + nom + "'}";
    }
}