package com.example.quanlyungdungrestful.repository;
import com.example.quanlyungdungrestful.model.QuocGia;
import com.example.quanlyungdungrestful.model.ThanhPho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IThanhPhoRepository extends JpaRepository<ThanhPho, Long>{
    Iterable<ThanhPho> findAllByTenThanhPhoContainingIgnoreCase(String name);

//    List<ThanhPho> findThanhPhoByQuocGia(QuocGia quocGia);
}
