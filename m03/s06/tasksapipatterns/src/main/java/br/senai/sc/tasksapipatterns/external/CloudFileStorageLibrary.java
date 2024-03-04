package br.senai.sc.tasksapipatterns.external;

/* Considerar como se estivéssemos consumindo essa classe de uma biblioteca externa. */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudFileStorageLibrary {

    public static final Logger LOGGER = LoggerFactory.getLogger(CloudFileStorageLibrary.class);

    public void saveCloudFile(String path) {
        LOGGER.info("Saving file to the cloud in the path: {}", path);
    }
}
