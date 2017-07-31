package com.vvygulyarniy.wowcraft.rest.repositories.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reagent")
public class Reagent {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "profession_id")
	private Profession profession;
	@Column(name = "price")
	private BigDecimal price;
}
