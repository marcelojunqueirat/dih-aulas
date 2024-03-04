package br.senai.sc.tasksapipatterns.operations.storage;

import br.senai.sc.tasksapipatterns.external.LocalFileStorageLibrary;

public class LocalFileStorageAdapter implements FileStorageAdapterInterface {

    private final LocalFileStorageLibrary localFileStorageLibrary;

    public LocalFileStorageAdapter(LocalFileStorageLibrary localFileStorageLibrary) {
        this.localFileStorageLibrary = localFileStorageLibrary;
    }

    @Override
    public void synchronize(String path) {
        this.localFileStorageLibrary.saveLocalFile(path);
    }
}
