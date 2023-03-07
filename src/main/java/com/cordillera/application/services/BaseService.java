package com.cordillera.application.services;

import java.util.List;

public interface BaseService <D, P>{
    D save(P p);
    void delete(Long id);
    List<D> findAll();
    D findById(Long id);

    D update(D d);


}
