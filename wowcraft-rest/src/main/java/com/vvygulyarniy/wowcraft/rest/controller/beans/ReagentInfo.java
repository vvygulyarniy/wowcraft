package com.vvygulyarniy.wowcraft.rest.controller.beans;

import com.vvygulyarniy.wowcraft.rest.repositories.domain.Reagent;
import com.vvygulyarniy.wowcraft.rest.repositories.domain.RecipeReagent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ReagentInfo {
    private Long id;
    private String name;
    private ProfessionInfo profession;
    private BigDecimal price;

    private ReagentInfo(){}

    public static ReagentInfo fromEntity(Reagent reagent) {
        ReagentInfo info = new ReagentInfo();
        info.setId(reagent.getId());
        info.setName(reagent.getName());
        info.setProfession(ProfessionInfo.fromEntity(reagent.getProfession()));
        info.setPrice(reagent.getPrice());
        return info;
    }
}
