package com.vvygulyarniy.wowcraft.rest.controller;

import com.vvygulyarniy.wowcraft.rest.controller.beans.RecipeAdditionRequest;
import com.vvygulyarniy.wowcraft.rest.controller.beans.RecipeDetails;
import com.vvygulyarniy.wowcraft.rest.controller.beans.RecipeInfo;
import com.vvygulyarniy.wowcraft.rest.repositories.ProfessionRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.ReagentRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.RecipeReagentRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.RecipeRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.Reagent;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.Recipe;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.RecipeReagent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("rest/recipes")
public class RecipeController {
	private final ReagentRepository reagentRepository;
	private final RecipeRepository recipeRepository;
	private final ProfessionRepository professionRepository;
	private final RecipeReagentRepository recipeReagentRepository;

	@Autowired
	public RecipeController(ReagentRepository reagentRepository,
							RecipeRepository recipeRepository,
							ProfessionRepository professionRepository,
							RecipeReagentRepository recipeReagentRepository) {
		this.reagentRepository = reagentRepository;
		this.recipeRepository = recipeRepository;
		this.professionRepository = professionRepository;
		this.recipeReagentRepository = recipeReagentRepository;
	}

	@RequestMapping(method = GET, value = "/{recipeId}")
	public RecipeDetails recipeInfo(@PathVariable("recipeId") Long recipeId) {
		return RecipeDetails.fromEntity(recipeRepository.findOne(recipeId));
	}

	@RequestMapping(method = PUT)
	public RecipeInfo save(@RequestBody RecipeAdditionRequest recipeInfo) {
		Map<Reagent, Integer> reagents = new HashMap<>(recipeInfo.getReagents().size());
		recipeInfo.getReagents().forEach(info -> reagents.put(reagentRepository.findOne(info.getId()),
															  info.getQuantity()));

		List<RecipeReagent> reagentsToSave = reagents.entrySet()
													 .stream()
													 .map(entry -> RecipeReagent.builder()
																				.reagent(entry.getKey())
																				.quantity(entry.getValue())
																				.build())
													 .collect(toList());



		Recipe recipe = Recipe.builder()
							  .name(recipeInfo.getName())
							  .profession(professionRepository.getOne(recipeInfo.getProfessionId()))
							  .build();


		Recipe savedRecipe = recipeRepository.save(recipe);
		reagentsToSave.forEach(reagent -> reagent.setRecipe(savedRecipe));
		List<RecipeReagent> components = recipeReagentRepository.save(reagentsToSave);
		savedRecipe.setComponents(components);
		return RecipeInfo.fromEntity(savedRecipe);
	}
}
