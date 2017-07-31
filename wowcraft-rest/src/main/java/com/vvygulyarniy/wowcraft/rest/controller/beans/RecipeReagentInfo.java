package com.vvygulyarniy.wowcraft.rest.controller.beans;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Reagent;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.RecipeReagent;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RecipeReagentInfo {
    private Long id;
    private String name;
    private Long professionId;
    private String professionName;
    private Integer quantity;
    private BigDecimal price;

    private RecipeReagentInfo(){}

    public static RecipeReagentInfo fromEntity(RecipeReagent reagent) {
        RecipeReagentInfo info = new RecipeReagentInfo();
        info.setId(reagent.getReagent().getId());
        info.setName(reagent.getReagent().getName());
        info.setQuantity(reagent.getQuantity());
        info.setPrice(reagent.getReagent().getPrice());
        return info;
    }
}
