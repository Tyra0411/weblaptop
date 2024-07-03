package com.example.demoDATN.repository;

import com.example.demoDATN.entity.PhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuGiamGiaRepo extends JpaRepository<PhieuGiamGia, Integer> {
    List<PhieuGiamGia> findByTenContainingIgnoreCase(String ten);
    List<PhieuGiamGia> findByMaContainingIgnoreCase(String ma);

}
