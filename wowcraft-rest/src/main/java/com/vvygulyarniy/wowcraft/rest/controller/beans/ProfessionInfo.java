package com.vvygulyarniy.wowcraft.rest.controller.beans;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Profession;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProfessionInfo {
	private Long id;
	private String name;

	private ProfessionInfo() {}

	public static ProfessionInfo fromEntity(Profession profession) {
		ProfessionInfo info = new ProfessionInfo();
		info.setId(profession.getId());
		info.setName(profession.getName());
		return info;
	}

}
