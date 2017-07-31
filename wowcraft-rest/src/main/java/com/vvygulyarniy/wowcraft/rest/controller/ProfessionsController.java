package com.vvygulyarniy.wowcraft.rest.controller;

import com.vvygulyarniy.wowcraft.rest.controller.beans.RecipeInfo;
import com.vvygulyarniy.wowcraft.rest.repositories.ProfessionRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.RecipeRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("rest/professions")
public class ProfessionsController {

    private final ProfessionRepository professionRepo;
    private final RecipeRepository recipeRepository;

    @Autowired
    public ProfessionsController(final ProfessionRepository professionRepo,
                                 final RecipeRepository recipeRepository) {
        this.professionRepo = professionRepo;
        this.recipeRepository = recipeRepository;
    }


    @RequestMapping(method = GET)
    public List<Profession> allProfessions() {
        return professionRepo.findAll();
    }

    @RequestMapping(method = GET, value = "/{profession_id}")
    public Profession professionInfo(@PathVariable("profession_id") Long professionId) {
        return professionRepo.findOne(professionId);
    }

    @RequestMapping(method = GET, value = "/{profession_id}/recipes")
    public List<RecipeInfo> getRecipes(@PathVariable("profession_id") Long professionId) {
        return recipeRepository.findByProfessionId(professionId).stream().map(RecipeInfo::fromEntity).collect(toList());
    }


}
