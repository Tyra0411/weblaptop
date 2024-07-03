package com.example.demoDATN.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phieu_giam_gia")
public class PhieuGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "ngay_bat_dau")
    private LocalDateTime ngayBatDau;

    @Column(name = "ngay_het_han")
    private LocalDateTime ngayHetHan;

    @Column(name = "loai_giam_gia")
    private String loaiGiamGia;

    @Column(name = "gia_tri_giam_gia")
    private BigDecimal giaTriGiamGia;

    @Column(name = "gia_tri_don_toi_thieu")
    private BigDecimal giaTriDonToiThieu;

    @Column(name = "giam_toi_da")
    private BigDecimal giamToiDa;

    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;

    @Column(name = "nguoi_tao")
    private String nguoiTao;

    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;

    @Column(name = "nguoi_sua")
    private String nguoiSua;

    @Column(name = "trang_thai")
    private String trangThai;
}
