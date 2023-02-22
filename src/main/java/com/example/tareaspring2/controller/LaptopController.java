package com.example.tareaspring2.controller;
import com.example.tareaspring2.entities.Laptop;
import com.example.tareaspring2.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Value("${app.message}")
    String message;

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //atributos
    private LaptopRepository laptopRepository;
    //constructores

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    /**
     *http://localhost:8080/api/laptops
     * @return
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

/*
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

 */
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findBookById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
         if (laptopOpt.isPresent())
        return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if (laptop.getId() != null){
            log.warn("triying to create a laptop woth id");
            System.out.println("triying to create a laptop woth id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId() == null){
            log.warn("triying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("triying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public  ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)) {
            log.warn("triying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST request for delete all laptop");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
