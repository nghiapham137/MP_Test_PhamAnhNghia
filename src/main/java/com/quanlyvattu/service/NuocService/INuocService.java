package com.quanlyvattu.service.NuocService;

import com.quanlyvattu.model.Nuoc;

import java.util.Optional;

public interface INuocService {
    Iterable<Nuoc> getAll();
    Optional<Nuoc> getById(Integer id);
    Nuoc save(Nuoc nuoc);
    void deleteById(Integer id);
}
