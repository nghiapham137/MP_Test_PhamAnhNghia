package com.quanlyvattu.service.NCCService;

import com.quanlyvattu.model.NCC;
import com.quanlyvattu.repository.NCCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NCCServiceImpl implements INCCService {
    @Autowired
    NCCRepository nccRepository;

    @Override
    public Iterable<NCC> getAll() {
        return nccRepository.findAll();
    }

    @Override
    public Optional<NCC> getById(Integer id) {
        return nccRepository.findById(id);
    }

    @Override
    public NCC save(NCC ncc) {
        nccRepository.save(ncc);
        return ncc;
    }

    @Override
    public void deleteById(Integer id) {
        nccRepository.deleteById(id);
    }
}
