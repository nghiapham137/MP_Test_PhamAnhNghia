package com.quanlyvattu.service.VatTuService;

import com.quanlyvattu.model.VatTu;
import com.quanlyvattu.repository.VatTuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VatTuServiceImpl implements IVatTuService {

    @Autowired
    VatTuRepository vatTuRepository;

    @Override
    public Iterable<VatTu> getAll() {
        return vatTuRepository.findAll();
    }

    @Override
    public Optional<VatTu> getById(String id) {
        return vatTuRepository.findById(id);
    }

    @Override
    public VatTu save(VatTu vatTu) {
        vatTuRepository.save(vatTu);
        return vatTu;
    }

    @Override
    public void deleteById(String id) {
        vatTuRepository.deleteById(id);
    }
}
