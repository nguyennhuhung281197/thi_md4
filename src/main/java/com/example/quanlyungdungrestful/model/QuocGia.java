package com.example.quanlyungdungrestful.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ten;

    public QuocGia() {
    }

    public QuocGia(Long id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenQuocGia() {
        return ten;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.ten = tenQuocGia;
    }
}
