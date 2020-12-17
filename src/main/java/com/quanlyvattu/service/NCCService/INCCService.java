package com.quanlyvattu.service.NCCService;

import com.quanlyvattu.model.NCC;

import java.util.Optional;

public interface INCCService {
    Iterable<NCC> getAll();
    Optional<NCC> getById(Integer id);
    NCC save(NCC ncc);
    void deleteById(Integer id);
}
