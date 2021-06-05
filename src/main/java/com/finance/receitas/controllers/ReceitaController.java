package com.finance.receitas.controllers;

import com.finance.receitas.entities.Receita;
import com.finance.receitas.services.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receitas")
public class ReceitaController {
    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }

    @GetMapping
    public ResponseEntity<List<Receita>> list(){
        return ResponseEntity.ok(receitaService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Receita> findById(@PathVariable Long id) {
        return ResponseEntity.ok(receitaService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Receita> save(@RequestBody @Valid Receita receita) {
        receitaService.replace(receita);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
















