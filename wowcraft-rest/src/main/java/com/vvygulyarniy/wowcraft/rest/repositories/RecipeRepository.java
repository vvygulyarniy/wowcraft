package com.vvygulyarniy.wowcraft.rest.repositories;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(value = "select recipe from Recipe recipe where recipe.profession.id = ?1")
    List<Recipe> findByProfessionId(Long professionId);
}
