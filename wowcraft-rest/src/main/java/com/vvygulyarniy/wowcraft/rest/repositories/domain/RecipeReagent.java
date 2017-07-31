package com.vvygulyarniy.wowcraft.rest.repositories.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipe_reagent")
public class RecipeReagent {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "reagent_id")
    private Reagent reagent;
    @Column(name = "quantity")
    private Integer quantity;

    @Override
    public String toString() {
        return String.format("%d of %s (%.2f)", quantity, reagent.getName(), reagent.getPrice());
    }
}
