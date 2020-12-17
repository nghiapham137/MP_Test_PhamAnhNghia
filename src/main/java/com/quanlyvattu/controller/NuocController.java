package com.quanlyvattu.controller;

import com.quanlyvattu.model.Nuoc;
import com.quanlyvattu.service.NuocService.INuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/nuoc")
public class NuocController {
    @Autowired
    INuocService nuocService;

    @GetMapping
    public ResponseEntity<Iterable<Nuoc>> getAllNuoc() {
        return new ResponseEntity<>(nuocService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Nuoc> addNuoc(@RequestBody Nuoc nuoc) {
        Iterable<Nuoc> listNuoc = nuocService.getAll();
        for (Nuoc n : listNuoc ) {
            if (n.getTenNuoc().trim().equals(nuoc.getTenNuoc().trim())) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        nuocService.save(nuoc);
        return new ResponseEntity<>(nuoc, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nuoc> editNuoc(@PathVariable("maNuoc") Integer maNuoc, @RequestBody Nuoc nuoc) {
        Optional<Nuoc> currentNuoc = nuocService.getById(maNuoc);
        if (!currentNuoc.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentNuoc.get().setTenNuoc(nuoc.getTenNuoc());
        nuocService.save(currentNuoc.get());
        return new ResponseEntity<>(currentNuoc.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Nuoc> deleteNuoc(@PathVariable("maNuoc") Integer maNuoc) {
        nuocService.deleteById(maNuoc);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
