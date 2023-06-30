package com.example.quanlyungdungrestful.controller;

import com.example.quanlyungdungrestful.model.QuocGia;
import com.example.quanlyungdungrestful.service.IQuocGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class QuocGiaController {


    @Autowired
    IQuocGiaService iQuocGiaService;
    @GetMapping
    public ResponseEntity<Iterable<QuocGia>> showAll() {
        Iterable<QuocGia> categories = iQuocGiaService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
