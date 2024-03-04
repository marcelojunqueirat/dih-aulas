package br.senai.sc.tasksapipatterns.external;

/* Considerar como se estivéssemos consumindo essa classe de uma biblioteca externa. */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalFileStorageLibrary {

    public static final Logger LOGGER = LoggerFactory.getLogger(LocalFileStorageLibrary.class);

    public void saveLocalFile(String path) {
        LOGGER.info("Saving file locally to path: {}", path);
    }
}
