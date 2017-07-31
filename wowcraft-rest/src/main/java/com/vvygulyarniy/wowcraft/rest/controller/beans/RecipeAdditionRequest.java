package com.vvygulyarniy.wowcraft.rest.controller.beans;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeAdditionRequest {
	private Long professionId;
	private String name;
	private List<RecipeReagentInfo> reagents = new ArrayList<>();

	@Data

	public static final class RecipeReagentInfo {
		private Long id;
		private String name;
		private Integer quantity;
	}
}
