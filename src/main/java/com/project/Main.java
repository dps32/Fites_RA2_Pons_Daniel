package com.project;

import com.project.dao.Manager;
import com.project.domain.*;

/**
 * Exercici Simple: For Honor - Hibernate
 * 
 * Objectius:
 * - Crear 2 faccions
 * - Crear 2 personatges
 * - Crear 2 habilitats
 * - Assignar facció a personatge
 * - Assignar habilitat a personatge
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("   EXERCICI FOR HONOR - HIBERNATE");
        System.out.println("-------------------------------------\n");

        // Inicialitzar Hibernate
        Manager.createSessionFactory();

        // =================================================================
        // 1. CREAR FACCIONS
        // =================================================================
        System.out.println("\n--- 1. CREANT FACCIONS ---");
        
        Faccio cavallers = Manager.addFaccio(
            "Cavallers", 
            "Guerrers honrats amb armadures pesades"
        );
        
        Faccio samurais = Manager.addFaccio(
            "Samurais", 
            "Guerrers orientals amb espases katana"
        );

        
        // =================================================================
        // 2. CREAR HABILITATS
        // =================================================================
        System.out.println("\n--- 2. CREANT HABILITATS ---");
        
        Habilitat guardBreak = Manager.addHabilitat(
            "Guard Break", 
            "Trenca la guardia de l'enemic", 
            20
        );
        
        Habilitat shoulderBash = Manager.addHabilitat(
            "Shoulder Bash", 
            "Cop amb l'espatlla", 
            25
        );

        // =================================================================
        // 3. CREAR PERSONATGES (amb facció i habilitats)
        // =================================================================
        System.out.println("\n--- 3. CREANT PERSONATGES ---");
        
        // Warden: Cavaller amb Guard Break i Shoulder Bash
        Manager.addPersonatge(
            "Warden", 
            2.5,        // atac
            3.0,        // defensa
            cavallers,  // facció
            guardBreak, shoulderBash  // habilitats
        );
        
        // Kensei: Samurai amb Guard Break
        Manager.addPersonatge(
            "Kensei", 
            3.0,        // atac
            2.5,        // defensa
            samurais,   // facció
            guardBreak  // habilitats
        );
        
       
        // =================================================================
        // 4. MOSTRAR RESULTATS
        // =================================================================
        System.out.println("\n\n-------------------------------------");
        System.out.println("       RESULTATS");
        System.out.println("-------------------------------------");
        
        Manager.printFaccions();
        Manager.printHabilitats();
        Manager.printPersonatges();

        // =================================================================
        // TANCAR
        // =================================================================
        System.out.println("\n-------------------------------------");
        Manager.close();
        System.out.println("-------------------------------------\n");
    }
}