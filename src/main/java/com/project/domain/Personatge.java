package com.project.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Personatge")
public class Personatge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personatgeId;

    @Column(length = 15, nullable = false)
    private String nom;

    @Column(nullable = false)
    private Double atac;

    @Column(nullable = false)
    private Double defensa;

    // TO DO
    private Faccio faccio;

    // TO DO
    private Set<Habilitat> habilitats = new HashSet<>();

    // Constructors
    public Personatge() {}

    public Personatge(String nom, Double atac, Double defensa, Faccio faccio) {
        this.nom = nom;
        this.atac = atac;
        this.defensa = defensa;
        this.faccio = faccio;
    }

    // Getters i Setters
    public Long getPersonatgeId() {
        return personatgeId;
    }

    public void setPersonatgeId(Long personatgeId) {
        this.personatgeId = personatgeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getAtac() {
        return atac;
    }

    public void setAtac(Double atac) {
        this.atac = atac;
    }

    public Double getDefensa() {
        return defensa;
    }

    public void setDefensa(Double defensa) {
        this.defensa = defensa;
    }

    public Faccio getFaccio() {
        return faccio;
    }

    public void setFaccio(Faccio faccio) {
        this.faccio = faccio;
    }

    public Set<Habilitat> getHabilitats() {
        return habilitats;
    }

    public void setHabilitats(Set<Habilitat> habilitats) {
        this.habilitats = habilitats;
    }

    // Mètode helper per afegir habilitat (manté sincronitzada la relació)
    public void addHabilitat(Habilitat habilitat) {
        this.habilitats.add(habilitat);
        habilitat.getPersonatges().add(this);
    }

    @Override
    public String toString() {
        String faccioNom = (faccio != null) ? faccio.getNom() : "Sense facció";
        return "Personatge{id=" + personatgeId + ", nom='" + nom + 
               "', atac=" + atac + ", defensa=" + defensa + 
               ", facció='" + faccioNom + "'}";
    }
}