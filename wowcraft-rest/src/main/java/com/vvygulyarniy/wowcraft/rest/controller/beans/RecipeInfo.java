package com.vvygulyarniy.wowcraft.rest.controller.beans;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Recipe;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.RecipeReagent;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.ToDoubleFunction;

@Data
public class RecipeInfo {
	private Long id;
	private String name;
	private ProfessionInfo professionInfo;
	private BigDecimal price;

	private RecipeInfo() {
	}

	public static RecipeInfo fromEntity(Recipe recipe) {
		RecipeInfo info = new RecipeInfo();
		info.setId(recipe.getId());
		info.setName(recipe.getName());
		info.setPrice(BigDecimal.valueOf(recipe.getComponents()
											   .stream()
											   .mapToDouble(reagentPrice())
											   .sum()));
		return info;
	}

	private static ToDoubleFunction<RecipeReagent> reagentPrice() {
		return item -> item.getReagent().getPrice().doubleValue() * item.getQuantity();
	}
}
