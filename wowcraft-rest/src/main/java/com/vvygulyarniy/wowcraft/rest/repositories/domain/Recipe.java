package com.vvygulyarniy.wowcraft.rest.repositories.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"profession", "components"})
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "profession_id", referencedColumnName = "id")
    private Profession profession;
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<RecipeReagent> components;
}
