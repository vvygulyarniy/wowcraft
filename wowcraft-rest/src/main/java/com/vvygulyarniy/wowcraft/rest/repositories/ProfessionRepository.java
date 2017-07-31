package com.vvygulyarniy.wowcraft.rest.repositories;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
