package com.vvygulyarniy.wowcraft.rest.repositories;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.RecipeReagent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeReagentRepository extends JpaRepository<RecipeReagent, Long> {
}
