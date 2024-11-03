package com.montrack.demo.repository;

import java.util.List;

public interface PublicRepository<T, ID> {
    List<T> findAll();
    T findById(ID id);
}
