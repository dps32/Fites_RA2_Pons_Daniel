# Fites Tema 2: Hibernate - For Honor

## Context

L'aplicació ha de gestionar dades del joc For Honor utilitzant Hibernate. El codi base està parcialment implementat però falten elements essencials per al seu correcte funcionament.


## Model de Domini

L'aplicació gestiona tres entitats:

- **Faccio**: Grups de guerrers (Cavallers, Samurais, Vikings...)
- **Personatge**: Lluitadors individuals amb atributs d'atac i defensa
- **Habilitat**: Moviments especials que consumeixen estamina


### Relacions del Model

```
┌─────────────────────┐
│      Faccio         │
│─────────────────────│
│ - faccioId (PK)     │
│ - nom               │
│ - resum             │
└─────────────────────┘
          │ 1
          │
          │ N
          ▼
┌─────────────────────┐           ┌─────────────────────┐
│    Personatge       │           │     Habilitat       │
│─────────────────────│           │─────────────────────│
│ - personatgeId (PK) │           │ - habilitatId (PK)  │
│ - nom               │    N:M    │ - nom               │
│ - atac              │◄─────────►│ - descripcio        │
│ - defensa           │           │ - costEstamina      │
│ - idFaccio (FK)     │           └─────────────────────┘
└─────────────────────┘
```

- Una facció pot tenir múltiples personatges, però cada personatge només pertany a una facció
- Els personatges poden aprendre diverses habilitats
- Una mateixa habilitat pot ser apresa per diferents personatges


## Tasca

Completa el codi de les classes del paquet `domain` i del `Manager` per aconseguir la sortida esperada.
Cerca els "// TO DO" en el codi

**Fitxers a modificar:**
- `src/main/java/com/project/domain/Faccio.java`
- `src/main/java/com/project/domain/Personatge.java`
- `src/main/java/com/project/domain/Habilitat.java`
- `src/main/java/com/project/dao/Manager.java`
- `src/main/java/com/project/Main.java` (descomentar codi per anar avançant)

**Important:** Fixa't en el patró establert als mètodes ja implementats (`addFaccio` i `printFaccions`).


## Execució

```bash
mvn clean compile
mvn exec:java "-Dexec.mainClass=com.project.Main"
```


## Sortida Esperada

```
[OK] SessionFactory creada correctament

--- 1. CREANT FACCIONS ---
[OK] Facció creada: Cavallers
[OK] Facció creada: Samurais

--- 2. CREANT HABILITATS ---
[OK] Habilitat creada: Guard Break (cost: 20)
[OK] Habilitat creada: Shoulder Bash (cost: 25)

--- 3. CREANT PERSONATGES ---
[OK] Personatge creat: Warden (Cavallers)
[OK] Personatge creat: Kensei (Samurais)


-------------------------------------
       RESULTATS
-------------------------------------

FACCIONS:
  - Cavallers: Guerrers honrats amb armadures pesades
  - Samurais: Guerrers orientals amb espases katana

HABILITATS:
  - Guard Break: Trenca la guardia de l'enemic (Cost: 20)
  - Shoulder Bash: Cop amb l'espatlla (Cost: 25)

PERSONATGES:

  Warden (Cavallers)
    Atac: 2.5 | Defensa: 3.0
    Habilitats: Guard Break Shoulder Bash

  Kensei (Samurais)
    Atac: 3.0 | Defensa: 2.5
    Habilitats: Guard Break

-------------------------------------
[OK] SessionFactory tancada
-------------------------------------
```

## Repositoris de referència
- https://github.com/jpala4-ieti/DAM-JavaHibernateJPAOneToMany
- https://github.com/jpala4-ieti/DAM-JavaHibernateJPAManyToMany
- https://github.com/jpala4-ieti/DAM-M0486-Tema2-PR22-Practica-Resolta-JPA-25-26
- https://github.com/jpala4-ieti/DAM-M0486-Tema2-PR23-Practica-Resolta-25-26 
 


## Criteris d'Avaluació
- Correcta definició de les anotacions JPA a les entitats (30%)
- Implementació funcional dels mètodes del Manager (50%)
- L'aplicació genera la sortida esperada (20%)

**Temps estimat:** 60-90 minuts

## Entrega
URL del repositori de Github public o privat compartit amb jpala4-ieti
