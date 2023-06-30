package com.example.quanlyungdungrestful.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenThanhPho;

    @ManyToOne
    @JoinColumn(name = "quocgia_id")
    private QuocGia quocGia;
    private int dienTich;
    private  int danSo;
    private String gdp;
    private String mota;

    public ThanhPho() {
    }

    public ThanhPho(Long id, String tenThanhPho, QuocGia quocGia, int dienTich, int danSo, String gdp, String mota) {
        this.id = id;
        this.tenThanhPho = tenThanhPho;
        this.quocGia = quocGia;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gdp = gdp;
        this.mota = mota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getDanSo() {
        return danSo;
    }

    public void setDanSo(int danSo) {
        this.danSo = danSo;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
