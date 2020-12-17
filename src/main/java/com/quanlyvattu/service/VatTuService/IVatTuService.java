package com.quanlyvattu.service.VatTuService;

import com.quanlyvattu.model.VatTu;

import java.util.Optional;

public interface IVatTuService {
    Iterable<VatTu> getAll();
    Optional<VatTu> getById(String id);
    VatTu save(VatTu vatTu);
    void deleteById(String id);
}
