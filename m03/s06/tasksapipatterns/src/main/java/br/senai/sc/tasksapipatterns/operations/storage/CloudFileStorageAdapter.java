package br.senai.sc.tasksapipatterns.operations.storage;

import br.senai.sc.tasksapipatterns.external.CloudFileStorageLibrary;

public class CloudFileStorageAdapter implements FileStorageAdapterInterface {

    private final CloudFileStorageLibrary cloudFileStorageLibrary;

    public CloudFileStorageAdapter(CloudFileStorageLibrary cloudFileStorageLibrary) {
        this.cloudFileStorageLibrary = cloudFileStorageLibrary;
    }

    @Override
    public void synchronize(String path) {
        this.cloudFileStorageLibrary.saveCloudFile(path);
    }
}
