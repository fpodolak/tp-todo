# TP Java : API Todo - Architecture Hexagonale

Ce projet est une API REST simple pour gérer des tâches (Todo), construite avec Spring Boot, organisée selon l'architecture (Ports & Adapters).

## Fonctionnalités

- [x] Ajout de tâches via `POST /todos`
- [x] Récupération via `GET /todos`
- [x] Validation métier (pas de doublons)
- [x] Sauvegarde en mémoire ou fichier CSV
- [x] Comportement configurable via `config.properties`

## Structure

core/
├── Todo.java
├── ITodoRepository.java
└── TodoManager.java

adapter-inmemory/
└── TodoInMemoryRepository.java

adapter-csvfiles/
└── TodoCsvFilesRepository.java

web/
├── Config.java
├── TodoController.java
└── TodoApplication.java


## Choix dynamique du repository

Dans `src/main/resources/config.properties`, changez :

```properties
repository=CSV

OU

repository=INMEMORY

Lancement : ./mvnw spring-boot:run

Fait par Florian Podolak et Arthur Pedron
