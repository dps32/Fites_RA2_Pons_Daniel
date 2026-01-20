package com.project.dao;

import com.project.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Manager - Gestiona les operacions amb la base de dades
 */
public class Manager {

    private static SessionFactory factory;

    /**
     * Crea la SessionFactory (una sola vegada per aplicació)
     */
    public static void createSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            
            // Carreguem hibernate.properties
            try (InputStream input = Manager.class.getClassLoader()
                    .getResourceAsStream("hibernate.properties")) {
                if (input == null) {
                    throw new IOException("No s'ha trobat hibernate.properties");
                }
                properties.load(input);
                configuration.addProperties(properties);
            }
            
            // Registrem les entitats
            configuration.addAnnotatedClass(Faccio.class);
            configuration.addAnnotatedClass(Personatge.class);
            configuration.addAnnotatedClass(Habilitat.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);
            
            System.out.println("[OK] SessionFactory creada correctament");
        } catch (Throwable ex) {
            System.err.println("Error inicialitzant Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Tanca la SessionFactory
     */
    public static void close() {
        if (factory != null) {
            factory.close();
            System.out.println("[OK] SessionFactory tancada");
        }
    }

    // =================================================================
    // OPERACIONS AMB FACCIONS
    // =================================================================

    /**
     * Crea una nova facció
     */
    public static Faccio addFaccio(String nom, String resum) {
        Session session = null;
        Transaction tx = null;
        Faccio faccio = null;
        
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            
            faccio = new Faccio(nom, resum);
            session.persist(faccio);
            
            tx.commit();
            System.out.println("[OK] Facció creada: " + nom);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error creant facció: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        
        return faccio;
    }

    // =================================================================
    // OPERACIONS AMB HABILITATS
    // =================================================================

    /**
     * Crea una nova habilitat
     */
    public static Habilitat addHabilitat(String nom, String descripcio, Integer cost) {
        Session session = null;
        Transaction tx = null;
        Habilitat habilitat = null;
       
        // -----
        // TO DO
        // -----

        return habilitat;
    }

    // =================================================================
    // OPERACIONS AMB PERSONATGES
    // =================================================================

    /*
    Exemples d'ús en el main (Es poden passar 0 o vàries habilitats)

    // Amb 0 habilitats
    Manager.addPersonatge("Warden", 2.5, 3.0, cavallers);

    // Amb 1 habilitat
    Manager.addPersonatge("Warden", 2.5, 3.0, cavallers, guardBreak);

    // Amb 2 habilitats
    Manager.addPersonatge("Warden", 2.5, 3.0, cavallers, guardBreak, shoulderBash);

    // Amb 3 o més habilitats
    Manager.addPersonatge("Warden", 2.5, 3.0, cavallers, guardBreak, shoulderBash, parry);    
    */

    /**
     * Crea un nou personatge amb facció i habilitats
     */
    public static Personatge addPersonatge(String nom, Double atac, Double defensa, 
                                          Faccio faccio, Habilitat... habilitats) {
        Session session = null;
        Transaction tx = null;
        Personatge personatge = null;
        // -----
        // TO DO
        // -----
        return personatge;
    }


    // =================================================================
    // OPERACIONS PER IMPRIMIR PER PANTALLA
    // =================================================================

    /**
     * Mostra totes les habilitats
     */
    public static void printHabilitats() {
        Session session = null;
        
        try {
            session = factory.openSession();
            var habilitats = session.createQuery("FROM Habilitat", Habilitat.class).list();
            
            System.out.println("\nHABILITATS:");
            for (Habilitat h : habilitats) {
                System.out.println("  - " + h.getNom() + ": " + h.getDescripcio() + 
                                 " (Cost: " + h.getCostEstamina() + ")");
            }
        } catch (Exception e) {
            System.err.println("Error llegint habilitats: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     * Mostra totes les faccions
     */
    public static void printFaccions() {
        Session session = null;
        
        try {
            session = factory.openSession();
            var faccions = session.createQuery("FROM Faccio", Faccio.class).list();
            
            System.out.println("\nFACCIONS:");
            for (Faccio f : faccions) {
                System.out.println("  - " + f.getNom() + ": " + f.getResum());
            }
        } catch (Exception e) {
            System.err.println("Error llegint faccions: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     * Mostra tots els personatges
     */
    public static void printPersonatges() {
        // -----
        // TO DO
        // -----
    }
}