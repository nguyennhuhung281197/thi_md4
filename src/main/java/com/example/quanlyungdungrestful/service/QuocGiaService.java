package com.example.quanlyungdungrestful.service;

import com.example.quanlyungdungrestful.model.QuocGia;
import com.example.quanlyungdungrestful.repository.IQuocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuocGiaService implements IQuocGiaService {
    @Autowired
    IQuocGiaRepository iQuocGiaRepository;

    @Override
    public Iterable<QuocGia> findAll() {
        return iQuocGiaRepository.findAll();
    }

    @Override
    public Optional<QuocGia> findById(Long id) {
        return iQuocGiaRepository.findById(id);
    }

    @Override
    public QuocGia save(QuocGia quocGia) {
        return iQuocGiaRepository.save(quocGia);
    }

    @Override
    public void remove(Long id) {
        iQuocGiaRepository.deleteById(id);
    }
}
