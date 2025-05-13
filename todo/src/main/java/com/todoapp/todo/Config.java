package com.todoapp.todo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static String getRepositoryType() {
        Properties props = new Properties();

        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Fichier config.properties introuvable dans /resources");
            }
            props.load(input);
            return props.getProperty("repository", "INMEMORY").toUpperCase(); // défaut = INMEMORY
        } catch (IOException e) {
            throw new RuntimeException("Erreur de lecture du fichier de configuration", e);
        }
    }
}
