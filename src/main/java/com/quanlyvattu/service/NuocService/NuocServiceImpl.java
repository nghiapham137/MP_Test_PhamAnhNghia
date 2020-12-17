package com.quanlyvattu.service.NuocService;

import com.quanlyvattu.model.Nuoc;
import com.quanlyvattu.repository.NuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NuocServiceImpl implements INuocService {
    @Autowired
    NuocRepository nuocRepository;

    @Override
    public Iterable<Nuoc> getAll() {
        return nuocRepository.findAll();
    }

    @Override
    public Optional<Nuoc> getById(Integer id) {
        return nuocRepository.findById(id);
    }

    @Override
    public Nuoc save(Nuoc nuoc) {
        nuocRepository.save(nuoc);
        return nuoc;
    }

    @Override
    public void deleteById(Integer id) {
        nuocRepository.deleteById(id);
    }
}
