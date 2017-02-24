package com.javarush.task.task36.task3608.model;

/**
 * Created by esavitski on 24.02.2017.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
}
