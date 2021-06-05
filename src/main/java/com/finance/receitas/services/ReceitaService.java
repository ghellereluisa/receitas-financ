package com.finance.receitas.services;

import com.finance.receitas.entities.Receita;
import com.finance.receitas.exceptions.BadRequestException;
import com.finance.receitas.mappers.ReceitaMap;
import com.finance.receitas.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReceitaService {

    public ReceitaService(ReceitaRepository receitaRepository){
        this.receitaRepository = receitaRepository;
    }

    public List<Receita> listAll(){
        return receitaRepository.findAll();
    }

    public Receita findByIdOrThrowBadRequestException(Long id){
        return receitaRepository.findById(id).orElseThrow(() -> new BadRequestException("Income not found!"));
    }

    @Transactional
    public Receita save(Receita receita){
        return receitaRepository.save(ReceitaMap.INSTANCE.toReceita(receita));
    }

    public void delete(Long id){
        receitaRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void edit(Receita receita){
        Receita savedReceita = findByIdOrThrowBadRequestException(receita.getId());
        Receita receita1 = ReceitaMap.INSTANCE.toReceita(receita);
        receita1.setId(savedReceita.getId());
        receitaRepository.save(receita1);
    }
}







