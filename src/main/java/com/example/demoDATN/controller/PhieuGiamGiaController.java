package com.example.demoDATN.controller;

import com.example.demoDATN.entity.PhieuGiamGia;
import com.example.demoDATN.service.PhieuGiamGiaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weblaptop/phieuGiamGia")
public class PhieuGiamGiaController {
    @Autowired
    public PhieuGiamGiaService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PhieuGiamGia>> getAllWithPagination(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PhieuGiamGia>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }

    @GetMapping("/searchByMa")
    public ResponseEntity<List<PhieuGiamGia>> searchByMa(@RequestParam String ma) {
        return ResponseEntity.ok(service.searchByMa(ma));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PhieuGiamGia phieuGiamGia){
        return ResponseEntity.ok(service.add(phieuGiamGia));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody PhieuGiamGia phieuGiamGia){
        return ResponseEntity.ok(service.update(phieuGiamGia, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

}
