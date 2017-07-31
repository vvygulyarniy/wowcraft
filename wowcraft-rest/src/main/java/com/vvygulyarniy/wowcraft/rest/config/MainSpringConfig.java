package com.vvygulyarniy.wowcraft.rest.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.vvygulyarniy.wowcraft.rest.repositories")
@EntityScan(value = "com.vvygulyarniy.wowcraft.rest")
@ComponentScan("com.vvygulyarniy.wowcraft.rest")
public class MainSpringConfig {

}
