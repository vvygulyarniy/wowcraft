package com.vvygulyarniy.wowcraft.rest;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class UnitTest {

	@Test(groups = "unit")
	public void myFirstUnitTest() throws Exception {
		assertThat(1).isEqualTo(1);
	}

	@Test(groups = "integration")
	public void myIntegrationTest() throws Exception {
		assertThat(2).isEqualTo(2);
	}
}
