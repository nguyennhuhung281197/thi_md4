package com.example.quanlyungdungrestful.controller;

import com.example.quanlyungdungrestful.model.QuocGia;
import com.example.quanlyungdungrestful.model.ThanhPho;
import com.example.quanlyungdungrestful.service.IQuocGiaService;
import com.example.quanlyungdungrestful.service.IThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/city")
public class ThanhPhoController {

    @Autowired
    IThanhPhoService iThanhPhoService;

    @Autowired
    IQuocGiaService iQuocGiaService;

    @GetMapping
    public ResponseEntity<Iterable<ThanhPho>> findAllThanhPho() {
        Iterable<ThanhPho> thanhPhoIterable = iThanhPhoService.findAll();
        return new ResponseEntity<>(thanhPhoIterable, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ThanhPho>>findById(@PathVariable Long id) {
        Optional<ThanhPho> thanhPhoOptional = iThanhPhoService.findById(id);
        return new ResponseEntity<>(thanhPhoOptional, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ThanhPho> create(@RequestBody ThanhPho picture) {
        return new ResponseEntity<>(iThanhPhoService.save(picture), HttpStatus.CREATED);
    }


    @GetMapping("/search")
    public ResponseEntity<Iterable<ThanhPho>> search(@RequestParam("name") String name) {
        return ResponseEntity.ok(iThanhPhoService.findAllByTenThanhPhoContainingIgnoreCase(name));
    }

//    @GetMapping("/{id}")
//    public Iterable<ThanhPho> searchCategory(@PathVariable Long id){
//        QuocGia quocGia = iQuocGiaService.findById(id).orElse(null);
//        Iterable<ThanhPho> pictures = iThanhPhoService.findThanhPhoByQuocGia(quocGia);
//        return new ResponseEntity<>(pictures,HttpStatus.OK).getBody();
//    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<ThanhPho> deleteById(@PathVariable Long id) {
//       Optional<ThanhPho> thanhPhoOptional = iThanhPhoService.remove();
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ThanhPho city) {
        if (this.iThanhPhoService.findById(id).isPresent()) {
            city.setId(id);
            this.iThanhPhoService.save(city);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Xoá city
    @DeleteMapping("/{id}")
    public ResponseEntity<ThanhPho> deleteCity(@PathVariable Long id) {
        Optional<ThanhPho> cityOptional = iThanhPhoService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iThanhPhoService.remove(id);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.NO_CONTENT);
    }

}
