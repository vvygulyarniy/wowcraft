package com.vvygulyarniy.wowcraft.rest.controller;

import com.vvygulyarniy.wowcraft.rest.controller.beans.ReagentInfo;
import com.vvygulyarniy.wowcraft.rest.repositories.ProfessionRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.ReagentRepository;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.Reagent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/rest/reagents")
public class ReagentController {
	private final ReagentRepository repo;
	private final ProfessionRepository professionRepo;

	@Autowired
	public ReagentController(ReagentRepository repo, ProfessionRepository professionRepo) {
		this.repo = repo;
		this.professionRepo = professionRepo;
	}

	@RequestMapping(method = GET)
	public List<ReagentInfo> getAllReagents(){
		return repo.findAll().stream().map(ReagentInfo::fromEntity).collect(toList());
	}

	@RequestMapping(method = PUT)
	public void addNewReagent(@RequestBody ReagentInfo reagent) {
		Reagent entityToSave = Reagent.builder().name(reagent.getName())
							   .price(reagent.getPrice())
							   .profession(professionRepo.findOne(reagent.getProfession().getId()))
							   .build();
		repo.save(entityToSave);
	}

	@RequestMapping(method = PUT, value = "/{id}")
	public void addNewReagent(@RequestBody ReagentInfo reagent, @PathVariable("id") Long id) {
		Reagent reagentToEdit = repo.findOne(id);
		reagentToEdit.setPrice(reagent.getPrice());
		reagentToEdit.setName(reagent.getName());
		repo.save(reagentToEdit);
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	public void deleteReagent(@PathVariable("id") Long id) {
		repo.delete(id);
	}
}
