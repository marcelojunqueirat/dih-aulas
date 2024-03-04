package br.senai.sc.tasksapipatterns.operations.storage;

/* Uso do adapter para fazer com que duas classes incompatíveis
 * trabalhem juntas */

public interface FileStorageAdapterInterface {

    void synchronize(String path);
}
