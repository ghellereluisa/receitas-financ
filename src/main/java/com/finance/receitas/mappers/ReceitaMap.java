package com.finance.receitas.mappers;

import com.finance.receitas.entities.Receita;

@Mapper(componentModel = "spring")
public abstract class ReceitaMap {
    public static final ReceitaMap INSTANCE = Mappers.getMapper(ReceitaMap.class);

    public abstract Receita toReceita(Receita receita);
}
