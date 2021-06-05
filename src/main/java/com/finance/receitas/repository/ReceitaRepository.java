package com.finance.receitas.repository;

import com.finance.receitas.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}