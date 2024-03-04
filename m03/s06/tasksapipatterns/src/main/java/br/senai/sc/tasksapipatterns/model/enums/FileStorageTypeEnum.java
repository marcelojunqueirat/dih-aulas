package br.senai.sc.tasksapipatterns.model.enums;

import br.senai.sc.tasksapipatterns.external.CloudFileStorageLibrary;
import br.senai.sc.tasksapipatterns.external.LocalFileStorageLibrary;
import br.senai.sc.tasksapipatterns.operations.storage.CloudFileStorageAdapter;
import br.senai.sc.tasksapipatterns.operations.storage.FileStorageAdapterInterface;
import br.senai.sc.tasksapipatterns.operations.storage.LocalFileStorageAdapter;

public enum FileStorageTypeEnum {
    LOCAL {
        @Override
        public FileStorageAdapterInterface getFileStorageAdapter() {
            return new LocalFileStorageAdapter(new LocalFileStorageLibrary());
        }
    },
    CLOUD {
        @Override
        public FileStorageAdapterInterface getFileStorageAdapter() {
            return new CloudFileStorageAdapter(new CloudFileStorageLibrary());
        }
    };

    public abstract FileStorageAdapterInterface getFileStorageAdapter();
}
