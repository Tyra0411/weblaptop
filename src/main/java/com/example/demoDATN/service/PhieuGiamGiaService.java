package com.example.demoDATN.service;

import com.example.demoDATN.entity.PhieuGiamGia;
import com.example.demoDATN.repository.PhieuGiamGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PhieuGiamGiaService {
    @Autowired
    private PhieuGiamGiaRepo phieuGiamGiaRepo;

    public List<PhieuGiamGia> getAll() {
        return phieuGiamGiaRepo.findAll();
    }

    public Page<PhieuGiamGia> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return phieuGiamGiaRepo.findAll(pageable);
    }

    public List<PhieuGiamGia> searchByName(String name) {
        return phieuGiamGiaRepo.findByTenContainingIgnoreCase(name);
    }

    public List<PhieuGiamGia> searchByMa(String ma) {
        return phieuGiamGiaRepo.findByMaContainingIgnoreCase(ma);
    }

    public PhieuGiamGia add(PhieuGiamGia phieuGiamGia){
        return phieuGiamGiaRepo.save(phieuGiamGia);
    }

    public PhieuGiamGia update(PhieuGiamGia phieuGiamGia, int id) {
        Optional<PhieuGiamGia> optional = phieuGiamGiaRepo.findById(id);
        return optional.map(o -> {
            o.setMa(phieuGiamGia.getMa());
            o.setTen(phieuGiamGia.getTen());
            o.setMoTa(phieuGiamGia.getMoTa());
            o.setNgayBatDau(phieuGiamGia.getNgayBatDau());
            o.setNgayHetHan(phieuGiamGia.getNgayHetHan());
            o.setLoaiGiamGia(phieuGiamGia.getLoaiGiamGia());
            o.setGiaTriGiamGia(phieuGiamGia.getGiaTriGiamGia());
            o.setGiaTriDonToiThieu(phieuGiamGia.getGiaTriDonToiThieu());
            o.setGiamToiDa(phieuGiamGia.getGiamToiDa());
            o.setNgaySua(LocalDateTime.now());
            o.setNguoiSua(phieuGiamGia.getNguoiSua());

            if (phieuGiamGia.getTrangThai() != null) {
                o.setTrangThai(phieuGiamGia.getTrangThai());
            }

            return phieuGiamGiaRepo.save(o);
        }).orElse(null);
    }


    public PhieuGiamGia delete(int id){
        Optional<PhieuGiamGia> optional = phieuGiamGiaRepo.findById(id);
        return optional.map(o-> {
            phieuGiamGiaRepo.delete(o);
            return o;
        }).orElse(null);
    }
}
