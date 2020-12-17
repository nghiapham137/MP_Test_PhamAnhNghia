package com.quanlyvattu.controller;

import com.quanlyvattu.model.VatTu;
import com.quanlyvattu.service.NCCService.INCCService;
import com.quanlyvattu.service.NuocService.INuocService;
import com.quanlyvattu.service.VatTuService.IVatTuService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")
@Component
public class VatTuController {
    @Autowired
    IVatTuService vatTuService;

    @Autowired
    INCCService nccService;

    @Autowired
    INuocService nuocService;

    @GetMapping
    public ResponseEntity<Iterable<VatTu>> getAllVatTu() {
        Iterable<VatTu> listVatTu = vatTuService.getAll();
        return new ResponseEntity<Iterable<VatTu>>(listVatTu, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VatTu> addNewVatTu(@RequestBody VatTu vatTu) {
        Iterable<VatTu> listVatTu = vatTuService.getAll();
        for (VatTu v : listVatTu) {
            if (v.getTenVT().trim().equals(vatTu.getTenVT().trim())) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        vatTuService.save(vatTu);

        return new ResponseEntity<>(vatTu, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VatTu> editVatTu(@PathVariable("maVatTu") String maVatTu, @RequestBody VatTu vatTu) {
        Optional<VatTu> currentVatTu = vatTuService.getById(maVatTu);
        if (!currentVatTu.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentVatTu.get().setMaKKS(vatTu.getMaKKS());
        currentVatTu.get().setDVTinh(vatTu.getDVTinh());
        currentVatTu.get().getNcc().setMaNCC(vatTu.getNcc().getMaNCC());
        currentVatTu.get().getNuoc().setMaNuoc(vatTu.getNuoc().getMaNuoc());
        vatTuService.save(currentVatTu.get());
        return new ResponseEntity<>(currentVatTu.get(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VatTu> deleteVatTu(@PathVariable("maVatTu") String maVatTu) {
        vatTuService.deleteById(maVatTu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
