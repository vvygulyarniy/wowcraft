package com.vvygulyarniy.wowcraft.rest.controller.beans;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Recipe;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;

@Data
public class RecipeDetails {
    private RecipeInfo basicInfo;
    private BigDecimal selfPrice = ZERO;
    private List<RecipeReagentInfo> reagents = new ArrayList<>();

    private RecipeDetails(){}

    public static RecipeDetails fromEntity(Recipe recipe) {
        RecipeDetails details = new RecipeDetails();
        details.setBasicInfo(RecipeInfo.fromEntity(recipe));
        recipe.getComponents().forEach(component -> {
            details.getReagents().add(RecipeReagentInfo.fromEntity(component));
            BigDecimal reagentPrice = component.getReagent().getPrice().multiply(BigDecimal.valueOf(component.getQuantity()));
            details.setSelfPrice(details.getSelfPrice().add(reagentPrice));
        });

        return details;
    }
}
