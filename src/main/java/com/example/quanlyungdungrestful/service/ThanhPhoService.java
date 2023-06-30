package com.example.quanlyungdungrestful.service;

import com.example.quanlyungdungrestful.model.QuocGia;
import com.example.quanlyungdungrestful.model.ThanhPho;
import com.example.quanlyungdungrestful.repository.IThanhPhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThanhPhoService implements IThanhPhoService {

    @Autowired
    IThanhPhoRepository iThanhPhoRepository;

    @Override
    public Iterable<ThanhPho> findAll() {
        return iThanhPhoRepository.findAll();
    }

    @Override
    public Optional<ThanhPho> findById(Long id) {
        return iThanhPhoRepository.findById(id);
    }

    @Override
    public ThanhPho save(ThanhPho thanhPho) {
        return iThanhPhoRepository.save(thanhPho);
    }

    @Override
    public void remove(Long id) {
        iThanhPhoRepository.deleteById(id);
    }

    @Override
    public Iterable<ThanhPho> findAllByTenThanhPhoContainingIgnoreCase(String name) {
        return iThanhPhoRepository.findAllByTenThanhPhoContainingIgnoreCase(name);
    }

//    @Override
//    public List<ThanhPho> findThanhPhoByQuocGia(QuocGia quocGia) {
//        return iThanhPhoRepository.findThanhPhoByQuocGia(quocGia);
//    }
}
