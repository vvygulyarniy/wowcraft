package com.vvygulyarniy.wowcraft.rest.repositories;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Reagent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReagentRepository extends JpaRepository<Reagent, Long> {
}
