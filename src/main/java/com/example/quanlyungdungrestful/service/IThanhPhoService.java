package com.example.quanlyungdungrestful.service;

import com.example.quanlyungdungrestful.model.QuocGia;
import com.example.quanlyungdungrestful.model.ThanhPho;

import java.util.List;

public interface IThanhPhoService extends IGeneralService<ThanhPho>{
    Iterable<ThanhPho> findAllByTenThanhPhoContainingIgnoreCase(String name);
//    List<ThanhPho> findThanhPhoByQuocGia(QuocGia quocGia);
}
