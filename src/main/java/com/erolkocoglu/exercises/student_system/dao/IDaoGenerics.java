package com.erolkocoglu.exercises.student_system.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface IDaoGenerics<T> {

    // CRUD
    // CREATE
    Optional<T> create(T t);

    // LIST List için Optional kullanmana gerek yoktur.
    List<T> list();

    // FIND BY NAME
    Optional<T> findByName(String name);

    // FIND BY ID
    Optional<T> findById(int id);

    // UPDATE
    Optional<T> update(int id, T t);

    // DELETE
    Optional<T> delete(int id);

    // CHOOISE
    void chooise();

    // DATABASE CONNECTION
    default Connection getInterfaceConnection() {
        return null;
    }
}