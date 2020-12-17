package com.quanlyvattu.controller;

import com.quanlyvattu.model.NCC;
import com.quanlyvattu.service.NCCService.INCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/NCC")
public class NCCController {
    @Autowired
    INCCService inccService;

    @GetMapping
    public ResponseEntity<Iterable<NCC>> getAllNCC() {
        return new ResponseEntity<>(inccService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NCC> addNCC(@RequestBody NCC ncc) {
        Iterable<NCC> listNCC = inccService.getAll();
        for (NCC n : listNCC ) {
            if (n.getTenNCC().trim().equals(ncc.getTenNCC().trim())) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        inccService.save(ncc);
        return new ResponseEntity<>(ncc, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NCC> editNCC(@PathVariable("maNCC") Integer maNCC, @RequestBody NCC ncc) {
        Optional<NCC> currentNCC = inccService.getById(maNCC);
        if (!currentNCC.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentNCC.get().setTenNCC(ncc.getTenNCC());
        inccService.save(currentNCC.get());
        return new ResponseEntity<>(currentNCC.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NCC> deleteNCC(@PathVariable("maNCC") Integer maNCC) {
        inccService.deleteById(maNCC);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
